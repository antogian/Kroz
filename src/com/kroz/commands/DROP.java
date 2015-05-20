/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Item;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class DROP implements ICommand{
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
   
    public DROP(){
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
        for(Item tempItem : this.currentPlayer.getPlayerInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                this.setCurrentItem(tempItem);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void executeCommand(){
        this.isValid();
        if (this.itemExists()){
            this.getItemFromPlayer();
            this.addItemToScene();
            System.out.println(this.currentItem.getItemName() + " removed from INVENTORY");
        }
        else{
            System.out.println(this.currentItem.getItemName() + " doesn't exist");
        }
    }
     
    public void getItemFromPlayer(){
        this.currentPlayer.getPlayerInventory().removeItemFromInventory(this.currentItem);
    }
    
    public void addItemToScene(){
        this.currentPlayer.getPlayerCurrentScene().getSceneInventory().addItemInInventory(this.currentItem);
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command DROP takes one parameter. Try: [DROP parameter]";
    }
}
