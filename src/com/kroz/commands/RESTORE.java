/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

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
    
    @Override
    public void executeCommand(){
        if (this.isValid()){
            String filename = this.currentCommandTextList.get(0) + ".xml";
            try {
                XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
                Player newPlayer = (Player)decoder.readObject();
                decoder.close();
                this.assignNewPlayer(newPlayer);
                System.out.println("Game restored");
            }
            catch(Exception e){
                System.out.println("Exception caught");
            }
        }
        else {
            this.getInvalidInputMessage();
        }
    }
    
    @Override
    public void setCurrentPlayer(Player newCurrentPlayer){
        this.currentPlayer = newCurrentPlayer;
    }
    
    @Override
    public void setCommandTextList(List<String> newRawCommandText){
        this.currentCommandTextList = newRawCommandText;
    }

    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
    public void assignNewPlayer(Player newPlayer){
        this.currentPlayer.setPlayerCurrentScenario(newPlayer.getPlayerCurrentScenario());
        this.currentPlayer.setPlayerInventory(newPlayer.getPlayerInventory());
        this.currentPlayer.setPlayerCurrentScene(newPlayer.getPlayerCurrentScene());
        this.currentPlayer.setRawPlayerName(newPlayer.getRawPlayerName());
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command RESTORE takes one parameter. Try: [RESTORE PlayerName]";
    }
}