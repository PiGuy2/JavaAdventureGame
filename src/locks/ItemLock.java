package locks;

import character.Player;
import objects.InteractiveItem;

/**
 * Write a description of class ItemLock here.
 *
 * @author Cole
 * @author Owen
 * @author Robby
 */

public class ItemLock {
	public boolean locked;
	public String name;
	public String type;
	public InteractiveItem UNLitem;

	public ItemLock (String name, InteractiveItem UNLitem, boolean locked) {
		this.name = name;
		this.UNLitem = UNLitem;
		this.locked = locked;
	}

	public boolean getlocked () {
		return locked;
	}

	public String getName () {
		return name;
	}

	public InteractiveItem getUNLitem () {
		return UNLitem;
	}

	public void setlocked (boolean locked) {
		this.locked = locked;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setUNLitem (InteractiveItem UNLitem) {
		this.UNLitem = UNLitem;
	}

	public void Unlock (ItemLock lock) {
		if (Player.inventory.getItems().contains(lock.getUNLitem())) {
			lock.setlocked(false);
			System.out.println("Good one pal, it's unlocked");
		}
	}
}
