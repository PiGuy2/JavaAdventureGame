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
				new InteractiveItem("piece", "wood"), new InteractiveItem("key", "pink")));
		ArrayList<BackgroundItem> drOfficeBackgroundItems = new ArrayList<>(Arrays.asList(
				new BackgroundItem("desk", "large"), new BackgroundItem("chair", "comfy"),
				new BackgroundItem("shelf", "book"), new BackgroundItem("box", "wooden cigar")));
		Room drOffice = new Room("doctor's office", "",
				"The room is white with windows all around, yet the room seems dark.",
				drOfficeInteractiveItems, drOfficeBackgroundItems);
		// to get card you have to use the piece of wood to hold open the trap door you
		// grab card and escape the room you also need the pink key for fac s

		// ----------------

		ArrayList<InteractiveItem> trapRoomInteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("card", "ace of spades")));
		Room trapRoom = new Room("Trap Room", "small", trapRoomInteractiveItems);
		// get card and leave

		// ----------------

		ArrayList<InteractiveItem> factorySInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("card", "ace of hearts"), new InteractiveItem("can", "trash"),
				new InteractiveItem("painting", "large"), new InteractiveItem("notebook", "blue"),
				new InteractiveItem("lock", "pink on box"), new InteractiveItem("box", "small")));
		ArrayList<BackgroundItem> factorySBackgroundItems = new ArrayList<>(Arrays
				.asList(new BackgroundItem("painting", "small"), new BackgroundItem("window")));
		Room factoryS = new Room("Factory S", "", "It is cold.", factorySInteractiveItems,
				factorySBackgroundItems);
		// you have to open trash can to get a box with a pink lock on it use the pink
		// key you got from
		// droffice to get a card

		// ----------------

		ArrayList<InteractiveItem> factoryTInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("card", "ace of diamonds"), new InteractiveItem("desk", "iron"),
				new InteractiveItem("drawer", "locked"), new InteractiveItem("mirror", "small"),
				new InteractiveItem("table", "small wooden"),
				new InteractiveItem("chair", "comfortable")));
		ArrayList<BackgroundItem> factoryTBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("window", "large"),
						new BackgroundItem("lamp", "tall"), new BackgroundItem("apple", "green")));
		Room factoryT = new Room("Factory T", "", "This room is extremely hot.",
				factoryTInteractiveItems, factoryTBackgroundItems);
		// in this room you have to go to the desk and sit in the chair when you do the
		// drawer opens and reveals a card
		// -----
		Room hallWay = new Room("Hallway", "long white");
		// go places

		// -----------------------

		ArrayList<InteractiveItem> spacePiratesInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("wall", "thin"), new InteractiveItem("lever"),
				new InteractiveItem("shelf", "book"), new InteractiveItem("book", "red"),
				new InteractiveItem("book", "yellow"), new InteractiveItem("switch", "power"),
				new InteractiveItem("card", "ace of clubs")));
		ArrayList<BackgroundItem> spacePiratesBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("incinerator", "large")));
		Room spacePirates = new Room("Space Pirates", "", "This has a cold and distant feel.",
				spacePiratesInteractiveItems, spacePiratesBackgroundItems);
		// you have to turn on power switch then break the wall then pull lever and a
		// card appears

		// -----------------------
		ArrayList<InteractiveItem> pokerRoomInteractiveItems = new ArrayList<>(Arrays.asList(
				new InteractiveItem("table", "round"), new InteractiveItem("chair", "large"),
				new InteractiveItem("chair", "small"), new InteractiveItem("chair", "tall"),
				new InteractiveItem("chair", "short")));
		ArrayList<BackgroundItem> pokerRoomBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("TV", "broken")));
		Room pokerRoom = new Room("Poker Room", "round and open room", pokerRoomInteractiveItems,
				pokerRoomBackgroundItems);
		// when you enter this room with 4 cards you win

		// ------------------------

		pokerRoom.setDirection("e", hallWay);
		hallWay.setDirection("w", pokerRoom);
		hallWay.setDirection("n", drOffice);
		hallWay.setDirection("e", factoryS);
		hallWay.setDirection("se", factoryT);
		hallWay.setDirection("s", spacePirates);
		drOffice.setDirection("s", hallWay);
		drOffice.setDirection("d", trapRoom);
		factoryS.setDirection("w", hallWay);
		factoryS.setDirection("s", factoryT);
		factoryT.setDirection("n", factoryS);
		factoryT.setDirection("nw", hallWay);
		factoryT.setDirection("w", spacePirates);
		spacePirates.setDirection("n", hallWay);
		spacePirates.setDirection("e", factoryT);

		// ----------------------

		return drOffice;
	}
}
