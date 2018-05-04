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
 * @author Tim
 *
 */
public class RoomInit {
	public static Room makeRooms () {
		// InteractiveItem pinkKey = new InteractiveItem("key", "pink");
		// ArrayList<InteractiveItem> drOfficeInteractiveItems = new
		// ArrayList<>(Arrays.asList(
		// new InteractiveItem("briefcase", "red"), new InteractiveItem("painting",
		// "pretty"),
		// new InteractiveItem("coat", "large trench"), new InteractiveItem("door",
		// "trap"),
		// new InteractiveItem("dagger", "small"), new InteractiveItem("lamp"),
		// pinkKey));
		// ArrayList<BackgroundItem> drOfficeBackgroundItems = new
		// ArrayList<>(Arrays.asList(
		// new BackgroundItem("desk", "large"), new BackgroundItem("chair", "comfy"),
		// new BackgroundItem("shelf", "book"), new BackgroundItem("box", "wooden
		// cigar")));
		// Room drOffice = new Room("doctor's office", "",
		// "The room is white with windows all around, yet the room seems dark.",
		// drOfficeInteractiveItems, drOfficeBackgroundItems);

		// new InteractiveItem("item", "description")
		// new BackgroundItem("item", "description")

		ArrayList<InteractiveItem> ---InteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("item", "description")));
		ArrayList<BackgroundItem> ---BackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("item", "description")));
		Room roomName = new Room("---", "description", "extended description",
				roomNameInteractiveItems, roomNameBackgroundItems);

		ArrayList<InteractiveItem> ElevensRoomInteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("table", "round"), new InteractiveItem("chair", "small"), new InteractiveItem("case", "trophey")));
		ArrayList<BackgroundItem> ElevensRoomBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("painting", "stupid")));
		Room roomName = new Room("Elevens Room", "small", "extended description",
				roomNameInteractiveItems, roomNameBackgroundItems);

		return new Room(); // starting room
	}
}
