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
    
    /**
     * Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it shows the
     * player's inventory, the full list of the items contained and if
     * it is empty it prints a corresponding message.
     */
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

    /**
     * Implements the setCurrentPlayer method of the ICommand interface.
     * @param newCurrentPlayer Player who's interacting.
     */
    @Override
    public void setCurrentPlayer(Player newCurrentPlayer) {
        this.currentPlayer = newCurrentPlayer;
    }

    /**
     * Implements the setCommandTextList method of the ICommand interface.
     * @param newRawCommandText The actual input taken from the user through console.
     */
    @Override
    public void setCommandTextList(List<String> newRawCommandText) {
        this.currentCommandTextList = newRawCommandText;
    }

    /**
     * Verifies whether or not the command given is correct.
     */
    @Override
    public boolean isValid() {
        return this.currentCommandTextList.isEmpty();
    }

    /**
     * Implements the getInvalidInputMessage method of the ICommand interface.
     * Prints corresponding message when the player's input is invalid. 
     */
    @Override
    public String getInvalidInputMessage() {
        return "Command INVENTORY doesn't get any parameters. Try: [INVENTORY]";
    }
    
}
