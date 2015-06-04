/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Item;
import com.kroz.items.Trap;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class EXAMINE implements ICommand{

    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
    
    
    public EXAMINE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new Trap();
    }
    
    /**
     * Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct,
     * this method checks whether the object is available
     * to interact with and as long as it is, it prints its description.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                System.out.println(this.currentItem.getItemDescription());
            }
            else {
                System.out.println(this.currentCommandTextList.get(0).toUpperCase() + " doesn't exist");
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
    
    public void setCurrentItem(Item item){
        this.currentItem = item;
    }
    
    /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
    /**
     * Checks whether or not the item is available to interact with.
     */
    public boolean itemExists(){
        for(Item tempItem : this.currentPlayer.getPlayerCurrentScene().getSceneInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                setCurrentItem(tempItem);
                return true;
            }
        }
        for(Item tempItem : this.currentPlayer.getPlayerInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                setCurrentItem(tempItem);
                return true;
            }
        }
        return false;
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command EXAMINE takes one parameter. Try: [EXAMINE parameter]";
    }
    
}