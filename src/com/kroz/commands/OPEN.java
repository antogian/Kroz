/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Door;
import com.kroz.items.Item;
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
    private Door currentItem;
    private static List<Item> openableItems = new ArrayList<>();
    
    
    public OPEN(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
    }
    
    @Override
    public void executeCommand(){
        if(this.isValid()){
            if (this.itemExists()) {
                if (this.isItemOpenable()){
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
                    System.out.println("You can't do that.");
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
    
    @Override
    public void setCurrentPlayer(Player newCurrentPlayer){
        this.currentPlayer = newCurrentPlayer;
    }
    
    @Override
    public void setCommandTextList(List<String> newRawCommandText){
        this.currentCommandTextList = newRawCommandText;
    }
    
    public void setCurrentItem(Item item){
        this.currentItem = (Door)item;
    }
    
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
    public boolean itemExists(){
        for(Item tempItem : this.currentPlayer.getPlayerCurrentScene().getSceneInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                setCurrentItem(tempItem);
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
    
    public boolean isItemLocked(){
        return this.currentItem.isItemLocked();
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command OPEN takes one parameter. Try: [OPEN parameter]";
    }
    
    public static void addOpenableItem(Item newItem){
        openableItems.add(newItem);
    }
    
    public boolean isItemOpenable(){
        return openableItems.contains(this.currentItem);
    }
}