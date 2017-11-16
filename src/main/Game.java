package main;

import java.util.Arrays;

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

	/**
	 * Constructor for objects of class Game
	 */
	public Game (Room startingRoom) {
		canDie = false;
		this.currentRoom = startingRoom;
	}

	public Game (Room deathRoom, Room startingRoom) {
		canDie = true;
		this.deathRoom = deathRoom;
		this.currentRoom = startingRoom;
	}

	/*
	 * look, go, take, use, break, help, type, move {item}, pull, press, remove,
	 * shoot, kill, open, wear [coat], equip [dagger]
	 */

	public boolean runGame () {
		mainloop: while (true) {
			String wholeCmd = UserInput.get("What would you like to do");
			for (String cmd : wholeCmd.split("[;&]")) {
				cmd = CommandParser.replaceCommand(cmd);
				String cmdAction = cmd.split(" ")[0];
				String [] cmdArgs = Arrays.copyOfRange(cmd.split(" "), 1, cmd.split(" ").length);
				if (cmdAction.equals("look")) {
					if (cmdArgs.length == 0) {
						currentRoom.printAll();
						currentRoom.printItems();
					} else {
						if (cmdArgs[0].equals("at")) {
							cmdArgs = Arrays.copyOfRange(cmdArgs, 2, cmdArgs.length);
						}
						System.out.println("You can't look at things");
					}
				} else if (cmdAction.equals("go")) {
					for (String i : cmdArgs) {
						Room possCurrentRoom = currentRoom.getRoomFromDir(i);
						if (possCurrentRoom == null) {
							System.out.println("You cannot move " + i);
						} else {
							currentRoom = possCurrentRoom;
							System.out.println("Room changed");
						}
					}
				} else if (cmdAction.equals("take")) {
					System.out.println("cmd: take");
				} else if (cmdAction.equals("use")) {
					System.out.println("cmd: use");
				} else if (cmdAction.equals("break")) {
					System.out.println("cmd: break");
				} else if (cmdAction.equals("help")) {
					System.out.println("cmd: help");
				} else if (cmdAction.equals("type")) {
					System.out.println("cmd: type");
				} else if (cmdAction.equals("move")) {
					System.out.println("cmd: move");
				} else if (cmdAction.equals("pull")) {
					System.out.println("cmd: pull");
				} else if (cmdAction.equals("press")) {
					System.out.println("cmd: press");
				} else if (cmdAction.equals("remove")) {
					System.out.println("cmd: remove");
				} else if (cmdAction.equals("shoot")) {
					System.out.println("cmd: shoot");
				} else if (cmdAction.equals("kill")) {
					System.out.println("cmd: kill");
				} else if (cmdAction.equals("open")) {
					System.out.println("cmd: open");
				} else if (cmdAction.equals("wear")) {
					System.out.println("cmd: wear");
				} else if (cmdAction.equals("equip")) {
					System.out.println("cmd: equip");
				} else if (cmdAction.equals("quit")) {
					break mainloop;
				} else {
					System.out.println("\"" + cmd + "\" is not a valid command, because " + "\"" + cmdAction
							+ "\" is not a valid action yet.");
				}
			}
		}
		return true;
	}
}
