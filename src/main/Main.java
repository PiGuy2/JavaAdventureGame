package main;

import objects.BackgroundItem;
import objects.InteractiveItem;

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
	}
}
