/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Item;
import com.kroz.items.LightableItem;
import com.kroz.items.Torch;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class LIGHT implements ICommand{

    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private LightableItem currentItem;
    
    public LIGHT(){
        this.initialize();
    }
    
    private void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new Torch();
    }
    
    /**
     * Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it checks
     * whether or not the item is lit to light it. If it is alreDY lit
     * it prints a corresponding message.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                if (this.isTorchOn()){
                    System.out.println(this.currentItem.getItemName().toUpperCase() + " is already turned on.");
                }
                else {
                    this.currentItem.lightItem(this.currentPlayer.getPlayerCurrentScene());
                    System.out.println(this.currentItem.getItemName().toUpperCase() + " lightened. Now you can see everything.");
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
        this.currentItem = (Torch) item;
    }
    
    /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
    /**
     * Checks whether or not the item is available in the player's inventory to light it.
     */
    public boolean itemExists(){
        return this.currentPlayer.getPlayerInventory().itemExists(this.currentItem);
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command EXAMINE takes one parameter. Try: [EXAMINE parameter]";
    }
    
    /**
     * Renders the torch lit.
     */
    public boolean isTorchOn(){
        if (this.itemExists()){
            this.setCurrentItem(this.currentPlayer.getPlayerInventory().getItemFromInventory(this.currentItem));
            return this.currentItem.getItemState().getValue().equals("ON");
        }
        else {
            return false;
        }
    }   
}