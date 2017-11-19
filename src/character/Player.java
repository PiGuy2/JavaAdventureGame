package character;

import java.util.ArrayList;

import objects.InteractiveItem;

/**
 * Class to store the user's {@link #inventory} and {@link #equippedItems
 * equipped items}.
 *
 * @author Owen
 */
public class Player {
	/**
	 * The user's inventory
	 */
	public static Inventory inventory = new Inventory();
	/**
	 * An ArrayList of items the user has equipped.
	 */
	public static ArrayList<InteractiveItem> equippedItems = new ArrayList<InteractiveItem>();
}
