package main;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Robby
 *
 */
public class UserInput {
    static Scanner scan = new Scanner(System.in);

    /**
     * Similar to {@link #getString(String)}, but includes error catching. This adds
     * {@code ": "} to the end of {@code prompt}
     * 
     * @param prompt
     *            is printed before user input is read
     * @return String read from {@code System.in} using {@code Scanner.nextLine()},
     *         or an empty {@code String} if {@code NoSuchElementException} is
     *         raised 3 times
     */
    public static String get (String prompt) {
        System.out.print(prompt + ": ");
        for (int i = 0; i < 3; i++) {
            try {
                return scan.nextLine();
            } catch (NoSuchElementException e) {
                continue;
            }
        }
        return "";
    }

    public static boolean getBool (String prompt) {
        while (true) {
            String resp = get(prompt);
            if (resp.startsWith("y") || resp.equals("sure") || resp.equals("ok")) {
                return true;
            }
            if (resp.startsWith("n")) {
                return false;
            }
            System.out.println("Please enter 'yes' or 'no'");
        }
    }

    /**
     * @return String read from {@code System.in} using {@code Scanner.nextLine()}
     * @throws NoSuchElementException
     *             if no line was found
     */
    public static String getString () {
        return scan.nextLine();
    }
    
    /**
     * Similar to {@link #getString()}, but prints out {@code prompt} before reading
     * user input
     * 
     * @param prompt
     *            is printed before user input is read
     * @return String read from {@code System.in} using {@code Scanner.nextLine()}
     * @throws NoSuchElementException
     *             if no line was found
     */
    public static String getString (String prompt) {
        System.out.print(prompt);
        return getString();
    }
}
