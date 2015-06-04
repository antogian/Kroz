/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class SAVE implements ICommand{
    public Player currentPlayer;
    public List<String> currentCommandTextList;
    
    public SAVE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct it creates an external
     * XML file named like the player's name. This is the save file.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            String filename = this.currentPlayer.getRawPlayerName() + ".xml";
            try{
                XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
                encoder.writeObject(this.currentPlayer);
                encoder.close();
                System.out.println("Game saved.");
            }
            catch(Exception e){
                System.out.println("Save game failed. Please try again.");
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
        return this.currentCommandTextList.isEmpty();
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command SAVE doesnt get any parameters. Try: [SAVE]";
    }
    
}