package main;

import java.util.ArrayList;

import objects.Room;

/**
 * This is the main game class. The function {@link Game#Game.runGame()
 * runGame()} takes commands from the user repeatedly until the game ends.
 *
 * @author Robby
 * @version (a version number or a date)
 */
public class Game {
	private boolean canDie;
	private Room deathRoom;
	private ArrayList<Room> rooms;
	private Room startingRoom;

	/**
	 * Constructor for objects of class Game
	 */
	public Game (Room startingRoom) {
		canDie = false;
		this.startingRoom = startingRoom;
	}

	public Game (Room deathRoom, Room startingRoom) {
		canDie = true;
		this.deathRoom = deathRoom;
		this.startingRoom = startingRoom;
	}

	public boolean runGame () {
		String cmd = CommandParser.replaceCommand(UserInput.get("What would you like to do"));
		String cmdAction = cmd.split(" ")[0];
		if (cmdAction.equals("look")) {
			// look
		}
		while (true) {
			if (true) {
				break;
			}
		}
		return true;
	}
}
