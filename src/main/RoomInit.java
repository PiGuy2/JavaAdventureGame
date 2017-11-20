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
		ArrayList<InteractiveItem> drOfficeInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("briefcase", "red"), new InteractiveItem("painting", "pretty"),
				new InteractiveItem("coat", "large trench"), new InteractiveItem("door", "trap"),
				new InteractiveItem("dagger", "small"), new InteractiveItem("lamp"),
				new InteractiveItem("piece", "wood"),
				new InteractiveItem("card", "ace of spades")));
		ArrayList<BackgroundItem> drOfficeBackgroundItems = new ArrayList<>(Arrays.asList(
				new BackgroundItem("desk", "large"), new BackgroundItem("chair", "comfy"),
				new BackgroundItem("shelf", "book"), new BackgroundItem("box", "wooden cigar")));
		Room drOffice = new Room("doctor's office", "",
				"The room is white with windows all around, yet the room seems dark.",
				drOfficeInteractiveItems, drOfficeBackgroundItems);
		// -----
		ArrayList<InteractiveItem> factorySInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("card", "ace of hearts"), new InteractiveItem("can", "trash"),
				new InteractiveItem("painting", "large"), new InteractiveItem("notebook", "blue"),
				new InteractiveItem("lock", "pink"), new InteractiveItem("key", "pink")));
		ArrayList<BackgroundItem> factorySBackgroundItems = new ArrayList<>(Arrays
				.asList(new BackgroundItem("painting", "small"), new BackgroundItem("window")));
		Room factoryS = new Room("Factory S", "", "It is cold.", factorySInteractiveItems,
				factorySBackgroundItems);
		// -----
		ArrayList<InteractiveItem> factoryTInteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("", ""), new InteractiveItem("", ""),
						new InteractiveItem("", ""), new InteractiveItem("", ""),
						new InteractiveItem("", ""), new InteractiveItem("", ""),
						new InteractiveItem("", "")));
		ArrayList<BackgroundItem> factoryTBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("", ""), new BackgroundItem("", ""),
						new BackgroundItem("", ""), new BackgroundItem("", "")));
		Room factoryT = new Room("Factory T", "", "This room is extremely hot.",
				factoryTInteractiveItems, factoryTBackgroundItems);
		// -----
		Room hallWay = new Room("Hallway", "long white");

		// drOffice.setDirection("d", drOffice);

		return drOffice;
	}
}
