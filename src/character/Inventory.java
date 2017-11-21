package character;

import java.util.ArrayList;

import objects.InteractiveItem;
import objects.Item;

/**
 * Class to store an ArrayList of items in the inventory of the
 * {@link Player#Player() player} or of an {@link NPC#NPC() NPC}. Includes
 * function to add and remove items from the inventory, as well as to find an
 * item in the inventory based on user input.
 * 
 * @author Cole
 * @author Owen
 * @author Robby
 */
public class Inventory {
	private ArrayList<InteractiveItem> items;

	public Inventory () {
		this.items = new ArrayList<>();
	}

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

	public boolean contains (InteractiveItem item) {
		return items.contains(item);
	}

	public InteractiveItem getItem (String param) {
		ArrayList<Item> itemsToSearch = new ArrayList<>(items);
		return (InteractiveItem) Item.getItem(itemsToSearch, param);
	}

	public ArrayList<InteractiveItem> getItems () {
		return items;
	}

	public void printAll () {
		if (items.size() > 0) {
			System.out.println("You have:");
			for (Item i : items) {
				System.out.print("\t");
				i.printItem();
			}
		} else {
			System.out.println("You have no items.");
		}
	}

	/**
	 * removes item from the Inventory
	 * 
	 */
	public void removeItem (InteractiveItem interactiveItem) {
		items.remove(interactiveItem);
	}
}
