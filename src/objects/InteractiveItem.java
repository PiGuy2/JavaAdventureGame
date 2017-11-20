package objects;

/**
 * @author Robby
 * 
 */
public class InteractiveItem extends Item {
	/**
	 * Create a new interactive item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public InteractiveItem (String name, String description) {
		super(name, description, true);
	}

	/**
	 * Create a new interactive item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 */
	public InteractiveItem (String name) {
		this(name, "");
	}
}
