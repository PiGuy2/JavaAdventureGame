package main;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
	private static HashMap<String, String> cmdSubstitutions = new HashMap<String, String>();
	private static HashMap<String, String> dirSubstitutions = new HashMap<String, String>();
	private static HashMap<String, String> fullSubstitutions = new HashMap<String, String>();
	private static HashMap<String, String> substitutions = new HashMap<String, String>();

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

		cmdSubstitutions.put("t", "take");
		cmdSubstitutions.put("g", "go");
		cmdSubstitutions.put("dr", "drop");
		cmdSubstitutions.put("h", "help");

		/*
		 * full substitutions only replace if the whole command given equals
		 * 
		 * How to add full substitutions: fullSubstitutions.put("string",
		 * "replacement");
		 */
		fullSubstitutions.put("l", "look");
		fullSubstitutions.put("i", "inventory");
		fullSubstitutions.put("q", "quit");

		/*
		 * full substitutions only replace if the whole command given equals
		 * 
		 * How to add full substitutions: dirSubstitutions.put("string", "replacement");
		 */
		dirSubstitutions.put("u", "up");
		dirSubstitutions.put("d", "down");
		dirSubstitutions.put("n", "north");
		dirSubstitutions.put("e", "east");
		dirSubstitutions.put("s", "south");
		dirSubstitutions.put("w", "west");
		dirSubstitutions.put("ne", "northeast");
		dirSubstitutions.put("nw", "northwest");
		dirSubstitutions.put("se", "southeast");
		dirSubstitutions.put("sw", "southwest");
	}

	/*
	 * look (see, view, look at), go (walk run crawl sprint jog), take (grab get),
	 * use, break, help, type, move {item}, pull, press, remove, shoot, kill, open,
	 * wear [as in wear a coat], equip {dagger}
	 */
	public static String replaceCommand (String command) {
		String oldCommand = command.trim();

		oldCommand = oldCommand.replaceAll(" +", " ");

		String dirCommand = replaceDirection(oldCommand);
		if (!dirCommand.equals(oldCommand)) {
			return "go " + dirCommand;
		}

		for (Map.Entry<String, String> entry : fullSubstitutions.entrySet()) {
			if (oldCommand.equals(entry.getKey())) {
				return entry.getValue();
			}
		}

		// -----

		String newCommand = new String(oldCommand);
		String [] cmdArray = oldCommand.split(" ");
		String cmd = cmdArray[0];

		for (Map.Entry<String, String> entry : cmdSubstitutions.entrySet()) {
			if (cmd.equals(entry.getKey())) {
				cmdArray[0] = entry.getValue();
				newCommand = String.join(" ", cmdArray);
				break;
			}
		}

		HashMap<String, String> singleSubs = new HashMap<>();
		singleSubs.putAll(substitutions);
		singleSubs.putAll(dirSubstitutions);
		for (Map.Entry<String, String> entry : singleSubs.entrySet()) {
			// System.out.println(entry.getKey() + " --> " + entry.getValue());
			newCommand = newCommand.replaceAll(" " + entry.getKey() + " ", " " + entry.getValue() + " ");
			// System.out.println("\t1. " + newCommand);
			if (newCommand.startsWith(entry.getKey() + " ")) {
				newCommand = newCommand.replaceFirst(entry.getKey(), entry.getValue());
			}
			// System.out.println("\t2. " + newCommand);
			if (newCommand.endsWith(" " + entry.getKey())) {
				newCommand = replaceLast(newCommand, entry.getKey(), entry.getValue());
			}
			// System.out.println("\t3. " + newCommand);
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

	private static String replaceLast (String text, String regex, String replacement) {
		return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
	}
}
