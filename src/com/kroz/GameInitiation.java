/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz;

import com.kroz.commands.EXIT;
import com.kroz.commands.ICommand;
import com.kroz.parsers.CommandParser;
import com.kroz.parsers.ConsoleInputParser;
import com.kroz.player.Player;
import com.kroz.scenario.CustomScenario;
import com.kroz.scenario.DefaultScenario;
import com.kroz.scenario.IScenario;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Immortuon
 */
public class GameInitiation {
    private Scanner scanner;
    
    public GameInitiation() throws FileNotFoundException{
        scanner = new Scanner(System.in);
        System.out.println("Welcome, Oh Brave One. How shalt thou proceed? [1:New Game][2:Load Game][3:Quit]");
        String choice = scanner.nextLine();
        while ((choice.length() < 1 || choice.length() > 1)||(!"1".equals(choice) && !"2".equals(choice) && !"3".equals(choice))||(choice.matches("[a-z]"))){
                System.out.println("Wrong Syndax or choice. Enter new input: ");
                choice = scanner.nextLine();
        
        }
        switch (choice) {
            case "1": System.out.println("Thou art not prepared for what lies ahead! Name yourself stranger!");
                    Player player = new Player();
                    player.setPlayerName();
	            System.out.println("Fool thou! Now go ahead, go ahead and die for die you must! Choose thy end! [1.Blackfathom Deeps] [2.Default Scenario]");
                    String newChoice = scanner.nextLine();
                    while ((newChoice.length() > 1 || newChoice.length() < 1)||(!"1".equals(newChoice) && !"2".equals(newChoice))) {
                        System.out.println("Wrong Syndax. Enter new input: ");
                        newChoice = scanner.nextLine();
                    }
		    switch(newChoice){
			case "1": System.out.println("For thine is the choice! Prepare, thou mortal!");
                                IScenario scenario = new CustomScenario();
                                player.setPlayerCurrentScenario(scenario);
                                ConsoleInputParser consoleInputParser = new ConsoleInputParser();
                                CommandParser commandParser = new CommandParser();
                                ICommand currentCommand;
                                player.setPlayerCurrentScene(scenario.getScenarioSceneList().get(0));
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
                                consoleInputParser.closeStream();
                        
                        case "2": System.out.println("Thou chose to walk the road that many failed to cross! Now go and meet'ya maker!");
                                IScenario newScenario = new DefaultScenario();
                                player.setPlayerCurrentScenario(newScenario);
                                ConsoleInputParser newConsoleInputParser = new ConsoleInputParser();
                                CommandParser newCommandParser = new CommandParser();
                                ICommand newCurrentCommand;
                                player.setPlayerCurrentScene(newScenario.getScenarioSceneList().get(0));
                                System.out.println(player.getPlayerCurrentScene().getSceneDescription());
                                while (!newScenario.isScenarioComplete()) {
                                    newCommandParser.setRawCommandText(newConsoleInputParser.getInputFromConsole());
                                try {
                                    newCurrentCommand = newCommandParser.createCommand(player);
                                    newCurrentCommand.executeCommand();
                                } catch (IllegalArgumentException e) {
                                /*if exception is caused user is prompted to enter
                                another command so there is no need for catch code*/
                                }
                                }
                                newConsoleInputParser.closeStream();
                    }
            case "2": System.out.println("So, you want to throw your life away... Now, give me your name!");
                      String filename = scanner.next();
                    
                      filename = filename + ".xml";
                      try {
                        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
                        Player newPlayer = (Player)decoder.readObject();
                        decoder.close();
                        Player currentPlayer = new Player();
                        currentPlayer.setPlayerCurrentScenario(newPlayer.getPlayerCurrentScenario());
                        currentPlayer.setPlayerInventory(newPlayer.getPlayerInventory());
                        currentPlayer.setPlayerCurrentScene(newPlayer.getPlayerCurrentScene());
                        currentPlayer.setRawPlayerName(newPlayer.getRawPlayerName());
                        System.out.println("Game restored");
                        IScenario newScenario = new DefaultScenario();
                        ConsoleInputParser newConsoleInputParser = new ConsoleInputParser();
                        CommandParser newCommandParser = new CommandParser();
                        ICommand newCurrentCommand;
                        System.out.println(currentPlayer.getPlayerCurrentScene().getSceneDescription());
                        while (!newScenario.isScenarioComplete()) {
                        newCommandParser.setRawCommandText(newConsoleInputParser.getInputFromConsole());
                        try {
                            newCurrentCommand = newCommandParser.createCommand(currentPlayer);
                            newCurrentCommand.executeCommand();
                        } catch (IllegalArgumentException e) {
                            /*if exception is caused user is prompted to enter
                            another command so there is no need for catch code*/
                       }
                    }
                    newConsoleInputParser.closeStream();
                    }
                    catch(Exception e){
                        System.out.println("There is no such file.");
                    }
            case "3": System.out.println("Farewell, oh mighty adventurer... May the Force be with you!");
                    EXIT exit = new EXIT();
                    exit.executeCommand();
        }
    }
    
    public void closeStream() {
        scanner.close();
    }
    
}
