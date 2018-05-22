package callableItems;

import java.util.ArrayList;

import character.Player;
import objects.Card;
import objects.InteractiveItem;

//l box;sw;l joker;ne;nw;l box;se;ne;l case;sw;e; l crate;w;s;s;e;n;n;w;l can;s;e;e;put table

/**
 * @author Robby
 * @author Tim
 */
public class SecretTableFunction implements CallableItemFunction {
	Card [] [] tableCards = new Card [2] [3]; // red, black

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

			ArrayList<InteractiveItem> ivt = Player.inventory.getItems();
			ivtLoop: while (ivt.size() > 0) {
				System.out.println("---");
				InteractiveItem i = ivt.remove(0);
				if (i.getClass() != Card.class) {
					continue;
				}
				for (Card card : cards) {
					System.out.println(i + ", " + card);
					if (i.equals(card)) {
						Card add = (Card) i;
						int indx = -2;
						switch (add.getDescription()) {
							case "Black":
							case "Spades":
							case "Clubs":
								indx = 0;
								break;
							case "Red":
							case "Diamonds":
							case "Hearts":
								indx = 1;
								break;
							default:
								indx = -1;
						}
						if (add.getName().equals("Joker")) {
							// System.out.println("Joker");
							// for (Card [] a : tableCards) {
							// for (Card b : a) {
							// System.out.print(b + ", ");
							// }
							// System.out.println();
							// }
							tableCards[indx][0] = add;
							// System.out.println(indx + ", " + 0);
							// for (Card [] a : tableCards) {
							// for (Card b : a) {
							// System.out.print(b + ", ");
							// }
							// System.out.println();
							// }
							// System.out.println("\tMatch");
							Player.inventory.removeItem(add);
							continue ivtLoop;
						}
						for (int j = 1; j < tableCards[indx].length; j++) {
							if (tableCards[indx][j] == null) {
								// for (Card [] a : tableCards) {
								// for (Card b : a) {
								// System.out.print(b + ", ");
								// }
								// System.out.println();
								// }
								tableCards[indx][j] = add;
								// System.out.println(indx + ", " + j);
								// for (Card [] a : tableCards) {
								// for (Card b : a) {
								// System.out.print(b + ", ");
								// }
								// System.out.println();
								// }
								// System.out.println("\tMatch");
								Player.inventory.removeItem(add);
								continue ivtLoop;
							}
						}
					}
				}
				System.out.println("error");
			}
		}
		for (Card [] i : tableCards) {
			for (Card j : i) {
				if (j == null) {
					return;
				}
			}
		}

		System.out.println("\n-------------------------\n");
		System.out.println(this);
		System.out.println("\n-------------------------\n");
		System.out.println("You win!");
		System.out.println("\n-------------------------");
	}

	@Override
	public String toString () {
		String r = "";
		Card [] [] tc = new Card [tableCards[0].length] [tableCards.length];
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
