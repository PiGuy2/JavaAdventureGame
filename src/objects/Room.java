package objects;

import java.util.ArrayList;

import main.UserInput;

/**
 * @author Robby
 *
 */
public class Room {
	private ArrayList<Item> itemsInArea;

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 */
	public Room () {
		itemsInArea = new ArrayList<>();
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
		} else {
			// TODO no matches
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
