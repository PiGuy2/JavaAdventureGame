package character;

import java.util.ArrayList;

import objects.InteractiveItem;
import objects.Weapon;

/**
 * @author Robby
 *
 */
public class Battle {
	private ArrayList<InteractiveItem> character1EqItems;
	private Weapon character1Weapon;

	private ArrayList<InteractiveItem> character2EqItems;
	private Weapon character2Weapon;

	/**
	 * Initialize a Battle. Use {@link #run()} to run through the battle. Character
	 * 1 should generally be the player, while character 2 is the enemy.
	 * 
	 * @param character1Weapon
	 *            the first characters' weapon
	 * @param character1EqItems
	 *            the first characters' equipped items
	 * @param character2Weapon
	 *            the second characters' weapon
	 * @param character2EqItems
	 *            the second characters' equipped items
	 * @param character1IsPlayer
	 *            a {@code boolean} that determines if the first character is the
	 *            player. If this is false the battle is NPC versus NPC, and the
	 *            player will not be asked for input. If this is true, the player
	 *            will be asked for input each turn.
	 */
	public Battle (Weapon character1Weapon, ArrayList<InteractiveItem> character1EqItems, Weapon character2Weapon,
			ArrayList<InteractiveItem> character2EqItems, boolean character1IsPlayer) {
		this.character1Weapon = character1Weapon;
		this.character1EqItems = character1EqItems;
		this.character2Weapon = character2Weapon;
		this.character2EqItems = character2EqItems;
	}

	/**
	 * @return If character 1 won the battle
	 */
	public boolean run () {
		return true;
	}
}
