package main;

import java.util.ArrayList;
import java.util.Arrays;

import character.Player;
import objects.InteractiveItem;
import objects.Item;
import objects.ProccessedItem;
import objects.Room;

/**
 * This is the main game class. The function {@link #runGame()} takes commands
 * from the user repeatedly until the game ends.
 *
 * @author Robby
 */
public class Game {
	private boolean canDie;
	private Room currentRoom;
	private Room deathRoom;

	private ArrayList<InteractiveItem> winItems;

	/**
	 * Constructor for objects of class Game
	 */
	public Game (Room startingRoom) {
		canDie = false;
		this.currentRoom = startingRoom;
		init();
	}

	public Game (Room deathRoom, Room startingRoom) {
		canDie = true;
		this.deathRoom = deathRoom;
		this.currentRoom = startingRoom;
		init();
	}

	// test:
	// go n nw south-east se; walk west n; help & crawl sw d down u
	// t red; t trench; take dagger; l; i; dr red; l; i
	// t lamp; i; eq lamp & i; eqd
	/**
	 * Runs the {@link Game}
	 *
	 * @return Whether the user has won the game.
	 */
	public boolean runGame () {
		look();
		mainloop: while (true) {
			System.out.println("----------");
			String wholeCmd = UserInput.get("What would you like to do");
			int num = 0;
			for (String cmd : wholeCmd.split("[;&]")) {
				num++;
				cmd = CommandParser.replaceCommand(cmd);
				String cmdAction = cmd.split(" ")[0];
				String [] cmdArgs = Arrays.copyOfRange(cmd.split(" "), 1, cmd.split(" ").length);
				Item lastI = null;
				for (InteractiveItem i : currentRoom.getItemsInArea()) {
					if (cmd.toLowerCase().contains(i.getName().toLowerCase())) {
						lastI = i;
						break;
					}
				}
				if (lastI != null && lastI.getClass() == ProccessedItem.class) {
					((ProccessedItem) lastI).call(cmd.split(" "));
				} else if (cmdAction.equals("look")) {
					if (cmdArgs.length == 0) {
						look();
					} else {
						if (cmdArgs[0].equals("at")) {
							cmdArgs = Arrays.copyOfRange(cmdArgs, 2, cmdArgs.length);
						}
						System.out.println("You can't look at things");
					}
				} else if (cmdAction.equals("go")) {
					if (cmdArgs.length == 0) {
						System.out.println("You must specify a direction to move.");
					}
					for (String i : cmdArgs) {
						Room possCurrentRoom = currentRoom.getRoomFromDir(i);
						if (possCurrentRoom == null) {
							System.out.println("You cannot move " + i);
						} else {
							currentRoom = possCurrentRoom;
							look();
						}
					}
				} else if (cmdAction.equals("take")) {
					Item itemToTake = currentRoom.getItem(String.join(" ", cmdArgs));
					if (itemToTake != null) {
						String itemName = itemToTake.getDescription() + " " + itemToTake.getName();
						itemName = itemName.trim();
						itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
						if (itemToTake.getClass().equals(InteractiveItem.class)) {
							InteractiveItem iTT = (InteractiveItem) itemToTake;
							if (iTT.isUnlocked() && iTT.isMoveable()) {
								Player.inventory.addItem(iTT);
								currentRoom.removeItem(iTT);
								System.out.println(itemName + " taken.");
							} else if (iTT.isUnlocked()) {
								System.out.println("You cannot take the " + itemName.toLowerCase());
							} else {
								System.out.println("You cannot take the " + itemName.toLowerCase()
										+ ", because " + iTT.lockMessage());
							}
						} else {
							System.out.println("You cannot take " + itemName.toLowerCase() + ".");
						}
					}
				} else if (cmdAction.equals("help")) {
					// TODO improve help
					System.out.println("Help:");
					String [] help = {
							"To use a command, type the command (or the shortcut) and then the arguments as shown in "
									+ "brackets on the following list.",
							"You can move different directions by using the \"go\" command, or by simply typing an "
									+ "abbreviation for a direction, such as \"n\" or \"sw\".",
							"\tYou can also move up and down, and use the shortcuts \"u\" and \"d\".",
							"", "Commands (shortcut) [format]:",
							"\tLook (l) [look] -  show room information and list items in the current room",
							"\tGo (g)  [go {direction or shortcut, such as north, n, northeast, north-east, ne, etc.} "
									+ "{additional directions can be added, ex. \"go n ne west s\"}] -  move to a "
									+ "different room",
							"\tInventory (i) [inventory] -  list items in inventory",
							"\tTake (t) [take {item name}] -  take an item in the room, moving it to your inventory",
							"\tDrop (dr) [drop {item name}] -  drop an item from your inventory",
							"\tQuit (q) [quit] -  quit the game"};
					for (String i : help) {
						System.out.println("\t" + i);
					}
				} else if (cmdAction.equals("inventory")) {
					Player.inventory.printAll();
				} else if (cmdAction.equals("drop")) {
					InteractiveItem itemToDrop = Player.inventory
							.getItem(String.join(" ", cmdArgs));
					if (itemToDrop != null) {
						String itemName = itemToDrop.getDescription() + " " + itemToDrop.getName();
						itemName = itemName.trim();
						itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
						if (itemToDrop.isMoveable()) {
							Player.inventory.removeItem(itemToDrop);
							currentRoom.addItem(itemToDrop);
							System.out.println(itemName + " dropped.");
						} else {
							System.out.println("You cannot drop the " + itemName.toLowerCase());
						}
					}
				} else if (cmdAction.equals("quit")) {
					break mainloop;
				} else {
					System.out.println("\"" + cmd + "\" is not a valid command, because " + "\""
							+ cmdAction + "\" is not a valid action yet.");
				}
				String [] cmdArray = wholeCmd.split("[;&]");
				if (num < cmdArray.length) {
					System.out.println("\n-----\n");
				}
			}
		}

		// if (winItems == null) {
		// return false;
		// }
		int cardCount = 0;
		for (InteractiveItem i : Player.inventory.getItems()) {
			if (i.getName().equals("card")) {
				cardCount++;
			}
		}
		return cardCount > 3;
	}

	/*
	 * look, go, take, use, break, help, type, move {item}, pull, press, remove,
	 * shoot, kill, open, wear [coat], equip [dagger]
	 */

	private void init () {
		winItems = new ArrayList<>();
		winItems.add((InteractiveItem) currentRoom.getItem("dagger"));
	}

	private void look () {
		currentRoom.printAll();
		currentRoom.printItems();
	}
}
