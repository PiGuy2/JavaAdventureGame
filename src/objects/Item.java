package objects;

/**
 * @author Robby
 * 
 */
public class Item {
	protected String description;

	protected boolean isBackground;

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
		this.isBackground = isInteractive;
	}

	// TODO getter and setter docs?

	public boolean getBackground () {
		return isBackground;
	}

	public String getDescription () {
		return description;
	}

	public String getName () {
		return name;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public void setName (String name) {
		this.name = name;
	}

	// TODO docs
	public void printItem () {
		System.out.println("A " + description + " " + name + ".");
	}
}
