package objects;

import java.util.ArrayList;

/**
 * @author Robby
 *
 */
public class Room {
	private ArrayList<Item> itemsInArea;

	public Room () {
		itemsInArea = new ArrayList<>();
	}

	public Item getItem (String param) {
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
			if (matches.size() == 1) {
				return matches.get(0);
			} else if (matches.size() > 1) {
				// TODO too many items
			}
		}
		// TODO no matches
		return null;
	}
}
