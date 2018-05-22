package locks;

import character.Player;
import objects.InteractiveItem;

/**
 * This class is used to prevent the player from doing certain actions until
 * they have the necessary item in their inventory.
 *
 * @author Robby
 */
public class ItemLock extends Lock {
	private InteractiveItem unlockItem;

	/**
	 * Create a lock, which is used to prevent an item from being take or an action
	 * from being performed before the lock is unlocked. An ItemLock is unlocked by
	 * the presence of a specific item in the {@link character.Player Player}'s
	 * {@link character.Inventory Inventory}
	 *
	 * @param unlockItem
	 *            is the item that must be present in the player's inventory to
	 *            unlock the lock.
	 * @param lockedMessage
	 *            is the message that is printed if the user attempts to take this
	 *            item while it is locked.
	 */
	public ItemLock (InteractiveItem unlockItem, String lockedMessage) {
		super(lockedMessage);
		this.unlockItem = unlockItem;
		this.lockedMessage = lockedMessage;
	}

	public InteractiveItem getUnlockItem () {
		return unlockItem;
	}

	public boolean isUnlocked () {
		return Player.inventory.contains(unlockItem);
	}

	public void setUnlockItem (InteractiveItem unlockItem) {
		this.unlockItem = unlockItem;
	}
}
