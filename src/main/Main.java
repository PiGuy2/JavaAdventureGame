package main;

import objects.BackgroundItem;
import objects.InteractableItem;
import objects.Item;

public class Main {
	public static void main (String [] args) {
		BackgroundItem tree = new BackgroundItem("tree", "average sized jewel encrusted");
		BackgroundItem log = new BackgroundItem("log", "very large");
		BackgroundItem stick = new BackgroundItem("stick", "small");
		InteractableItem egg = new InteractableItem("egg", "jeweled");
		InteractableItem sack = new InteractableItem("sack", "brown paper");
		System.out.println("Background items:");
		BackgroundItem.printAll();
		System.out.println("\nInteractable items:");
		InteractableItem.printAll();
		System.out.println("\nAll items:");
		Item.printAll();
	}
}
