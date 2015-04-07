/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.parsers;

import com.kroz.commands.CLOSE;
import com.kroz.commands.DROP;
import com.kroz.commands.EXAMINE;
import com.kroz.commands.EXIT;
import com.kroz.commands.GO;
import com.kroz.commands.ICommand;
import com.kroz.commands.INVENTORY;
import com.kroz.commands.LOOK;
import com.kroz.commands.OPEN;
import com.kroz.commands.TAKE;
import com.kroz.commands.USE;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tony
 */
public class CommandParser {
    private List<String> rawCommandText;
    private Map<String, Class<? extends ICommand>> commandsMap;

    public CommandParser() {
        initialize();
    }
    /**
    *Initializes attributes
    */
    private void initialize() {
        this.rawCommandText = new ArrayList<String>();
        this.commandsMap = new HashMap<String, Class<? extends ICommand>>();
        this.commandsMap.put("GO", GO.class);
        this.commandsMap.put("LOOK", LOOK.class);
        this.commandsMap.put("EXIT", EXIT.class);
        this.commandsMap.put("INVENTORY", INVENTORY.class);
        this.commandsMap.put("OPEN", OPEN.class);
        this.commandsMap.put("CLOSE", CLOSE.class);
        this.commandsMap.put("TAKE", TAKE.class);
        this.commandsMap.put("DROP", DROP.class);
        this.commandsMap.put("EXAMINE", EXAMINE.class);
        this.commandsMap.put("USE", USE.class);
    }
    /**
     * @param rawCommandString is the input string as the user typed it.
     * So in order to set it, it's necessary to invoke the split method.
     *
     */
    public void setRawCommandText(String rawCommandString) {
        try {
            this.rawCommandText = this.splitRawCommandString(rawCommandString);
            if (this.rawCommandText.isEmpty()) {
                throw new EmptyStackException();
            }
        } catch (EmptyStackException e) {
            System.out.println("No valid commands were entered.");
        }
    }
    /**
     * @return rawCommandText
     */
    public List<String> getRawCommandText() {
        return rawCommandText;
    }
    /**
     * @param string is the original input string.
     * @return the two parts of the split string in an ArrayList
     */
    public List<String> splitRawCommandString(String string) {
        return new ArrayList<String>(Arrays.asList(string.split(" ")));
    }
    /**
     * @param player the current player's attributes
     * @return created command that is going to be executed
     * @throws IllegalArgumentException indicates that the method has been passed an illegal or inappropriate argument
     */
    public ICommand createCommand(Player player) throws IllegalArgumentException {
        ICommand newCommand = new LOOK(); //initializing with new LOOK object to avoid Null Pointer //TODO find a better solution to that
        if (commandsMap.containsKey(this.rawCommandText.get(0).toUpperCase())) {
            try {
                newCommand = commandsMap.get(this.rawCommandText.get(0).toUpperCase()).newInstance();
                rawCommandText.remove(0); //removes the part of the text that defines the type of command
                newCommand.setCommandTextList(rawCommandText);
                newCommand.setCurrentPlayer(player);
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException thrown");
            } catch (InstantiationException e) {
                System.out.println("InstantiationException thrown");
            } catch (ExceptionInInitializerError e) {
                System.out.println("ExceptionInInitializerError thrown");
            } catch (SecurityException e) {
                System.out.println("SecurityException thrown");
            }
        } else {
            System.out.println("Invalid Command. Exception thrown.");
            throw new IllegalArgumentException();
        }
        return newCommand;
    }
}