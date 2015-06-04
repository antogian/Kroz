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
 * Look command displays the description of the current scene.
 * @author Eleni Aidonidou
 */
public class LOOK implements ICommand {
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private LightableItem currentItem;
    /**
     * Constructor of LOOK command without parameters.
     */
    public LOOK() {
        initialize();
    }
    private void initialize() {
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
        this.currentItem = new Torch();
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct and the scene is lighten
     * then it reveals the scene inventory to the player. If not, it informs
     * the player that he/she will not see a thing.
     */
    @Override
    public void executeCommand() {
        if (this.isValid()){
            if (this.hasSceneLighting() || this.isLightableItemOn()){
                System.out.println("\n" + currentPlayer.getPlayerCurrentScene().getSceneDescription());
                this.currentPlayer.getPlayerCurrentScene().showSceneInventory();
            }
            else {
                System.out.println("It's too dark, you can't see anything.");
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
    public void setCurrentPlayer(Player newCurrentPlayer) {
        this.currentPlayer = newCurrentPlayer;
    }

    /**
     * Implements the setCommandTextList method of the ICommand interface.
     * @param newRawCommandText The actual input taken from the user through console.
     */
    @Override
    public void setCommandTextList(List<String> newRawCommandText) {
        this.currentCommandTextList = newRawCommandText;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = (LightableItem)currentItem;
    }

    /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid() {
        return this.currentCommandTextList.isEmpty();
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command LOOK doesn't get any parameters. Try: [LOOK]";
    }
    
    /**
     * Checks if the scene is lighten.
     * @return Whether there is light in scene or not.
     */
    public boolean hasSceneLighting(){
        return this.currentPlayer.getPlayerCurrentScene().hasLighting();
    }
    
    /**
     * Checks if the player has a torch (or similar item) and if it is on.
     * @return If player torch item is on or not.
     */
    public boolean isLightableItemOn(){
        if (this.currentPlayer.getPlayerInventory().itemExists(this.currentItem)){
            this.setCurrentItem(this.currentPlayer.getPlayerInventory().getItemFromInventory(this.currentItem));
            return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
        }
        else {
            return false;
        }
    }
}