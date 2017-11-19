package objects;

/**
 * @author Robby
 *
 */
public class Weapon extends InteractiveItem {
	private byte power;

	/**
	 * @param name
	 * @param description
	 */
	public Weapon (String name, String description, byte power) {
		super(name, description);
		this.power = (power < 0) ? 0 : power;
	}
}
