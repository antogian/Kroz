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
public class OPEN implements ICommand{
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private Item currentItem;
    
    public OPEN(){
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
            if (this.isItemOpen()) {
                System.out.println(this.currentItem.getItemName() + " is already open");
            }
            else {
                this.currentItem.changeItemState();
                System.out.println(this.currentItem.getItemName() + " opened");
            }
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
        exitsList = this.currentPlayer.getPlayerCurrentScenario().getScenarioMap().sceneExits(this.currentPlayer.getPlayerCurrentScene());
        for(SceneExit tempSceneExit : exitsList){
            if (!tempSceneExit.getSceneDoor().getItemState().getValue().equals("DEFAULT")){
                setCurrentItem(tempSceneExit.getSceneDoor());
                return true;
            }
        }
        return false;
    }
    
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command OPEN takes one parameter. Try: [OPEN parameter]";
    }
    
}
