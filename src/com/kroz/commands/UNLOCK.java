/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;


import com.kroz.items.Key;
import com.kroz.items.OpenableItem;
import com.kroz.player.Player;
import com.kroz.scene.SceneExit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class UNLOCK implements ICommand{
    
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private OpenableItem currentItem;
    private Key currentKey;
    
    public UNLOCK(){
        this.initialize();
    }
    
    private void initialize(){
        this.currentCommandTextList = new ArrayList<>();
        this.currentKey = new Key();
        this.currentPlayer = new Player();
        this.currentItem = new OpenableItem();
    }
    
    /**Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it checks whether
     * or not there is the unlockable item available and if it does it checks
     * if the player has the key to unlock it or not. If it is already open or
     * closed the method informs the player about it.
     */
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                if (this.keyExists()){
                    if (this.isItemOpen()){
                        System.out.println(this.currentItem.getItemName() + " is open. You must close it first.");
                    }
                    else {
                        if (this.isItemUnlocked()){
                            System.out.println(this.currentItem.getItemName() + " is already unlocked.");
                        }
                        else {
                            this.currentKey.setCurrentItem(this.currentItem);
                            this.currentKey.unlockItem();
                            System.out.println(this.currentItem.getItemName() + " unlocked.");
                        }
                    }
                }
                else {
                    System.out.println("You don't have the key.");
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
     * Checks whether or not the item is available in the scene's inventory to unlock it.
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
    
    /**
     * Checks if the item is unlocked.
     * @return Whether the item is stated as unlocked
     */
    public boolean isItemUnlocked(){
        return !this.currentItem.isItemLocked();
    }
    
    /**
     * Checks if the item is open.
     * @return Whether the item is stated as opened.
     */
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }
    
    /**
     * Checks if the player has the key.
     * @return Whether or not the player has the key.
     */
    public boolean keyExists(){
        return this.currentPlayer.getPlayerInventory().itemExists(this.currentKey);
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
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage(){
        return "Command UNLOCK takes one parameter. Try: [UNLOCK parameter]";
    }
    
    public void setCurrentItem(OpenableItem newItem){
        this.currentItem = newItem;
    }
    
    public void setCurrentKey(Key newKey){
        this.currentKey = newKey;
    }
}
