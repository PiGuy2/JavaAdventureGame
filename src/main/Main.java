package main;

import objects.Room;

/**
 * @author Robby
 *
 */
public class Main {
	/**
	 * Main method
	 * 
	 * @param args
	 *            This is just so Eclipse is happy!
	 */
	public static void main (String [] args) {
		while (true) {
			System.out.println("Enter 'help' (or 'h') for instructions.\n");
			System.out.println("-------------------------\n");
			Room startRoom = RoomInit.makeRooms();
			Game game = new Game(startRoom);
			boolean win = game.runGame();
			System.out.println("\n-------------------------");
			System.out.print("       You ");
			System.out.println(win ? "won! :)" : "lost :(");
			System.out.println("-------------------------\n");
			boolean quit = UserInput.getBool("Would you like to play again");
			if (!quit) {
				break;
			}
		}
	}
}
