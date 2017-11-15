package main;

import objects.Room;

/**
 * This is the main game class. The function {@link Game#Game.runGame()
 * runGame()} takes commands from the user repeatedly until the game ends.
 *
 * @author Robby
 */
public class Game {
	private boolean canDie;
	private Room deathRoom;
	private Room currentRoom;

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

	public boolean runGame () {
		while (true) {
			String cmd = CommandParser.replaceCommand(UserInput.get("What would you like to do"));
			String cmdAction = cmd.split(" ")[0];
			if (cmdAction.equals("look")) {
				currentRoom.printAll();
				currentRoom.printItems();
			}
			break;
		}
		return true;
	}
}
