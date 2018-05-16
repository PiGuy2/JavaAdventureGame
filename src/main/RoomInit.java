/**
 *
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;

import callableItems.MapProcessor;
import callableItems.PrizeBoxFunction;
import callableItems.SecretTableFunction;
import objects.BackgroundItem;
import objects.Card;
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
		// Room --- = new Room("name", "description", "extended description",
		// ---InteractiveItems, ---BackgroundItems);

		ArrayList<InteractiveItem> elevensRoomInteractiveItems = new ArrayList<>(
				Arrays.asList(new InteractiveItem("table", "round", false),
						new InteractiveItem("chair", "small", false),
						new InteractiveItem("case", "trophey", false)));
		ArrayList<BackgroundItem> elevensRoomBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("painting", "stupid")));
		Room elevensRoom = new Room("Elevens Room", "small", "The blank room",
				elevensRoomInteractiveItems, elevensRoomBackgroundItems);

		PrizeBoxFunction PBF = new PrizeBoxFunction(new Card("Ace", "Spades"));
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
		ArrayList<BackgroundItem> blackJackBackgroundItems = new ArrayList<>(Arrays.asList());
		Room blackJackRoom = new Room("Blackjack Room", "", blackJackInteractiveItems,
				blackJackBackgroundItems);

		PrizeBoxFunction PCF = new PrizeBoxFunction(new Card("Ace", "Clubs"));
		ArrayList<InteractiveItem> pokerRoomInteractiveItems = new ArrayList<>(
				Arrays.asList(new ProccessedItem("crate", PCF, PCF)));
		ArrayList<BackgroundItem> pokerRoomBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("table", "poker")));
		Room pokerRoom = new Room("Poker Room", "", "A room with a poker table.",
				pokerRoomInteractiveItems, pokerRoomBackgroundItems);

		PrizeBoxFunction PTF = new PrizeBoxFunction(new Card("Ace", "Hearts"));
		ArrayList<InteractiveItem> mainAreaInteractiveItems = new ArrayList<>(
				Arrays.asList(new ProccessedItem("box", PTF, PTF),
						new ProccessedItem("map", "detailed and descriptive", new MapProcessor())));
		ArrayList<BackgroundItem> mainAreaBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("table", "large"), new BackgroundItem("bar")));
		Room mainArea = new Room("Room", "Main", "The large central room of the casino.",
				mainAreaInteractiveItems, mainAreaBackgroundItems);

		Room entrance = new Room("Entrance", "",
				"The entrance of the Mickey Mouse Gambling House.");

		Room southOutside = new Room("grassy area", "", "A section of grass out in the sun.");
		Room southEastOuside = new Room("grassy area", "", "A section of grass out in the sun.");
		Room eastOutside = new Room("grassy area", "", "A section of grass out in the sun.");
		Room northEastOuside = new Room("grassy area", "", "A section of grass out in the sun.");

		ArrayList<InteractiveItem> backOutsideInteractiveItems = new ArrayList<>(Arrays.asList(
				new ProccessedItem("can", "trash",
						new PrizeBoxFunction(new Card("Ace", "Diamonds"))),
				new InteractiveItem("dumpster", "large"), new InteractiveItem("can", "garbage"),
				new InteractiveItem("can", "waste"), new InteractiveItem("can", "rubbish"),
				new InteractiveItem("can", "recycling")));
		ArrayList<BackgroundItem> backOutsideBackgroundItems = new ArrayList<>(
				Arrays.asList(new BackgroundItem("grass", "boring")));
		Room backOutside = new Room("grassy area", "", "A section of grass behind the casino.",
				backOutsideInteractiveItems, backOutsideBackgroundItems);

		Room backRoom = new Room("room", "back", "A back room of the casino.");

		Room closet = new Room("closet", "dirty", "A back room of the casino.");

		ArrayList<InteractiveItem> secretRoomInteractiveItems = new ArrayList<>(Arrays
				.asList(new ProccessedItem("table", "description", new SecretTableFunction())));
		Room secretRoom = new Room("room", "secret", "A secret room in the casino.",
				secretRoomInteractiveItems);

		mainArea.setDirection("ne", elevensRoom);
		mainArea.setDirection("nw", slotMachineRoom);
		mainArea.setDirection("sw", blackJackRoom);
		mainArea.setDirection("e", pokerRoom);
		mainArea.setDirection("s", entrance);

		southOutside.setCardinalDirections(entrance, southEastOuside, southOutside, southOutside);
		southEastOuside.setCardinalDirections(eastOutside, southEastOuside, southEastOuside,
				southOutside);
		eastOutside.setCardinalDirections(northEastOuside, eastOutside, southEastOuside,
				southEastOuside);
		northEastOuside.setCardinalDirections(northEastOuside, northEastOuside, eastOutside,
				backOutside);
		backOutside.setCardinalDirections(backOutside, northEastOuside, backRoom, backOutside);
		closet.setCardinalDirections(closet, secretRoom, closet, backRoom);

		return mainArea; // starting room
	}
}
