/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.items.Item;
import com.kroz.items.Torch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Tony
 */
public class TAKE implements ICommand{
    
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
    private Map<String, Class<? extends Item>> itemsMap;
   
    public TAKE(){
        this.initialize();
    }
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
        this.itemsMap = new HashMap<String, Class<? extends Item>>();
        this.itemsMap.put("Torch", Torch.class);
    }
    
    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }
    
    public void setCurrentItem(Item currentItem){
        this.currentItem = currentItem;
    }
    
    public void setCommandTextList(List<String> rawCommandText){
        this.currentCommandTextList = rawCommandText;
    }
    
    public String modifyCommandText(String str){
        str.toLowerCase();
        str = Character.toString(str.charAt(0)).toUpperCase() + str.substring(1);
        return str;
    }
    
    public void isValid(){
        if(this.currentCommandTextList.size() != 1){
            System.out.println("Command TAKE takes one parameter. Try: [TAKE parameter]");
            throw new IllegalArgumentException();
        }
    }
    
    
    public void createItem(){
        String str = this.modifyCommandText(this.currentCommandTextList.get(0));
        if (this.itemsMap.containsKey(str)){
            try{
                //this.currentItem = this.itemsMap.get(this.currentCommandTextList.get(0)).newInstance();
                this.currentItem = this.itemsMap.get(str).newInstance();
            }
            catch (IllegalAccessException e){
                e.getMessage();
            }
            catch (InstantiationException e) {
                e.getMessage();
            }
            catch (ExceptionInInitializerError e) {
                e.getMessage();
            }
            catch (SecurityException e) {
                e.getMessage();
            }
        }
    }
    
    public boolean itemExists(){
        
        for(Item tempItem : this.currentPlayer.getPlayerCurrentScene().getSceneInventory().getItemList()){
            if (tempItem.getItemName().equalsIgnoreCase(this.currentCommandTextList.get(0))){
                return true;
            }
        }
        return false;
    }
    
    public void executeCommand(){
        this.isValid();
        this.createItem();
        if (this.itemExists()){
            this.getItemFromScene();
            this.addItemToPlayer();
            System.out.println("Item taken");
        }
        else{
            System.out.println("Item doesn't exist");
        }
    }
     
    public void getItemFromScene(){
        this.currentPlayer.getPlayerCurrentScene().getSceneInventory().removeItemFromInventory(this.currentItem);
    }
    
    public void addItemToPlayer(){
        this.currentPlayer.getPlayerInventory().addItemInInventory(this.currentItem);
    }
}
