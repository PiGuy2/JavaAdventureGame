package objects;

public class Card extends InteractiveItem {
	public Card (String name) {
		super(name, false);
	}

	public Card (String name, String description) {
		super(name, description, false);
	}
}
