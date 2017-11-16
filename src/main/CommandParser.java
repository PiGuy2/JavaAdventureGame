package main;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
	private static HashMap<String, String> substitutions = new HashMap<String, String>();
	private static HashMap<String, String> cmdSubstitutions = new HashMap<String, String>();
	private static HashMap<String, String> fullSubstitutions = new HashMap<String, String>();
	private static HashMap<String, String> dirSubstitutions = new HashMap<String, String>();

	static {
		/*
		 * regular substitutions replace words or phrases in the command
		 * 
		 * How to add substitutions: substitutions.put("string", "replacement");
		 */
		substitutions.put("north-east", "northeast");
		substitutions.put("north-west", "northwest");
		substitutions.put("south-east", "southeast");
		substitutions.put("south-west", "southwest");

		/*
		 * command substitutions replace the first word in the command
		 * 
		 * How to add command substitutions: cmdSubstitutions.put("string",
		 * "replacement");
		 */
		cmdSubstitutions.put("walk", "go");
		cmdSubstitutions.put("run", "go");
		cmdSubstitutions.put("crawl", "go");
		cmdSubstitutions.put("sprint", "go");
		cmdSubstitutions.put("jog", "go");

		cmdSubstitutions.put("grab", "take");
		cmdSubstitutions.put("get", "take");

		cmdSubstitutions.put("see", "look");
		cmdSubstitutions.put("view", "look");

		/*
		 * full substitutions only replace if the whole command given equals
		 * 
		 * How to add full substitutions: fullSubstitutions.put("string",
		 * "replacement");
		 */

		/*
		 * full substitutions only replace if the whole command given equals
		 * 
		 * How to add full substitutions: dirSubstitutions.put("string", "replacement");
		 */
		dirSubstitutions.put("u", "go up");
		dirSubstitutions.put("d", "go down");
		dirSubstitutions.put("n", "go north");
		dirSubstitutions.put("e", "go east");
		dirSubstitutions.put("s", "go south");
		dirSubstitutions.put("w", "go west");
		dirSubstitutions.put("ne", "go northeast");
		dirSubstitutions.put("nw", "go northwest");
		dirSubstitutions.put("se", "go southeast");
		dirSubstitutions.put("sw", "go southwest");
		dirSubstitutions.put("l", "look");
	}

	private static String replaceLast (String text, String regex, String replacement) {
		return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
	}

	// TODO add commands

	// look (see, view, look at), go (walk run crawl sprint jog), take (grab get),
	// use, break, help, type, move {item}, pull, press, remove, shoot, kill, open,
	// wear [as in wear a coat], equip {dagger}

	public static String replaceCommand (String command) {
		String oldCommand = command.trim();

		String dirCommand = replaceDirection(oldCommand);
		if (!dirCommand.equals(oldCommand)) {
			return dirCommand;
		}

		for (Map.Entry<String, String> entry : fullSubstitutions.entrySet()) {
			if (oldCommand.equals(entry.getKey())) {
				return entry.getValue();
			}
		}

		// -----

		String newCommand = command.trim();
		String [] cmdArray = oldCommand.split(" ");
		String cmd = cmdArray[0];

		for (Map.Entry<String, String> entry : cmdSubstitutions.entrySet()) {
			if (cmd.equals(entry.getKey())) {
				cmdArray[0] = entry.getValue();
				newCommand = String.join(" ", cmdArray);
				break;
			}
		}

		for (Map.Entry<String, String> entry : substitutions.entrySet()) {
			newCommand = newCommand.replaceAll(" " + entry.getKey() + " ", entry.getValue());
			if (newCommand.startsWith(entry.getKey())) {
				newCommand = newCommand.replaceFirst(entry.getKey(), entry.getValue());
			}
			if (newCommand.endsWith(entry.getKey())) {
				newCommand = replaceLast(newCommand, entry.getKey(), entry.getValue());
			}
		}

		return newCommand;
	}

	public static String replaceDirection (String direction) {
		for (Map.Entry<String, String> entry : dirSubstitutions.entrySet()) {
			if (direction.trim().equals(entry.getKey())) {
				return entry.getValue();
			}
		}
		return direction;
	}
}
