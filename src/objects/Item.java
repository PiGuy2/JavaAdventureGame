package objects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Robby
 */
public class Item {
	protected String name;
	protected String description;

	protected boolean isBackground;
	public HashMap<String, String> commands;

	private static ArrayList<Item> items = new ArrayList<Item>();

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
		commands = new HashMap<String, String>();
		items.add(this);
	}

	public static void printAll () {
		for (Item i : items) {
			String type = (i.getBackground()) ? "interactable" : "background";
			System.out.println("A " + type + " " + i.getDescription() + " " + i.getName() + ".");
		}
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getDescription () {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public boolean getBackground () {
		return isBackground;
	}
}
