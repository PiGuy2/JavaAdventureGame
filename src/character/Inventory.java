package character;

import java.util.ArrayList;

import objects.InteractiveItem;
import objects.Item;

/**
 * @author Cole
 * @author Owen
 *
 */
public class Inventory {
	private ArrayList<InteractiveItem> items;

	public Inventory () {
		this.items = new ArrayList<>();
	}

	// TODO docs
	public Inventory (ArrayList<InteractiveItem> items) {
		this.items = items;
	}

	/**
	 * adds item to array list
	 */
	public void addItem (InteractiveItem interactiveItem) {
		items.add(interactiveItem);
	}

	public void addItems (ArrayList<InteractiveItem> interactiveItems) {
		items.addAll(interactiveItems);
	}

	// TODO docs
	public ArrayList<InteractiveItem> getItems () {
		return items;
	}

	public void printAll () {
		System.out.println("You have:");
		for (Item i : items) {
			System.out.print("\t");
			i.printItem();
		}
	}

	/**
	 * removes item from the Inventory
	 * 
	 */
	public void removeItem (InteractiveItem interactiveItem) {
		items.remove(interactiveItem);
	}

	public InteractiveItem getItem (String param) {
		ArrayList<Item> itemsToSearch = new ArrayList<>(items);
		return (InteractiveItem) Item.getItem(itemsToSearch, param);
	}
}
