package objects;

import java.util.ArrayList;

/**
 * @author Robby
 * 
 */
public class Item {
	private static ArrayList<Item> items = new ArrayList<Item>();
	protected String description;

	protected boolean isBackground;

	protected String name;

	/**
	 * Create a new item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 * @param isBackground
	 *            If this is {@code true} commands can not be run on this object
	 */
	public Item (String name, String description, boolean isBackground) {
		this.name = name;
		this.description = description;
		this.isBackground = isBackground;
		items.add(this);
	}

	/**
	 * Prints all {@link Item#Item(String, String, boolean) Items}
	 */
	public static void printAll () {
		for (Item i : items) {
			String type = (i.getBackground()) ? "interactable" : "background";
			System.out.println("A " + type + " " + i.getDescription() + " " + i.getName() + ".");
		}
	}

	// TODO getter and setter docs?

	public boolean getBackground () {
		return isBackground;
	}

	public String getDescription () {
		return description;
	}

	public String getName () {
		return name;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public void setName (String name) {
		this.name = name;
	}
}
