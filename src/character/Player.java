package character;

import java.util.ArrayList;

import objects.InteractiveItem;

/**
 * Class to store the user's {@link #inventory} and {@link #equippedItems
 * equipped items}.
 *
 * @author Owen
 * @author Robby
 */
public class Player {
	/**
	 * An ArrayList of items the user has equipped.
	 */
	public static ArrayList<InteractiveItem> equippedItems = new ArrayList<InteractiveItem>();
	/**
	 * The user's inventory
	 */
	public static Inventory inventory = new Inventory();
}
