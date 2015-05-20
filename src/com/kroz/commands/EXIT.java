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

    void initialize() {
        currentCommandTextList = new ArrayList<String>();
    }
    @Override
    public void executeCommand() {
        isValid();
        System.exit(0);
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
        return "Command EXIT doesnt get any parameters. Try: [EXIT]";
    }
}
