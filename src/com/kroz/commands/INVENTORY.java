/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 *
 * @author Eleni
 */
public class INVENTORY implements ICommand{
    private Player currentPlayer;
    private List<String> currentCommandTextList;

    public INVENTORY() {
        initialize();
    }
    private void initialize() {
        currentPlayer = new Player();
        currentCommandTextList = new ArrayList<String>();
    }
    @Override
    public void executeCommand() {
        if (this.isValid()){
            try {
                this.currentPlayer.getPlayerInventory().showInventory();
            } catch (EmptyStackException e) {
                System.out.println("You have no items.");
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

    @Override
    public boolean isValid() {
        return this.currentCommandTextList.isEmpty();
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command INVENTORY doesn't get any parameters. Try: [INVENTORY]";
    }
    
}
