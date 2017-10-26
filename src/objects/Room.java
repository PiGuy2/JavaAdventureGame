package objects;

import java.util.ArrayList;

import main.UserInput;

/**
 * @author Robby
 *
 */
public class Room {
	private ArrayList<Item> itemsInArea;
	private ArrayList<BackgroundItem> backgroundItems;

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 */
	public Room () {
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
	public Room (ArrayList<Item> itemsInArea) {
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
	 *            is a HashMap<String, String> of names and descriptions of items
	 */
	public Room (ArrayList<Item> itemsInArea, ArrayList<BackgroundItem> backgroundItems) {
		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;
	}

	// TODO documentation
	public Item getItem (String param) {
		ArrayList<Item> matches = getItemsFromList(itemsInArea, param);
		if (matches.size() == 1) {
			return matches.get(0);
		} else if (matches.size() > 1) {
			System.out.println("Which Item are you talking about?");
			for (Item i : matches) {
				System.out.println(i.getName());
			}
			String specific = UserInput.get("What item would you like (Press enter to cancel)");
			if (specific.equals("")) {
				//
			}
		} else {
			return null;
		}
		return null;
	}

	private ArrayList<Item> getItemsFromList (ArrayList<Item> items, String param) {
		ArrayList<Item> matches = new ArrayList<>();
		for (int run = 0; run < 2; run++) {
			for (Item i : itemsInArea) {
				if (run == 0) {
					if (i.getName().contains(param)) {
						matches.add(i);
					}
				} else {
					for (String s : param.split(" ")) {
						if (i.getName().contains(s)) {
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
}
