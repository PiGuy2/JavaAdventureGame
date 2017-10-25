package objects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Robby
 * 
 */
public class InteractiveItem extends Item {
	private static ArrayList<InteractiveItem> interactiveItems = new ArrayList<InteractiveItem>();
	private HashMap<String, String> commands;

	/**
	 * Create a new interactive item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public InteractiveItem (String name, String description) {
		super(name, description, true);
		commands = new HashMap<>();
		interactiveItems.add(this);
	}

	/**
	 * Prints all {@link InteractiveItem#InteractiveItem(String, String) Interactive
	 * Items}
	 */
	public static void printAll () {
		for (InteractiveItem i : interactiveItems) {
			System.out.println("A " + i.getDescription() + " " + i.getName() + ".");
		}
	}
}
