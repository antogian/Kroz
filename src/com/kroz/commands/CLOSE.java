/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.OpenableItem;
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
    private OpenableItem currentItem;

    public CLOSE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<>();
        this.currentItem = new OpenableItem();
    }

    @Override
    public void executeCommand(){
        if(this.isValid()){
            if (this.itemExists()) {
                if (this.isItemOpen()) {
                    this.currentItem.changeItemState();
                    System.out.println(this.currentItem.getItemName() + " closed");
                }
                else {
                    System.out.println(this.currentItem.getItemName() + " is already closed");
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
    
    public void setCurrentItem(OpenableItem newItem){
        this.currentItem = newItem;
    }
    
    @Override
    public boolean isValid(){
        return this.currentCommandTextList.size() == 1;
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
    
    public boolean isItemOpen(){
        return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command CLOSE takes one parameter. Try: [CLOSE parameter]";
    }
}
