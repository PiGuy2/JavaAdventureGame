package locks;

import character.Player;
import objects.InteractiveItem;

/**
 * Write a description of class ItemLock here.
 *
 * @author Cole
 * @author Owen
 */

public class ItemLock {
	public String name;
	public InteractiveItem UNLitem;
	public String type;
	public boolean locked;

	public ItemLock (String name, InteractiveItem UNLitem, boolean locked) {
		this.name = name;
		this.UNLitem = UNLitem;
		this.locked = locked;
	}

	public String getName () {
		return name;
	}

	public InteractiveItem getUNLitem () {
		return UNLitem;
	}

	public boolean getlocked () {
		return locked;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setUNLitem (InteractiveItem UNLitem) {
		this.UNLitem = UNLitem;
	}

	public void setlocked (boolean locked) {
		this.locked = locked;
	}

	public void Unlock (ItemLock lock) {
		if (Player.inventory.getItems().contains(lock.getUNLitem())) {
			lock.setlocked(false);
			System.out.println("Good one pal, it's unlocked");
		}
	}
}
