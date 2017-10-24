package objects;

import java.util.ArrayList;

/**
 * @author Robby
 */
public class InteractableItem extends Item {
	private static ArrayList<InteractableItem> interactableItems = new ArrayList<InteractableItem>();

	/**
	 * Create a new item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public InteractableItem (String name, String description) {
		super(name, description, true);
		interactableItems.add(this);
	}

	public static void printAll () {
		for (InteractableItem i : interactableItems) {
			System.out.println("A " + i.getDescription() + " " + i.getName() + ".");
		}
	}
}
