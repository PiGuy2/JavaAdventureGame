package main;

import java.util.ArrayList;
import java.util.Arrays;

import objects.BackgroundItem;
import objects.InteractiveItem;
import objects.Item;
import objects.Room;

/**
 * @author Robby
 *
 */
public class Test {
	public static void main (String [] args) {
		BackgroundItem tree = new BackgroundItem("tree", "average sized jewel encrusted");
		BackgroundItem log = new BackgroundItem("log", "very large");
		BackgroundItem stick = new BackgroundItem("stick", "small");
		InteractiveItem egg = new InteractiveItem("egg", "jeweled");
		InteractiveItem sack = new InteractiveItem("sack", "brown paper");
		InteractiveItem sack2 = new InteractiveItem("sack", "orange paper");
		InteractiveItem sack3 = new InteractiveItem("bag", "brown paper");
		InteractiveItem sack4 = new InteractiveItem("sack", "paper");
		InteractiveItem sack5 = new InteractiveItem("sack", "plastic");
		InteractiveItem sack6 = new InteractiveItem("sack", "blue plastic");
		ArrayList<Item> items = new ArrayList<>(Arrays.asList(egg, sack, sack2, sack3, sack4, sack5, sack6));
		Room test = new Room(items);
		Item itemTest = test.getItem("sack");
		if (itemTest == null) {
			System.out.println("null");
		} else {
			System.out.print("Item selected: ");
			itemTest.printItem();
		}
	}
}