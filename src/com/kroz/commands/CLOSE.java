/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Item;
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
    private Item currentItem;
    private static List<Item> closeableItems = new ArrayList<>();

    public CLOSE(){
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
                if (this.isItemCloseable()){
                    if (this.isItemOpen()) {
                        this.currentItem.changeItemState();
                        System.out.println(this.currentItem.getItemName() + " closed");
                    }
                    else {
                        System.out.println(this.currentItem.getItemName() + " is already closed");
                    }
                }
                else {
                    System.out.println("You can't do that.");
                }
            }
            else {
                System.out.println(this.currentCommandTextList.toString().toUpperCase() + " doesn't exist");
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
        this.currentItem = item;
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

    @Override
    public String getInvalidInputMessage() {
        return "Command CLOSE takes one parameter. Try: [CLOSE parameter]";
    }
    
    public static void addCloseableItem(Item newItem){
        closeableItems.add(newItem);
    }
    
    public boolean isItemCloseable(){
        return closeableItems.contains(this.currentItem);
    }
}
