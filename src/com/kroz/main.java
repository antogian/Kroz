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
import com.kroz.scenes.Scene;


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
        Player player = new Player("The Player!");
        ConsoleInputParser consoleInputParser = new ConsoleInputParser();
        CommandParser commandParser = new CommandParser();
        ICommand currentCommand;

        //Gets new Player Name and prints out The new players name
        player.setPlayerName();
        player.getPlayerName();

         //Prints out the Scenes of the current Scenario
        System.out.println("Scene List:");
        for (Scene scene : scenario.getScenarioSceneList()) {
            System.out.println(new StringBuilder()
                    .append("Scene ID: ").append(scene.getSceneId())
                    .append(" Scene Description: ").append(scene.getSceneDescription())
                    .append("\n").toString());
        }

        Scene currentScene = new Scene();
        currentScene = currentScene.extractCurrentScene(player, scenario);
        System.out.println(currentScene.getSceneDescription());

        while (!scenario.isScenarioComplete()) {
            commandParser.setRawCommandText(consoleInputParser.getInputFromConsole());
            try {
                currentCommand = commandParser.createCommand(player, scenario);
                currentScene = currentCommand.executeCommand(currentScene, player);
            } catch (IllegalArgumentException e) {
            /*if exception is caused user is prompted to enter
            another command so there is no need for catch code*/
            }
        }

        //should be at the end of the main method
        consoleInputParser.closeStream();
    }

}
