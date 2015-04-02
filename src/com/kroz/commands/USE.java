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
public class USE implements ICommand{
    
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
    
    
    public USE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
    }
    
    @Override
    public void executeCommand(){
        this.isValid();
        if (this.itemExists()) {
                this.currentItem.changeItemState();
        }
        else {
            System.out.println(this.currentItem.getItemName() + " doesn't exist");
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
    public void isValid(){
        if (this.currentCommandTextList.size() != 1) {
           System.out.println("Command USE takes one parameter. Try: [USE parameter]");
           throw new IllegalArgumentException();
        }
    }
    
    public boolean itemExists(){
        for(Item tempItem : this.currentPlayer.getPlayerInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                setCurrentItem(tempItem);
                return true;
            }
        }
        return false;
    }
}