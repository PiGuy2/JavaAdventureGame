package main;

import java.util.Arrays;

import character.Player;
import objects.InteractiveItem;
import objects.Item;
import objects.Room;

/**
 * This is the main game class. The function {@link Game#Game.runGame()
 * runGame()} takes commands from the user repeatedly until the game ends.
 *
 * @author Robby
 */
public class Game {
	private boolean canDie;
	private Room currentRoom;
	private Room deathRoom;

	private Item winItem;

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
	public boolean runGame () {
		look();
		mainloop: while (true) {
			System.out.println("----------");
			String wholeCmd = UserInput.get("What would you like to do");
			for (String cmd : wholeCmd.split("[;&]")) {
				cmd = CommandParser.replaceCommand(cmd);
				String cmdAction = cmd.split(" ")[0];
				String [] cmdArgs = Arrays.copyOfRange(cmd.split(" "), 1, cmd.split(" ").length);
				if (cmdAction.equals("look")) {
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
							Player.inventory.addItem((InteractiveItem) itemToTake);
							currentRoom.removeItem((InteractiveItem) itemToTake);
							System.out.println(itemName + " taken.");
						} else {
							System.out.println("You cannot take " + itemName.toLowerCase() + ".");
						}
					}
				} else if (cmdAction.equals("use")) {
					// TODO "use" command
					System.out.println("cmd: use");
				} else if (cmdAction.equals("break")) {
					// TODO "break" command
					System.out.println("cmd: break");
				} else if (cmdAction.equals("help")) {
					// TODO improve help
					System.out.println("Help:");
					String [] help = {
							"To use a command, type the command (or the shortcut) and then the arguments as shown in "
									+ "brackets on the following list.",
							"You can move different directions by using the \"go\" command, or by simply typing an "
									+ "abbreviation for a direction, such as \"n\" or \"sw\".",
							"\tYou can also move up and down, and use the shortcuts \"u\" and \"d\".", "",
							"Commands (shortcut) [format]:",
							"\tLook (l) [look] -  show room information and list items in the current room",
							"\tGo (g)  [go {direction or shortcut, such as north, n, northeast, north-east, ne, etc.} "
									+ "{additional directions can be added, ex. \"go n ne west s\"}] -  move to a "
									+ "different room",
							"\tInventory (i) [inventory] -  list items in inventory",
							"\tTake (t) [take {item name}] -  take an item in the room, moving it to your inventory",
							"\tDrop (dr) [drop {item name}] -  drop an item from your inventory",
							"\tEquip (eq) [equip {item name}] - equip an item from your inventory",
							"\tUnquip (ueq) [unequip {item name}] - unequip an item and move it to your inventory",
							"\tEquipped (eqd) [equipped] - list equipped items", "\tQuit (q) [quit] -  quit the game"};
					for (String i : help) {
						System.out.println("\t" + i);
					}
				} else if (cmdAction.equals("type")) {
					// TODO find out what the "type" command is
					System.out.println("cmd: type");
				} else if (cmdAction.equals("move")) {
					// TODO "move" command
					System.out.println("cmd: move");
				} else if (cmdAction.equals("pull")) {
					// TODO "pull" command
					System.out.println("cmd: pull");
				} else if (cmdAction.equals("press")) {
					// TODO "press" command
					System.out.println("cmd: press");
				} else if (cmdAction.equals("remove")) {
					// TODO find out what the "remove" command is
					System.out.println("cmd: remove");
				} else if (cmdAction.equals("shoot")) {
					// TODO "shoot" command
					System.out.println("cmd: shoot");
				} else if (cmdAction.equals("kill")) {
					// TODO "kill" command
					System.out.println("cmd: kill");
				} else if (cmdAction.equals("open")) {
					// TODO "open" command
					System.out.println("cmd: open");
				} else if (cmdAction.equals("wear")) {
					// TODO find out what the "wear" command is
					System.out.println("cmd: wear");
				} else if (cmdAction.equals("equip")) {
					// Equips an item from the inventory
					InteractiveItem itemToEquip = Player.inventory.getItem(String.join(" ", cmdArgs));
					if (itemToEquip != null) {
						String itemName = itemToEquip.getDescription() + " " + itemToEquip.getName();
						itemName = itemName.trim();
						itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
						Player.inventory.removeItem(itemToEquip);
						Player.equippedItems.add(itemToEquip);
						System.out.println(itemName + " equipped.");
					}
				} else if (cmdAction.equals("unequip")) {
					InteractiveItem itemToUnequip = (InteractiveItem) Item.getItem(Player.equippedItems,
							String.join(" ", cmdArgs));
					if (itemToUnequip != null) {
						String itemName = itemToUnequip.getDescription() + " " + itemToUnequip.getName();
						itemName = itemName.trim();
						itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
						Player.equippedItems.remove(itemToUnequip);
						Player.inventory.addItem(itemToUnequip);
						System.out.println(itemName + " unequipped.");
					}
				} else if (cmdAction.equals("inventory")) {
					Player.inventory.printAll();
				} else if (cmdAction.equals("equipped")) {
					if (Player.equippedItems.size() > 0) {
						System.out.println("You have equipped:");
						for (Item i : Player.equippedItems) {
							System.out.print("\t");
							i.printItem();
						}
					} else {
						System.out.println("You have no items equipped.");
					}
				} else if (cmdAction.equals("drop")) {
					InteractiveItem itemToDrop = Player.inventory.getItem(String.join(" ", cmdArgs));
					if (itemToDrop != null) {
						String itemName = itemToDrop.getDescription() + " " + itemToDrop.getName();
						itemName = itemName.trim();
						itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
						Player.inventory.removeItem(itemToDrop);
						currentRoom.addItem(itemToDrop);
						System.out.println(itemName + " taken.");
					}
				} else if (cmdAction.equals("quit")) {
					break mainloop;
				} else {
					System.out.println("\"" + cmd + "\" is not a valid command, because " + "\"" + cmdAction
							+ "\" is not a valid action yet.");
				}
			}
		}
		if (winItem == null) {
			return false;
		}
		return Player.inventory.getItems().contains(winItem);
	}

	/*
	 * look, go, take, use, break, help, type, move {item}, pull, press, remove,
	 * shoot, kill, open, wear [coat], equip [dagger]
	 */

	private void init () {
		winItem = currentRoom.getItem("dagger");
	}

	private void look () {
		currentRoom.printAll();
		currentRoom.printItems();
	}
}
