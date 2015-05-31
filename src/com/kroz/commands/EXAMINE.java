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
public class EXAMINE implements ICommand{

    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
    
    
    public EXAMINE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
    }
    
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                System.out.println(this.currentItem.getItemDescription());
            }
            else {
                System.out.println(this.currentItem.getItemName() + " doesn't exist");
            }
        }
        else {
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
        return false;
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command EXAMINE takes one parameter. Try: [EXAMINE parameter]";
    }
    
}