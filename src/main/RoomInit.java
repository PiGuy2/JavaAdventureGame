/**
 *
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;

import callableItems.PrizeBoxFunction;
import objects.BackgroundItem;
import objects.InteractiveItem;
import objects.ProccessedItem;
import objects.Room;

/**
 * @author Robby
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

		// ArrayList<InteractiveItem> ---InteractiveItems = new ArrayList<>(
		// Arrays.asList(new InteractiveItem("item", "description")));
		// ArrayList<BackgroundItem> ---BackgroundItems = new ArrayList<>(
		// Arrays.asList(new BackgroundItem("item", "description")));
		// Room roomName = new Room("---", "description", "extended description",
		// roomNameInteractiveItems, roomNameBackgroundItems);

		ArrayList<InteractiveItem> ElevensRoomInteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("table", "round", false),
						new InteractiveItem("chair", "small", false),
						new InteractiveItem("case", "trophey", false)));
		ArrayList<BackgroundItem> ElevensRoomBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("painting", "stupid")));
		Room ElevensRoom = new Room("Elevens Room", "small", "The blank room",
				ElevensRoomInteractiveItems, ElevensRoomBackgroundItems);

		PrizeBoxFunction PBF = new PrizeBoxFunction();
		ArrayList<InteractiveItem> slotMachineRoomInteractiveItems = new ArrayList<>(
				Arrays.asList(new ProccessedItem("box", PBF, PBF),
						new InteractiveItem("slot machine", "large", false)));
		ArrayList<BackgroundItem> slotMachineRoomBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("chair", "small")));
		Room slotMachineRoom = new Room("Slot Machine Room", "large",
				"A room full of old slot machines, and old ladies.",
				slotMachineRoomInteractiveItems, slotMachineRoomBackgroundItems);

		ArrayList<InteractiveItem> blackJackInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("table", "Blackjack"), new InteractiveItem("chair", "small"),
				new InteractiveItem("chest", "reward"), new InteractiveItem("Ace of Clubs")));
		ArrayList<BackgroundItem> blackJackBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("item", "description")));
		Room BlackJack = new Room("Blackjack Room", "A cute lil", blackJackInteractiveItems,
				blackJackBackgroundItems);

		ElevensRoom.setDirection("n", slotMachineRoom);

		return ElevensRoom; // starting room
	}
}
