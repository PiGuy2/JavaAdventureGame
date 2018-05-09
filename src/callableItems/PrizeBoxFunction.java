package callableItems;

import character.Player;
import objects.Card;

/**
 * @author Tim
 * @author Robby
 *
 */

public class PrizeBoxFunction implements CallableItemFunction, CallableItemDescription {
	private Card card;

	public PrizeBoxFunction (Card c) {
		card = c;
	}

	@Override
	public void call (String [] args) {
		for (String i : args) {
			if (i.toLowerCase().equals("look") || i.toLowerCase().equals("search")) {
				if (card != null) {
					// getting joker
					Player.inventory.addItem(card);
					card = null;
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
		if (card == null) {
			return "empty";
		}
		return "prize";
	}
}
