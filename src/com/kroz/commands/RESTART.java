/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.scenario.DefaultScenario;
import com.kroz.scenario.IScenario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class RESTART implements ICommand{
    public Player currentPlayer;
    public List<String> currentCommandTextList;
    public IScenario scenario;
    
    public RESTART(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
        scenario = new DefaultScenario();
        
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it empties
     * player's inventory and returns him/her to the beginning of the
     * adventure resulting in a game restart.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            this.currentPlayer.setPlayerCurrentScene(scenario.getScenarioSceneList().get(0));
            this.currentPlayer.getPlayerInventory().clearInventory();
            System.out.println("Game restarted\n");
            System.out.println(this.getCurrentPlayer().getPlayerCurrentScene().getSceneDescription());
        }
        else {
            this.getInvalidInputMessage();
        }
    }
    
    /**
     * Implements the setCurrentPlayer method of the ICommand interface.
     * @param newCurrentPlayer Player who's interacting.
     */
    @Override
    public void setCurrentPlayer(Player newCurrentPlayer){
        this.currentPlayer = newCurrentPlayer;
    }
    
    /**
     * Implements the setCommandTextList method of the ICommand interface.
     * @param newRawCommandText The actual input taken from the user through console.
     */
    @Override
    public void setCommandTextList(List<String> newRawCommandText){
        this.currentCommandTextList = newRawCommandText;
    }

    /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.isEmpty();
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command RESTART doesnt get any parameters. Try: [RESTART]";
    }
}
