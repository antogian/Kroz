/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.items.Item;
import com.kroz.items.LightableItem;
import com.kroz.items.Torch;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Look command displays the description of the current scene.
 * @author Eleni Aidonidou
 */
public class LOOK implements ICommand {
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    private LightableItem currentItem;
    /**
     * Constructor of LOOK command without parameters.
     */
    public LOOK() {
        initialize();
    }
    private void initialize() {
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
        this.currentItem = new Torch();
    }
    @Override
    public void executeCommand() {
        if (this.isValid()){
            if (this.hasSceneLighting() || this.isLightableItemOn()){
                System.out.println("\n" + currentPlayer.getPlayerCurrentScene().getSceneDescription());
                this.currentPlayer.getPlayerCurrentScene().showSceneInventory();
            }
            else {
                System.out.println("It's too dark, you can't see anything.");
            }
        }
        else {
            this.getInvalidInputMessage();
        }
    }

    @Override
    public void setCurrentPlayer(Player newCurrentPlayer) {
        this.currentPlayer = newCurrentPlayer;
    }

    @Override
    public void setCommandTextList(List<String> newRawCommandText) {
        this.currentCommandTextList = newRawCommandText;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = (LightableItem)currentItem;
    }

    @Override
    public boolean isValid() {
        return this.currentCommandTextList.isEmpty();
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command LOOK doesn't get any parameters. Try: [LOOK]";
    }
    
    public boolean hasSceneLighting(){
        return this.currentPlayer.getPlayerCurrentScene().hasLighting();
    }
    
    public boolean isLightableItemOn(){
        if (this.currentPlayer.getPlayerInventory().itemExists(this.currentItem)){
            this.setCurrentItem(this.currentPlayer.getPlayerInventory().getItemFromInventory(this.currentItem));
            return this.currentItem.getItemState().getValue().equalsIgnoreCase("ON");
        }
        else {
            return false;
        }
    }
}