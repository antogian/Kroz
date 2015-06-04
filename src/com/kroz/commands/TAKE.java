/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.items.Item;
import com.kroz.items.Trap;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tony
 */
public class TAKE implements ICommand{
    
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
   
    public TAKE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new Trap();
    }
    
    /**
     * Implements the setCurrentPlayer method of the ICommand interface.
     * @param newCurrentPlayer Player who's interacting.
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
     * Checks whether or not the item is available in the scene's inventory to take it.
     */
    public boolean itemExists(){
        for(Item tempItem : this.currentPlayer.getPlayerCurrentScene().getSceneInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                setCurrentItem(tempItem);
                return true;
            }
        }
        return false;
    }
    
     /**
     * Checks if the item is eligible for the player to take it
     * @return Whether or not the item can be acquired.
     */
    public boolean isPlayerObject(){
        return this.currentItem.getItemType().getValue().equalsIgnoreCase("PO");
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it checks if the item
     * is present in scene. If so it checks whether it can be acquired by the
     * player or not and if it does then it adds in player's inventory.
     * Otherwise, it informs the player that the player id ineligible for possession.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()){
                if (this.isPlayerObject()){
                    this.removeItemFromScene();
                    this.addItemToPlayer();
                    System.out.println(this.currentItem.getItemName() + " added to INVENTORY");
                    if (this.currentItem.getItemName().equalsIgnoreCase("Briefcase")){
                        this.currentPlayer.getPlayerCurrentScenario().setScenarioComplete(true);
                        System.out.println("You are now a millionaire!");
                    }
                }
                else {
                    System.out.println("You can't do that.");
                }
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
     * It removes the item from the scene inventory when it is taken by the player.
     */
    public void removeItemFromScene(){
        this.currentPlayer.getPlayerCurrentScene().getSceneInventory().removeItemFromInventory(this.currentItem);
    }
    
    /**
     * It adds the item to player's inventory.
     */
    public void addItemToPlayer(){
        this.currentPlayer.getPlayerInventory().addItemInInventory(this.currentItem);
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command TAKE takes one parameter. Try: [TAKE parameter]";
    }
}
