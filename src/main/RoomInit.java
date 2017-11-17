/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;

import objects.BackgroundItem;
import objects.InteractiveItem;
import objects.Room;

/**
 * @author Owen
 *
 */
public class RoomInit {
	public static Room makeRooms () {
		ArrayList<InteractiveItem> drOfficeInteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("briefcase", "red"), new InteractiveItem("painting", "pretty"),
						new InteractiveItem("coat", "large trench"), new InteractiveItem("door", "trap"),
						new InteractiveItem("dagger", "small"), new InteractiveItem("lamp", ""),
						new InteractiveItem("piece", "wood")));
		ArrayList<BackgroundItem> drOfficeBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("desk", "large"), new BackgroundItem("chair", "comfy"),
						new BackgroundItem("shelf", "book"), new BackgroundItem("box", "wooden cigar")));
		Room DrOffice = new Room("doctor's office", "",
				"The room is white with windows all around, yet the room seems dark.", drOfficeInteractiveItems,
				drOfficeBackgroundItems);
		// -----
		ArrayList<InteractiveItem> factorySInteractiveItems = new ArrayList<>(Arrays.asList(new InteractiveItem("", ""),
				new InteractiveItem("", ""), new InteractiveItem("", ""), new InteractiveItem("", ""),
				new InteractiveItem("", ""), new InteractiveItem("", ""), new InteractiveItem("", "")));
		ArrayList<BackgroundItem> factorySBackgroundItems = new ArrayList<>(Arrays.asList(new BackgroundItem("", ""),
				new BackgroundItem("", ""), new BackgroundItem("", ""), new BackgroundItem("", "")));
		Room factoryS = new Room("roomName", "", "extDesricption", factorySInteractiveItems, factorySBackgroundItems);
		// ___________

		// ArrayList<InteractiveItem> InteractiveItems = new ArrayList<>(Arrays.asList(
		// new InteractiveItem("", ""), new InteractiveItem("", ""),
		// new InteractiveItem("", ""), new InteractiveItem("", ""),
		// new InteractiveItem("", ""), new InteractiveItem("", ""),
		// new InteractiveItem("", "")));
		// ArrayList<BackgroundItem> BackgroundItems = new ArrayList<>(Arrays.asList(
		// new BackgroundItem("", ""), new BackgroundItem("", ""),
		// new BackgroundItem("", ""), new BackgroundItem("", "")));
		// Room (room name) = new Room("roomName", "",
		// "extDesricption",
		// InteractiveItems, BackgroundItems);

		factoryS.setDirection("s", DrOffice);

		return DrOffice;
	}
}
