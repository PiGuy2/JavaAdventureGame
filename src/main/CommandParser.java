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

        // full substitutions only replace if the whole command given equals
        // How to full substitutions:
        // fullSubstitutions.put("string", "replacement");
        fullSubstitutions.put("u", "go up");
        fullSubstitutions.put("d", "go down");
        fullSubstitutions.put("n", "go north");
        fullSubstitutions.put("e", "go east");
        fullSubstitutions.put("s", "go south");
        fullSubstitutions.put("w", "go west");
        fullSubstitutions.put("ne", "go northeast");
        fullSubstitutions.put("nw", "go northwest");
        fullSubstitutions.put("se", "go southeast");
        fullSubstitutions.put("sw", "go southwest");
    }

    public static String replaceCommand (String command) {
        String oldCommand = command.trim();
        String newCommand = command.trim();
        
        for (Map.Entry<String, String> entry : fullSubstitutions.entrySet()) {
            if (oldCommand.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        // ---
        String[] cmdArray = oldCommand.split(" ");
        String cmd = cmdArray[0];
        for (Map.Entry<String, String> entry : cmdSubstitutions.entrySet()) {
            if (cmd.equals(entry.getKey())) {
                cmdArray[0] = entry.getValue();
                newCommand = String.join(" ", cmdArray);
            }
        }
        // ---
        // for (Map.Entry<String, String> entry : cmdSubstitutions.entrySet()) {
            // if (cmd.equals(entry.getKey())) {
                // cmdArray[0] = entry.getValue();
                // newCommand = String.join(" ", cmdArray);
            // }
        // }
        
        return oldCommand;
    }
}
