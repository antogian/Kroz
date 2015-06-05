/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.OpenableItem;
import com.kroz.player.Player;
import com.kroz.scene.SceneExit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class CLOSE implements ICommand{
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private OpenableItem currentItem;

    public CLOSE(){
        this.initialize();
    }
    
    private void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new OpenableItem();
    }

    /**
     * Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct,
     * this method checks whether the object is available
     * to interact with and as long as it is, checks whether 
     * it is open to close it and vice versa.
     */
    @Override
    public void executeCommand(){
        if(this.isValid()){
            if (this.itemExists()) {
                if (this.isItemOpen()) {
                    this.currentItem.changeItemState();
                    System.out.println(this.currentItem.getItemName() + " closed");
                }
                else {
                    System.out.println(this.currentItem.getItemName() + " is already closed");
                }
            }
            else {
                System.out.println(this.currentCommandTextList.toString().toUpperCase() + " doesn't exist.");
            }
        }
        else{
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
    
    public void setCurrentItem(OpenableItem newItem){
        this.currentItem = newItem;
    }
    
    /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
    /**
     * Checks whether or not the item is available at the current scene for the player to interact with.
     */
    public boolean itemExists(){
        if (this.currentPlayer.getPlayerCurrentScene().getSceneInventory().itemExists(this.currentItem)){
            return true;
        }
        else{
            List <SceneExit> exitsList = new ArrayList<SceneExit>();
            exitsList = this.currentPlayer.getPlayerCurrentScenario().getScenarioMap().getSceneExits(this.currentPlayer.getPlayerCurrentScene());
            for(SceneExit tempSceneExit : exitsList){
                if (!tempSceneExit.getSceneDoor().getItemState().getValue().equals("DEFAULT")){
                    if (tempSceneExit.getSceneDoor().getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                        setCurrentItem(tempSceneExit.getSceneDoor());
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command CLOSE takes one parameter. Try: [CLOSE parameter]";
    }
}
