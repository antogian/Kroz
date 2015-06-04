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
public class OPEN implements ICommand{
    
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private OpenableItem currentItem;  
    
    public OPEN(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new OpenableItem();
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct and the item he/she
     * tries to unlock present at current scene's inventory, it checks if the
     * item is already unlocked and it informs the player about. If it is locked
     * it renders it unlocked.
     */
    @Override
    public void executeCommand(){
        if(this.isValid()){
            if (this.itemExists()) {
                if (this.isItemOpen()) {
                    System.out.println(this.currentItem.getItemName() + " is already open.");
                }
                else {
                    if (this.isItemLocked()) {
                        System.out.println(this.currentItem.getItemName() + " is locked.");
                    }
                    else {
                        this.currentItem.changeItemState();
                        System.out.println(this.currentItem.getItemName() + " opened.");
                    }
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
     * Checks whether or not the item is available in the scene's inventory to open it.
     */
    public boolean itemExists(){
        if (this.currentPlayer.getPlayerCurrentScene().getSceneInventory().itemExists(this.currentItem)){
            return true;
        }
        else {
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
    
     /**
     * Checks if the item is open.
     * @return Whether the item is stated as opened.
     */
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }
    
    /**
     * Checks if the item is locked.
     * @return Whether the item is stated as locked
     */
    public boolean isItemLocked(){
        return this.currentItem.isItemLocked();
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command OPEN takes one parameter. Try: [OPEN parameter]";
    }
}