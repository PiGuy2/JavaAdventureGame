package objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import main.CommandParser;

/**
 * @author Robby
 *
 */
public class Room {
	private ArrayList<BackgroundItem> backgroundItems;
	private String description;
	private HashMap<String, Room> directions;

	private String extDescription;

	private ArrayList<InteractiveItem> itemsInArea;
	private String name;

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 */
	public Room () {
		name = "";
		description = "";
		extDescription = "";

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items}, backgroundItems items, and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param itemsInArea
	 *            is an ArrayList of Items that are in the room
	 */
	public Room (ArrayList<InteractiveItem> itemsInArea) {
		name = "";
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items}, backgroundItems items, and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param itemsInArea
	 *            is an ArrayList of Items that are in the room
	 * @param backgroundItems
	 *            is an ArrayList of
	 *            {@link BackgroundItem#BackgroundItem(String, String) background
	 *            items}
	 */
	public Room (ArrayList<InteractiveItem> itemsInArea, ArrayList<BackgroundItem> backgroundItems) {
		name = "";
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 */
	public Room (String name) {
		this.name = name;
		description = "";
		extDescription = "";

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	public Room (String name, ArrayList<InteractiveItem> itemsInArea) {
		this.name = name;
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	public Room (String name, ArrayList<InteractiveItem> itemsInArea, ArrayList<BackgroundItem> backgroundItems) {
		this.name = name;
		description = "";
		extDescription = "";

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 */
	public Room (String name, String description) {
		this.name = name;
		this.description = description;
		extDescription = "";

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 */
	public Room (String name, String description, ArrayList<InteractiveItem> itemsInArea) {
		this.name = name;
		this.description = description;
		extDescription = "";

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 */
	public Room (String name, String description, ArrayList<InteractiveItem> itemsInArea,
			ArrayList<BackgroundItem> backgroundItems) {
		this.name = name;
		this.description = description;
		extDescription = "";

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 * @param extDescription
	 *            is printed on a new line after the name and description
	 */
	public Room (String name, String description, String extDescription) {
		this.name = name;
		this.description = description;
		this.extDescription = extDescription;

		itemsInArea = new ArrayList<>();
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 * @param extDescription
	 *            is printed on a new line after the name and description
	 */
	public Room (String name, String description, String extDescription, ArrayList<InteractiveItem> itemsInArea) {
		this.name = name;
		this.description = description;
		this.extDescription = extDescription;

		this.itemsInArea = itemsInArea;
		backgroundItems = new ArrayList<>();

		runOnInit();
	}

	/**
	 * Creates a {@code Room} object to store a list of
	 * {@link Item#Item(String, String, boolean) items} and
	 * {@link character.NPC#NPC() NPCs} in the room
	 * 
	 * @param name
	 *            is the name of the room
	 * @param description
	 *            is the adjective or phrase printed before name
	 * @param extDescription
	 *            is printed on a new line after the name and description
	 */
	public Room (String name, String description, String extDescription, ArrayList<InteractiveItem> itemsInArea,
			ArrayList<BackgroundItem> backgroundItems) {
		this.name = name;
		this.description = description;
		this.extDescription = extDescription;

		this.itemsInArea = itemsInArea;
		this.backgroundItems = backgroundItems;

		runOnInit();
	}

	public HashMap<String, Room> getDirections () {
		return directions;
	}

	/**
	 * If multiple Items are found, the user is asked to select a single item from
	 * the list of items matching {@code param}.
	 * 
	 * @param param
	 * @return Returns an {@link Item#Item(String, String, boolean) Item} that is
	 *         found from the argument {@code param}. This function searches both
	 *         the description and name of all Items in the room. If the user
	 *         presses {@code enter} when prompted to select an item, {@code null}
	 *         is returned. {@code null} is returned if no items are found.
	 */
	public Item getItem (String param) {
		ArrayList<Item> area = new ArrayList<>();
		area.addAll(itemsInArea);
		area.addAll(backgroundItems);
		return Item.getItem(area, param);
	}

	/**
	 * Get a room based on direction relative to this room. Returns {@code null} if
	 * given a nonexistent direction
	 * 
	 * @param dir
	 *            The direction you want to go
	 * @return The room specified by the direction
	 */
	public Room getRoomFromDir (String dir) {
		try {
			return directions.get(dir);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Prints room name, description, and extended description
	 */
	public void printAll () {
		printRoom();
		System.out.println(extDescription);
		ArrayList<String> directionsToMove = new ArrayList<>();
		for (String d : directions.keySet()) {
			if (CommandParser.dirSubstitutions.containsValue(d)) {
				directionsToMove.add(d);
			}
		}
		if (directionsToMove.size() < 1) {
			System.out.println("You can't move.");
		} else if (directionsToMove.size() == 1) {
			System.out.println("You can move " + directionsToMove.get(0) + ".");
		} else if (directionsToMove.size() == 2) {
			System.out.println("You can move " + directionsToMove.get(0) + " and " + directionsToMove.get(1) + ".");
		} else {
			System.out.print("You can move ");
			String lastDirection = directionsToMove.remove(directionsToMove.size() - 1);
			for (String i : directionsToMove) {
				System.out.print(i + ", ");
			}
			System.out.println("and " + lastDirection + ".");
		}
	}

	/**
	 * Prints all items in the Room
	 */
	public void printItems () {
		if (itemsInArea.size() > 0 || backgroundItems.size() > 0) {
			System.out.println("In the room there is:");
			ArrayList<Item> mixedItems = new ArrayList<>();
			mixedItems.addAll(itemsInArea);
			mixedItems.addAll(backgroundItems);
			Collections.shuffle(mixedItems);
			for (Item i : mixedItems) {
				System.out.print("\t");
				i.printItem();
			}
		} else {
			System.out.println("There are no items in the room.");
		}
	}

	/**
	 * Prints room name and description
	 */
	public void printRoom () {
		if (!description.equals("")) {
			description += " ";
		}
		System.out.println("You are in a " + description + name + ".");
	}

	public boolean removeItem (InteractiveItem itemToRemove) {
		return itemsInArea.remove(itemToRemove);
	}

	public void setCardinalDirections (Room n, Room e, Room s, Room w) {
		setDirection("north", n);
		setDirection("east", e);
		setDirection("south", s);
		setDirection("west", w);
	}

	/**
	 * Set direction you can move when you are in this room
	 * 
	 * @param d
	 *            Direction name (can be anything)
	 * @param room
	 *            Room to move to
	 */
	public void setDirection (String d, Room room) {
		if (setDirectionSimple(d, room)) {
			String dir = CommandParser.replaceDirection(d);
			if (room.equals(this)) {
				return;
			}
			if (dir.equals("north")) {
				room.setDirectionSimple("south", this);
			}
			if (dir.equals("east")) {
				room.setDirectionSimple("west", this);
			}
			if (dir.equals("south")) {
				room.setDirectionSimple("north", this);
			}
			if (dir.equals("west")) {
				room.setDirectionSimple("east", this);
			}
			if (dir.equals("northeast")) {
				room.setDirectionSimple("southwest", this);
			}
			if (dir.equals("northwest")) {
				room.setDirectionSimple("southeast", this);
			}
			if (dir.equals("southeast")) {
				room.setDirectionSimple("northwest", this);
			}
			if (dir.equals("southwest")) {
				room.setDirectionSimple("northeast", this);
			}
			if (dir.equals("up")) {
				room.setDirectionSimple("down", this);
			}
			if (dir.equals("down")) {
				room.setDirectionSimple("up", this);
			}
		} else {
			unsetDirection(d);
		}
	}

	public boolean setDirectionSimple (String d, Room room) {
		if (room != null) {
			String dir = CommandParser.replaceDirection(d);
			directions.put(dir, room);
			return true;
		}
		return false;
	}

	public void setSecondaryDirections (Room ne, Room nw, Room se, Room sw) {
		setDirection("northeast", ne);
		setDirection("northwest", nw);
		setDirection("southeast", se);
		setDirection("southwest", sw);
	}

	public void setVerticalDirections (Room u, Room d) {
		setDirection("up", u);
		setDirection("down", d);
	}

	public void unsetDirection (String d) {
		directions.remove(d);
	}

	private void runOnInit () {
		directions = new HashMap<>();
	}

	public void addItem (InteractiveItem interactiveItem) {
		itemsInArea.add(interactiveItem);
	}

	public void addItems (ArrayList<InteractiveItem> interactiveItems) {
		itemsInArea.addAll(interactiveItems);
	}

}
