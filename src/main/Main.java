package main;

/**
 * @author Robby
 *
 */
public class Main {
    /**
     * @param args
     */
    public static void main (String [] args) {
        while (true) {
            Game game = new Game();
            boolean win = game.runGame();
            System.out.print("You ");
            System.out.println(win ? "won!" : "lost :(");
            boolean quit = UserInput.getBool("Would you like to play again");
            if (!quit) {
                break;
            }
        }
    }
}
