package callableItems;

import character.Player;
import objects.Card;
import objects.InteractiveItem;

/**
 * @author Robby
 * @author Tim
 */
public class SecretTableFunction implements CallableItemFunction {
	Card [] [] tableCards = new Card [2] [5]; // red, black

	@Override
	public void call (String [] args) {
		int tk = 0;
		for (String i : args) {
			if (i.trim().toLowerCase().equals("look")) {
				tk = 1;
			} else if (i.trim().toLowerCase().contains("card")
					|| i.trim().toLowerCase().contains("put")) {
				tk = 2;
			} else {
				continue;
			}
			break;
		}
		if (tk == 0) {
			System.out.println("You can't do that.");
		} else if (tk == 1) {
			System.out.println(this);
		} else if (tk == 2) {
			Card [] cards = new Card [6];
			String [] ranks = {"Diamonds", "Hearts", "Spades", "Clubs"};
			int c = 0;
			for (String r : ranks) {
				cards[c] = new Card("Ace", r);
				c++;
			}
			String [] colors = {"Black", "Red"};
			for (String cl : colors) {
				cards[c] = new Card("Joker", cl);
				c++;
			}

			for (InteractiveItem i : Player.inventory.getItems()) {
				for (Card card : cards) {
					System.out.println(i.toString() + " : " + card.toString());
					if (i.equals(card)) {
						Card add = (Card) i;
						int indx = add.getDescription().equals("Red") ? 1 : 0;
						if (add.getName().equals("Joker")) {
							tableCards[indx][0] = add;
							Player.inventory.removeItem(add);
							break;
						}
						for (int j = 0; j < tableCards[indx].length - 1; j++) {
							if (tableCards[indx][j] == null) {
								tableCards[indx][j] = add;
								Player.inventory.removeItem(add);
								break;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String toString () {
		String r = "";
		Card [] [] tc = new Card [5] [2];
		for (int i = 0; i < tableCards.length; i++) {
			for (int j = 0; j < tableCards[0].length; j++) {
				tc[j][i] = tableCards[i][j];
			}
		}
		for (Card [] i : tc) {
			if (i[0] == null) {
				System.out.print("\t");
			} else {
				System.out.print(i[0]);
			}
			// -----
			System.out.print("\t|\t");
			// -----
			if (i[1] != null) {
				System.out.print(i[1]);
			}
			// -----
			System.out.println();
		}
		return r;
	}
}
