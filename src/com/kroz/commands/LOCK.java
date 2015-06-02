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
public class LOCK implements ICommand{
    
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private OpenableItem currentItem;
    private Key currentKey;    
    
    public LOCK(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentCommandTextList = new ArrayList<>();
        this.currentKey = new Key();
        this.currentPlayer = new Player();
        this.currentItem = new OpenableItem();
    }
    
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                if (this.keyExists()){
                    if (this.isItemOpen()){
                        System.out.println(this.currentItem.getItemName() + " is open. You must close it first.");                       
                    }
                    else {
                        if (this.isItemLocked()){
                            System.out.println(this.currentItem.getItemName() + " is already locked.");
                        }
                        else {
                            this.currentKey.setCurrentItem(this.currentItem);
                            this.currentKey.lockItem();
                            System.out.println(this.currentItem.getItemName() + " locked.");
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
    
    public boolean isItemLocked(){
        return this.currentItem.isItemLocked();
    }
    
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }
    
    public boolean keyExists(){
        return this.currentPlayer.getPlayerInventory().itemExists(this.currentKey);
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
        return "Command LOCK takes one parameter. Try: [LOCK parameter]";
    }
    
    public void setCurrentItem(OpenableItem newItem){
        this.currentItem = newItem;
    }
    
    public void setCurrentKey(Key newKey){
        this.currentKey = newKey;
    }
}
