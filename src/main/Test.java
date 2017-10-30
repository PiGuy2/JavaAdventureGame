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
		InteractiveItem sack2 = new InteractiveItem("sack", "brown paper");
		InteractiveItem sack3 = new InteractiveItem("sack", "brown paper");
		InteractiveItem sack4 = new InteractiveItem("sack", "brown paper");
		ArrayList<Item> items = new ArrayList<>(Arrays.asList(egg, sack, sack2, sack3, sack4));
		Room test = new Room(items);
		Item itemTest = test.getItem("sack");
	}
}
