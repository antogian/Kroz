/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz;

import com.kroz.commands.ICommand;
import com.kroz.parsers.CommandParser;
import com.kroz.parsers.ConsoleInputParser;
import com.kroz.player.Player;
import com.kroz.scenario.DefaultScenario;
import com.kroz.scenario.IScenario;


/**
 * Main Class.
 * @author Eleni Aidonidou
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        IScenario scenario = new DefaultScenario();
        Player player = new Player();
        ConsoleInputParser consoleInputParser = new ConsoleInputParser();
        CommandParser commandParser = new CommandParser();
        ICommand currentCommand;

        //Gets new Player Name and prints out The new players name
        player.setPlayerName();
        player.getPlayerName();
        player.setPlayerCurrentScenario(scenario);
        //Sets the players current scene to the first scene of the scenario
        if (player.getPlayerCurrentScene().getSceneDescription().equalsIgnoreCase("Default Scene Desctiption.")){
            player.setPlayerCurrentScene(scenario.getScenarioSceneList().get(0));
        }

        System.out.println(player.getPlayerCurrentScene().getSceneDescription());

        while (!scenario.isScenarioComplete()) {
            commandParser.setRawCommandText(consoleInputParser.getInputFromConsole());
            try {
                currentCommand = commandParser.createCommand(player);
                currentCommand.executeCommand();
            } catch (IllegalArgumentException e) {
            /*if exception is caused user is prompted to enter
            another command so there is no need for catch code*/
            }
        }

        //should be at the end of the main method
        consoleInputParser.closeStream();
    }

}
