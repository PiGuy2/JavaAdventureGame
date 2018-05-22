package objects;

/**
 * @author Robby
 *
 */
public class Card extends InteractiveItem {
	public Card (String name) {
		super(name, false);
	}

	public Card (String name, String description) {
		super(name, description, false);
	}

	@Override
	public boolean equals (Object obj) {
		if (obj.getClass() == this.getClass()) {
			Card c = (Card) obj;
			return c.getName() == this.getName() && c.getDescription() == this.getDescription();
		}
		return false;
	}

	@Override
	public String toString () {
		return name + " of " + description;
	}
}
