package objects;

import locks.ItemLock;

/**
 * @author Robby
 * 
 */
public class InteractiveItem extends Item {
	protected boolean hasLock;
	protected ItemLock lock;

	/**
	 * Create a new interactive item object
	 * 
	 * @param name
	 *            The name of the item
	 */
	public InteractiveItem (String name) {
		this(name, "");
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
	public InteractiveItem (String name, String description) {
		super(name, description, true);
	}

	/**
	 * Adds an {@link locks.ItemLock ItemLock} to the item. If there is already an
	 * ItemLock, it is overwritten. If {@code unlockItem} is {@code null}, the
	 * ItemLock is removed. See
	 * {@link #addItemLock(InteractiveItem, String, boolean)} if you don't want to
	 * overwrite any previous lock.
	 * 
	 * @param unlockItem
	 *            is the item that must be present in the player's inventory to
	 *            unlock the lock.
	 * @param lockedMessage
	 *            is the message that is printed if the user attempts to take this
	 *            item while it is locked.
	 * @return Whether there was already an ItemLock.
	 * @see locks.ItemLock#ItemLock(InteractiveItem, String)
	 * @see #removeItemLock()
	 */
	public boolean addItemLock (InteractiveItem unlockItem, String lockedMessage) {
		return addItemLock(unlockItem, lockedMessage, true);
	}

	/**
	 * Adds an {@link locks.ItemLock ItemLock} to the item. If there is already an
	 * ItemLock, it is only overwritten if {@code overwrite} is true. If
	 * {@code unlockItem} is {@code null} and overwrite is true, the ItemLock is
	 * removed.
	 * 
	 * @param unlockItem
	 *            is the item that must be present in the player's inventory to
	 *            unlock the lock.
	 * @param lockedMessage
	 *            is the message that is printed if the user attempts to take this
	 *            item while it is locked.
	 * @param overwrite
	 *            determines if the previous lock should be overwritten (if it
	 *            exists)
	 * @return If there was already an ItemLock.
	 * @see locks.ItemLock#ItemLock(InteractiveItem, String)
	 * @see #removeItemLock()
	 * @see #addItemLock(InteractiveItem, String)
	 */
	public boolean addItemLock (InteractiveItem unlockItem, String lockedMessage, boolean overwrite) {
		if (overwrite || !hasLock) {
			if (unlockItem != null) {
				boolean r = hasLock;
				lock = new ItemLock(unlockItem, lockedMessage);
				hasLock = true;
				return r;
			}
			return removeItemLock();
		}
		return true;
	}

	/**
	 * Removes the {@link locks.ItemLock ItemLock} on this item
	 * 
	 * @return If there was already an ItemLock.
	 * @see locks.ItemLock#ItemLock(InteractiveItem, String)
	 * @see #addItemLock(InteractiveItem, String)
	 * @see #addItemLock(InteractiveItem, String, boolean)
	 */
	public boolean removeItemLock () {
		boolean r = hasLock;
		lock = null;
		hasLock = false;
		return r;
	}
}
