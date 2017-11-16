package objects;

/**
 * @author Robby
 * @author Owen
 * 
 */
public class Item {
	protected String description;

	protected boolean isInteractive;

	protected String name;

	/**
	 * Create a new item object
	 * 
	 * @param name
	 *            The name of the item
	 * @param description
	 *            The description of the object. This is printed when {@code look}
	 *            is run.
	 * @param isInteractive
	 *            If this is {@code false} commands can not be run on this object
	 */
	public Item (String name, String description, boolean isInteractive) {
		this.name = name;
		this.description = description;
		this.isInteractive = isInteractive;
	}
	

	/**
	 * Gets the description of the Item
	 * 
	 * @return The description of the Item
	 */
	public String getDescription () {
		return description;
	}

	/**
	 * Gets whether the item is a Interactive item
	 * 
	 * @return {@code true} if the item is a Interactive item
	 */
	public boolean getInteractive () {
		return isInteractive;
	}

	/**
	 * Gets the name of the Item
	 * 
	 * @return The name of the Item
	 */
	public String getName () {
		return name;
	}

	/**
	 * Prints the name of the Item in the form: A {@code (Item description)}
	 * {@code (Item name)}.
	 */
	public void printItem () {
		System.out.println("A " + description + " " + name + ".");
	}

	/**
	 * Sets the description of the item
	 * 
	 * @param description
	 *            is the new description of the item
	 */
	public void setDescription (String description) {
		this.description = description;
	}
}
