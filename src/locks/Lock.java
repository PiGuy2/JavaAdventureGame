package locks;

/**
 * @author Robby
 *
 */
public class Lock {
	protected String lockedMessage;

	public Lock (String lockedMessage) {
		this.lockedMessage = lockedMessage;
	}

	public String getMessage () {
		return lockedMessage;
	}
}