/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.map.Map;
import com.kroz.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eleni
 */
public class NEW implements ICommand {
    private Player currentPlayer;
    /**
     * The currentMap of the current Scenario.
     */
    private Map currentMap;
    private List<String> currentCommandTextList;

    public NEW() {
        initialize();
    }
    
    private void initialize() {
        this.currentPlayer = new Player();
        this.currentMap = new Map();
        this.currentCommandTextList = new ArrayList<String>();
        }
    @Override
    public void executeCommand() {
        isValid(); //throws exception if the command is not valid.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return this.currentCommandTextList.size() == 1;
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command NEW takes one parameter. Try: [NEW parameter]";
    }
}
