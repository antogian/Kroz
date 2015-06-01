/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.enums.ItemState;
import com.kroz.items.Item;
import com.kroz.items.Torch;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class LIGHT implements ICommand{

    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Torch currentItem;
    private static List<Item> lightableItems = new ArrayList<>();
    
    
    public LIGHT(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new Torch();
    }
    
    @Override
    public void executeCommand(){
        if (this.isValid()){
            if (this.itemExists()) {
                if (this.isTorchOn()){
                    System.out.println(this.currentItem.getItemName().toUpperCase() + " is already turned on.");
                }
                else {
                    this.currentItem.useItem(this.currentPlayer.getPlayerCurrentScene());
                    this.currentItem.setItemState(ItemState.ENABLED);
                    System.out.println(this.currentItem.getItemName().toUpperCase() + " lightened. Now you can see everything.");
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
    
    @Override
    public void setCurrentPlayer(Player newCurrentPlayer){
        this.currentPlayer = newCurrentPlayer;
    }
    
    @Override
    public void setCommandTextList(List<String> newRawCommandText){
        this.currentCommandTextList = newRawCommandText;
    }
    
    public void setCurrentItem(Item item){
        this.currentItem = (Torch) item;
    }
    
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
    }
    
    public boolean itemExists(){
        return this.currentPlayer.getPlayerInventory().itemExists(this.currentItem);
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command EXAMINE takes one parameter. Try: [EXAMINE parameter]";
    }
    
    public boolean isTorchOn(){
        if (this.itemExists()){
            this.setCurrentItem(this.currentPlayer.getPlayerInventory().getItemFromInventory(this.currentItem));
            if (this.currentItem.getItemState().getValue().equals("ON")){
                return true;
            }
            return false;
        }
        else {
            return false;
        }
    }
    
    public boolean isItemLightable(){
        return lightableItems.contains(this.currentItem);
    }
    
    public static void addLightableItems(Item newItem){
        lightableItems.add(newItem);
    }
    
}