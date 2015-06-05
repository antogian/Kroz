/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Command EXIT closes the game.
 * @author Eleni Aidonidou
 */
public class EXIT implements ICommand {
    private Player currentPlayer;
    private List<String> currentCommandTextList;

    public EXIT() {
        initialize();
    }

    private void initialize() {
        currentCommandTextList = new ArrayList<String>();
    }
    
    /**
     * Implementation of the executeCommand of the ICommand interface.
     * As long as the command given by player is correct, it terminates the game.
     */
    @Override
    public void executeCommand() {
        if (this.isValid()){
            System.exit(0);            
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
        return "Command EXIT doesnt get any parameters. Try: [EXIT]";
    }
}
