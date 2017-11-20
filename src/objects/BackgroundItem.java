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
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public BackgroundItem (String name, String description) {
		super(name, description, false);
	}

	/**
	 * Create a new background item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public BackgroundItem (String name) {
		this(name, "");
	}
}
