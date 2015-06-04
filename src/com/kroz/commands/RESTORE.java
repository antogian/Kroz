/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.Main;
import com.kroz.player.Player;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class RESTORE implements ICommand{
    public Player currentPlayer;
    public List<String> currentCommandTextList;
    
    public RESTORE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it reads player's
     * input from console followed by .xml suffix and if it finds the 
     * corresponding file it loads it by restoring the adventure of the player.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            String filename = this.currentCommandTextList.get(0) + ".xml";
            try {
                XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
                Player newPlayer = (Player)decoder.readObject();
                decoder.close();
                this.assignNewPlayer(newPlayer);
                System.out.println("Game restored.");
                System.out.println(this.currentPlayer.getPlayerCurrentScene().getSceneDescription());
                System.out.println("");
            }
            catch(Exception e){
                System.out.println("Restore game failed. Please try again.");
            }
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
        return this.currentCommandTextList.size() == 1;
    }
    
    /**
     * It creates a new player object which has all the attributes of the player
     * contained in the save file thus restoring that player's adventure.
     * @param newPlayer The new "old" player object.
     */
    public void assignNewPlayer(Player newPlayer){
        Main m = new Main();
        m.setPlayer(newPlayer);
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
        return "Command RESTORE takes one parameter. Try: [RESTORE PlayerName]";
    }
}