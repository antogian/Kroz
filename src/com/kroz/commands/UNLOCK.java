/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Door;
import com.kroz.items.Item;
import com.kroz.items.Key;
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
    private Door currentItem;
    private Key currentKey;
    private static List<Item> unlockableItems = new ArrayList<>();
    
    
    public UNLOCK(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentCommandTextList = new ArrayList<>();
        this.currentKey = new Key();
        this.currentPlayer = new Player();
    }
    
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                if (this.keyExists()){
                    if (this.isItemUnlockable()){
                        if (this.isItemOpen()){
                            System.out.println(this.currentItem.getItemName() + " is already open.");                       
                        }
                        else {
                            this.currentKey.setCurrentItem(this.currentItem);
                            this.currentKey.unlockItem();
                            System.out.println(this.currentItem.getItemName() + " unlocked.");
                        }
                    }
                    else {
                        System.out.println("You can't do that.");
                    }
                }
                else {
                    System.out.println("You don't have the key.");
                }
            }
            else {
                System.out.println(this.currentCommandTextList + " doesn't exit.");
            }
        }
        else {
            this.getInvalidInputMessage();
        }
    }
    
    public boolean itemExists(){
        for(Item tempItem : this.currentPlayer.getPlayerCurrentScene().getSceneInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                setCurrentItem((Door)tempItem);
                return true;
            }
        }
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
    
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }
    
    public boolean keyExists(){
        for(Item tempItem : this.currentPlayer.getPlayerInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentKey.getItemName())){
                this.setCurrentKey((Key)tempItem);
                return true;
            }
        }
        return false;
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
    
    @Override
    public String getInvalidInputMessage(){
        return "Command UNLOCK takes one parameter. Try: [UNLOCK parameter]";
    }
    
    public void setCurrentItem(Door newCurrentitem){
        this.currentItem = newCurrentitem;
    }
    
    public void setCurrentKey(Key newKey){
        this.currentKey = newKey;
    }
    
    public static void addUnlockableItem(Door newItem){
        unlockableItems.add(newItem);
    }
    
    public boolean isItemUnlockable(){
        return unlockableItems.contains(this.currentItem);
    }
}
