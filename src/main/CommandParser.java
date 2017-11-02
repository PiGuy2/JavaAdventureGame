package main;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
	private static HashMap<String, String> substitutions = new HashMap<String, String>();
	private static HashMap<String, String> cmdSubstitutions = new HashMap<String, String>();
	private static HashMap<String, String> fullSubstitutions = new HashMap<String, String>();
	static {
		// How to add substitutions:
		// substitutions.put("string", "replacement");
		substitutions.put("north-east", "northeast");
		substitutions.put("north-west", "northwest");
		substitutions.put("south-east", "southeast");
		substitutions.put("south-west", "southwest");

		// How to add command substitutions:
		// cmdSubstitutions.put("string", "replacement");

		// How to full substitutions:
		// substitutions.put("string", "replacement");
		cmdSubstitutions.put("u", "go up");
		cmdSubstitutions.put("d", "go down");
		cmdSubstitutions.put("n", "go north");
		cmdSubstitutions.put("e", "go east");
		cmdSubstitutions.put("s", "go south");
		cmdSubstitutions.put("w", "go west");
		cmdSubstitutions.put("ne", "go northeast");
		cmdSubstitutions.put("nw", "go northwest");
		cmdSubstitutions.put("se", "go southeast");
		cmdSubstitutions.put("sw", "go southwest");
	}

	public static String replaceCommand (String oldCommand) {
		String newCommand = oldCommand;
		for (Map.Entry<String, String> entry : fullSubstitutions.entrySet()) {
			if (newCommand.equals(entry.getKey())) {
				//
			}
		}
		return newCommand;
	}
}
