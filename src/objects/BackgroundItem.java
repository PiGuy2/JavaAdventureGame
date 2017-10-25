package objects;

import java.util.ArrayList;

/**
 * @author Robby
 * 
 */
public class BackgroundItem extends Item {
	public static ArrayList<BackgroundItem> backgroundItems = new ArrayList<BackgroundItem>();

	/**
	 * Create a new background item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public BackgroundItem (String name, String description) {
		super(name, description, false);
		backgroundItems.add(this);
	}

	/**
	 * Prints all {@link BackgroundItem#BackgroundItem(String, String) Background
	 * Items}
	 */
	public static void printAll () {
		for (BackgroundItem i : backgroundItems) {
			System.out.println("A " + i.getDescription() + " " + i.getName() + ".");
		}
	}
}
