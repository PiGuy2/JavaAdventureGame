package callableItems;

import character.Player;
import objects.InteractiveItem;

/**
 * @author Owen
 * @author Tim
 * @author Robby
 *
 */

public class PrizeBoxFunction implements CallableItemFunction, CallableItemDescription {
	private boolean hasJoker = false;

	@Override
	public void call (String [] args) {
		for (String i : args) {
			if (i.toLowerCase().equals("look") || i.toLowerCase().equals("search")) {
				if (!hasJoker) {
					// getting joker
					Player.inventory.addItem(new InteractiveItem("Joker", "Red"));
					hasJoker = true;
				} else {
					System.out.println("hey wumbo, you already have it XD");
				}
				return;
			}
		}
		System.out.println("you cannot do that dummy.");
	}

	@Override
	public String getDescription () {
		if (hasJoker) {
			return "empty";
		}
		return "prize";
	}
}
