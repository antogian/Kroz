/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.items.Item;
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
    private static List<Item> takeableItems = new ArrayList<>();
   
    public TAKE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
    }
    
    @Override
    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }
    
    public void setCurrentItem(Item currentItem){
        this.currentItem = currentItem;
    }
    
    @Override
    public void setCommandTextList(List<String> rawCommandText){
        this.currentCommandTextList = rawCommandText;
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
        return false;
    }
    
    public boolean isPlayerObject(){
        return this.currentItem.getItemType().getValue().equalsIgnoreCase("PO");
    }
    
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()){
                if(this.isItemTakeable()){
                    if (this.isPlayerObject()){
                        this.removeItemFromScene();
                        this.addItemToPlayer();
                        System.out.println(this.currentItem.getItemName() + " added to INVENTORY");
                    }
                    else {
                        System.out.println("You can't do that.");
                    }
                }
            }
            else {
                System.out.println(this.currentItem.getItemName() + " doesn't exist");
            }
        }
        else {
            this.getInvalidInputMessage();
        }
    }
     
    public void removeItemFromScene(){
        this.currentPlayer.getPlayerCurrentScene().getSceneInventory().removeItemFromInventory(this.currentItem);
    }
    
    public void addItemToPlayer(){
        this.currentPlayer.getPlayerInventory().addItemInInventory(this.currentItem);
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command TAKE takes one parameter. Try: [TAKE parameter]";
    }
    
    public static void addTakeableItem(Item newItem){
        takeableItems.add(newItem);
    }
    
    public boolean isItemTakeable(){
        return takeableItems.contains(this.currentItem);
    }
}