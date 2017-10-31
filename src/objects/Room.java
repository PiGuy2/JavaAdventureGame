package objects;

import java.util.ArrayList;

import main.UserInput;

/**
 * @author Robby
 *
 */
public class Room {
	private ArrayList<InteractiveItem> itemsInArea;
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
	public Room (ArrayList<InteractiveItem> itemsInArea) {
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
	public Room (ArrayList<InteractiveItem> itemsInArea, ArrayList<BackgroundItem> backgroundItems) {
		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;
	}

	/**
	 * If multiple Items are found, the user is asked to select a single item from
	 * the list of items matching {@code param}.
	 * 
	 * @param param
	 * @return Returns an {@link InteractiveItem#InteractiveItem(String, String)
	 *         InteractiveItem} that is found from the argument {@code param}. This
	 *         function searches both the description and name of all
	 *         InteractiveItems in the room. If the user presses {@code enter} when
	 *         prompted to select an item, {@code null} is returned. {@code null} is
	 *         returned if no items are found.
	 */
	public InteractiveItem getItem (String param) {
		ArrayList<InteractiveItem> matches = getItemsFromList(itemsInArea, param);
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
				ArrayList<InteractiveItem> matches2 = getItemsFromList(matches, specific);
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

	private ArrayList<InteractiveItem> getItemsFromList (ArrayList<InteractiveItem> items, String param) {
		ArrayList<InteractiveItem> matches = new ArrayList<>();
		// start ----- TODO Possible confusing code
		for (int run = 0; run < 2; run++) {
			for (InteractiveItem i : items) {
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
}
