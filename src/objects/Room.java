package objects;

import java.util.ArrayList;
import java.util.Collections;

import main.UserInput;

/**
 * @author Robby
 *
 */
public class Room {
	private String name;
	private String description;
	private String extDescription;
	private ArrayList<InteractiveItem> itemsInArea;
	private ArrayList<BackgroundItem> backgroundItems;

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 */
	public Room () {
		name = "";
		description = "";
		extDescription = "";

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 */
	public Room (String name) {
		this.name = name;
		description = "";
		extDescription = "";

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 */
	public Room (String name, String description) {
		this.name = name;
		this.description = description;
		extDescription = "";

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 * @param extDescription
	 *            is printed on a new line after the name and description
	 */
	public Room (String name, String description, String extDescription) {
		this.name = name;
		this.description = description;
		this.extDescription = extDescription;

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items}, backgroundItems items, and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param itemsInArea
	 *            is an ArrayList of Items that are in the room
	 */
	public Room (ArrayList<InteractiveItem> itemsInArea) {
		name = "";
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();
	}

	public Room (String name, ArrayList<InteractiveItem> itemsInArea) {
		this.name = name;
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 */
	public Room (String name, String description, ArrayList<InteractiveItem> itemsInArea) {
		this.name = name;
		this.description = description;
		extDescription = "";

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 * @param extDescription
	 *            is printed on a new line after the name and description
	 */
	public Room (String name, String description, String extDescription,
			ArrayList<InteractiveItem> itemsInArea) {
		this.name = name;
		this.description = description;
		this.extDescription = extDescription;

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items}, backgroundItems items, and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param itemsInArea
	 *            is an ArrayList of Items that are in the room
	 * @param backgroundItems
	 *            is an ArrayList of
	 *            {@link BackgroundItem#BackgroundItem(String, String) background
	 *            items}
	 */
	public Room (ArrayList<InteractiveItem> itemsInArea,
			ArrayList<BackgroundItem> backgroundItems) {
		name = "";
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;
	}

	public Room (String name, ArrayList<InteractiveItem> itemsInArea,
			ArrayList<BackgroundItem> backgroundItems) {
		this.name = name;
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 */
	public Room (String name, String description, ArrayList<InteractiveItem> itemsInArea,
			ArrayList<BackgroundItem> backgroundItems) {
		this.name = name;
		this.description = description;
		extDescription = "";

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 * @param extDescription
	 *            is printed on a new line after the name and description
	 */
	public Room (String name, String description, String extDescription,
			ArrayList<InteractiveItem> itemsInArea, ArrayList<BackgroundItem> backgroundItems) {
		this.name = name;
		this.description = description;
		this.extDescription = extDescription;

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;
	}

	// ------------------------- END CONSTUCTORS -------------------------

	/**
	 * If multiple Items are found, the user is asked to select a single item from
	 * the list of items matching {@code param}.
	 * 
	 * @param param
	 * @return Returns an {@link Item#Item(String, String, boolean) Item} that is
	 *         found from the argument {@code param}. This function searches both
	 *         the description and name of all InteractiveItems in the room. If the
	 *         user presses {@code enter} when prompted to select an item,
	 *         {@code null} is returned. {@code null} is returned if no items are
	 *         found.
	 */
	public Item getItem (String param) {
		ArrayList<Item> area = new ArrayList<>();
		area.addAll(itemsInArea);
		area.addAll(backgroundItems);
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
				String specific = UserInput.get("What item would you like (Press enter to cancel)")
						.trim();
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

	private ArrayList<Item> getItemsFromList (ArrayList<Item> items, String param) {
		ArrayList<Item> matches = new ArrayList<>();
		// start ----- TODO Possible confusing code
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
		// end -----
		return new ArrayList<>();
	}

	private boolean checkItemNameMatch (Item item, String param) {
		String check = item.getDescription() + " " + item.getName();
		return check.contains(param);
	}

	/**
	 * Prints room name, description, and extended description
	 */
	public void printAll () {
		printRoom();
		System.out.println(extDescription);
	}

	/**
	 * Prints room name and description
	 */
	public void printRoom () {
		System.out.println("You are in a " + description + " " + name);
	}

	/**
	 * Prints all items in the Room
	 */
	public void printItems () {
		ArrayList<Item> mixedItems = new ArrayList<>();
		mixedItems.addAll(itemsInArea);
		mixedItems.addAll(backgroundItems);
		Collections.shuffle(mixedItems);
		for (Item i : mixedItems) {
			i.printItem();
		}
	}
}
 