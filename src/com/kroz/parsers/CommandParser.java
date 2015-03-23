/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.parsers;

import com.kroz.commands.EXIT;
import com.kroz.commands.GO;
import com.kroz.commands.ICommand;
import com.kroz.commands.LOOK;
import com.kroz.player.Player;
import com.kroz.scenario.IScenario;
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
    private List<String> commands;
    private Map<String, Class<? extends ICommand>> commandMap;

    public CommandParser() {
        initialize();
    }
    
    /**
    *Initializes attributes
    */
    private void initialize() {
        this.rawCommandText = new ArrayList<String>();
        this.commands = new ArrayList<String>();
        this.commands.add("GO");
        this.commands.add("LOOK");
        this.commandMap = new HashMap<>();
        this.commandMap.put("GO", GO.class);
        this.commandMap.put("LOOK", LOOK.class);
        this.commandMap.put("EXIT", EXIT.class);
    }
    
    /**
     * 
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
     * 
     * @return rawCommandText
     */
    public List<String> getRawCommandText() {
        return rawCommandText;
    }

    /**
     * 
     * @param string is the original input string.
     * @return the two parts of the splited string in an ArrayList
     */
    public List<String> splitRawCommandString (String string) {
        return new ArrayList<String>(Arrays.asList(string.split(" ")));
    }

    /**
     * 
     * @param player the current player's attributes
     * @param scenario the scenario that the player is currently playing
     * @return created command that is going to be executed
     * @throws IllegalArgumentException indicates that the method has been passed an illegal or inappropriate argument
     */
    public ICommand createCommand(Player player, IScenario scenario) throws IllegalArgumentException{
        /*ICommand newCommand;
        if (this.rawCommandText.get(0).equalsIgnoreCase("GO")) {
            if (this.rawCommandText.size() > 2) {
                System.out.println("Command GO takes one parameter. Try: [GO parameter]");
                throw new IllegalArgumentException();
            } else if (this.rawCommandText.size() <= 1) {
                System.out.println("Command GO takes one parameter. Try: [GO parameter]");
                throw new IllegalArgumentException();
            } else {
                newCommand = new GO(player, scenario, this.rawCommandText.get(1));
            }
        } else if (this.rawCommandText.get(0).equalsIgnoreCase("LOOK")) {
            if (this.rawCommandText.size() > 1) {
                System.out.println("Command LOOK doesnt get any parameters. Try: [LOOK]");
                throw new IllegalArgumentException();
            } else if (this.rawCommandText.size() < 1) {
                System.out.println("Command LOOK doesnt get any parameters. Try: [LOOK]");
                throw new IllegalArgumentException();
            } else {
                newCommand = new LOOK();
            }
        } else if (this.rawCommandText.get(0).equalsIgnoreCase("EXIT")) {
            if (this.rawCommandText.size() > 1) {
                System.out.println("Command EXIT doesnt get any parameters. Try: [EXIT]");
                throw new IllegalArgumentException();
            } else {
                newCommand = new EXIT();
            }
        } else {
            System.out.println("Invalid Command. Exception thrown.");
            throw new IllegalArgumentException();
        }
        return newCommand;*/
        ICommand newCommand;
        if(commandMap.containsKey(this.rawCommandText.get(0).toUpperCase())){
            try{
                newCommand = commandMap.get(this.rawCommandText.get(0).toUpperCase()).newInstance();
                return newCommand;
            }
            catch(IllegalAccessException e){
                System.out.println("IllegalAccessException thrown");
            }
            catch(InstantiationException e){
                System.out.println("InstantiationException thrown");
            }
            catch(ExceptionInInitializerError e){
                System.out.println("ExceptionInInitializerError thrown");
            }
            catch(SecurityException e){
                System.out.println("SecurityException thrown");
            }
        }
        return null;
    }
}
