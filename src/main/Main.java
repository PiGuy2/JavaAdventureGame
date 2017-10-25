package main;

import objects.BackgroundItem;
import objects.InteractiveItem;
import objects.Item;

/**
 * @author Robby
 *
 */
public class Main {
	public static void main (String [] args) {
		BackgroundItem tree = new BackgroundItem("tree", "average sized jewel encrusted");
		BackgroundItem log = new BackgroundItem("log", "very large");
		BackgroundItem stick = new BackgroundItem("stick", "small");
		InteractiveItem egg = new InteractiveItem("egg", "jeweled");
		InteractiveItem sack = new InteractiveItem("sack", "brown paper");
		System.out.println("Background items:");
		BackgroundItem.printAll();
		System.out.println("\nInteractable items:");
		InteractiveItem.printAll();
		System.out.println("\nAll items:");
		Item.printAll();
	}
}
