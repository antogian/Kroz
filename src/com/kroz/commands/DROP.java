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
public class DROP implements ICommand{
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
   
    public DROP(){
        this.initialize();
    }
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new Trap();
    }
    
    /**
     * Implements the setCurrentPlayer method of the ICommand interface.
     * * @param newCurrentPlayer Player who's interacting.
     */
    @Override
    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }
    
    public void setCurrentItem(Item currentItem){
        this.currentItem = currentItem;
    }
    
    /**
     * Implements the setCommandTextList method of the ICommand interface.
     * @param newRawCommandText The actual input taken from the user through console.
     */
    @Override
    public void setCommandTextList(List<String> rawCommandText){
        this.currentCommandTextList = rawCommandText;
    }
    
     /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
     /**
     * Checks whether or not the item is available in the player's inventory to drop it.
     */
    public boolean itemExists(){
        for(Item tempItem : this.currentPlayer.getPlayerInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                this.setCurrentItem(tempItem);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct,
     * this method checks whether the object is available
     * in player's inventory with and as long as it is, it drops it.
     */
    @Override
    public void executeCommand(){
        if(this.isValid()){
            if (this.itemExists()){
                this.getItemFromPlayer();
                this.addItemToScene();
                System.out.println(this.currentItem.getItemName() + " removed from INVENTORY");
            }
            else {
                System.out.println(this.currentCommandTextList.toString().toUpperCase() + " doesn't exist.");
            }
        }
        else {
            this.getInvalidInputMessage();
        }
    }
    
    /**
     * Takes item from player's inventory
     */
    public void getItemFromPlayer(){
        this.currentPlayer.getPlayerInventory().removeItemFromInventory(this.currentItem);
    }
    
    /**
     * Adds item taken from player to the current scene player is in.
     */
    public void addItemToScene(){
        this.currentPlayer.getPlayerCurrentScene().getSceneInventory().addItemInInventory(this.currentItem);
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command DROP takes one parameter. Try: [DROP parameter]";
    }
}