package objects;

/**
 * @author Robby
 * 
 */
public class BackgroundItem extends Item {
	/**
	 * Create a new background item object
	 * 
	 * @param name
	 *            The name of the item
	 */
	public BackgroundItem (String name) {
		this(name, "");
	}

	/**
	 * Create a new background item object
	 * 
	 * @param name
	 *            The name of the item
	 */
	public BackgroundItem (String name, String description) {
		super(name, description, false);
	}
}
