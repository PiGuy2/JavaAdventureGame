package objects;

import java.util.ArrayList;
import java.util.Collections;

import main.UserInput;

/**
 * @author Robby
 * @author Owen
 * 
 */
public class Item {
	protected String description;

	protected boolean isInteractive;

	protected String name;

	/**
	 * Create a new item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 * @param isInteractive
	 *            If this is {@code false} commands can not be run on this object
	 */
	public Item (String name, String description, boolean isInteractive) {
		this.name = name;
		this.description = description;
		this.isInteractive = isInteractive;
	}

	public static boolean checkItemNameMatch (Item item, String param) {
		String check = item.getDescription() + " " + item.getName();
		int matches = 0;
		for (String i : param.split(" +")) {
			for (String j : check.split(" +")) {
				if (i.equals(j)) {
					matches++;
					break;
				}
			}
		}
		return matches >= param.split(" +").length;
	}

	/**
	 * If multiple Items are found, the user is asked to select a single item from
	 * the list of items matching {@code param}.
	 * 
	 * @param param
	 * @return Returns an {@link Item#Item(String, String, boolean) Item} that is
	 *         found from the argument {@code param}. This function searches both
	 *         the description and name of all Items in the list. If the user
	 *         presses {@code enter} when prompted to select an item, {@code null}
	 *         is returned. {@code null} is returned if no items are found.
	 */
	public static Item getItem (ArrayList<Item> items, String param) {
		ArrayList<Item> area = new ArrayList<>(items);
		Collections.shuffle(area);
		ArrayList<Item> matches = getItemsFromList(area, param);
		if (matches.size() == 1) {
			return matches.get(0);
		} else if (matches.size() > 1) {
			while (true) {
				System.out.println("Which Item are you talking about?");
				for (Item i : matches) {
					i.printItem();
				}
				String specific = UserInput.get("What item would you like (Press enter to cancel)").trim();
				if (specific.equals("")) {
					return null;
				}
				ArrayList<Item> matches2 = getItemsFromList(matches, specific);
				if (matches2.size() == 1) {
					return matches2.get(0);
				} else if (matches2.size() < 1) {
					System.out.println("That item doesn't exist");
					return null;
				}
				matches = matches2;
			}
		} else {
			System.out.println("That item doesn't exist");
			return null;
		}
	}

	public static ArrayList<Item> getItemsFromList (ArrayList<Item> items, String param) {
		ArrayList<Item> matches = new ArrayList<>();
		for (int run = 0; run < 2; run++) {
			for (Item i : items) {
				if (run == 0) {
					if (checkItemNameMatch(i, param)) {
						matches.add(i);
					}
				} else {
					for (String s : param.split(" ")) {
						if (checkItemNameMatch(i, s)) {
							matches.add(i);
							break;
						}
					}
				}
			}
			if (matches.size() > 0) {
				return matches;
			}
		}
		return new ArrayList<>();
	}

	/**
	 * Gets the description of the Item
	 * 
	 * @return The description of the Item
	 */
	public String getDescription () {
		return description;
	}

	/**
	 * Gets whether the item is a Interactive item
	 * 
	 * @return {@code true} if the item is a Interactive item
	 */
	public boolean getInteractive () {
		return isInteractive;
	}

	/**
	 * Gets the name of the Item
	 * 
	 * @return The name of the Item
	 */
	public String getName () {
		return name;
	}

	/**
	 * Prints the name of the Item in the form: A {@code (Item description)}
	 * {@code (Item name)}.
	 */
	public void printItem () {
		String printDescription = new String(description);
		if (!description.equals("")) {
			printDescription += " ";
		}
		System.out.println("A " + printDescription + name + ".");
	}

	/**
	 * Sets the description of the item
	 * 
	 * @param description
	 *            is the new description of the item
	 */
	public void setDescription (String description) {
		this.description = description;
	}
}
