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
    private List<String> currentCommandTextList;

    public EXIT() {
        initialize();
    }

    void initialize() {
        currentCommandTextList = new ArrayList<String>();
    }
    @Override
    public void executeCommand() {
        System.exit(0);
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        
    }

    @Override
    public void setCommandTextList(List<String> rawCommandText) {
        this.currentCommandTextList = rawCommandText;
    }

    @Override
    public boolean isValid() {
        if (!this.currentCommandTextList.isEmpty()) {
           System.out.println("Command EXIT doesnt get any parameters. Try: [EXIT]");
           return false;
        } else {
            return true;
        }
    }
}
