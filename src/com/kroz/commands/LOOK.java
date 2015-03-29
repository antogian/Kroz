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
 * Look command displays the description of the current scene.
 * @author Eleni Aidonidou
 */
public class LOOK implements ICommand {
    private Player currentPlayer;
    private List<String> currentCommandTextList;
    /**
     * Constructor of LOOK command without parameters.
     */
    public LOOK() {
        initialize();
    }
    private void initialize() {
        currentPlayer = new Player();
        currentCommandTextList = new ArrayList<String>();
    }
    @Override
    public void executeCommand() {
        isValid();
        System.out.println("\n" + currentPlayer.getPlayerCurrentScene().getSceneDescription());
        this.currentPlayer.getPlayerCurrentScene().showSceneInventory();
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
    public void isValid() {
        if (!this.currentCommandTextList.isEmpty()) {
            System.out.println("Command LOOK doesn't get any parameters. Try: [LOOK]");
            throw new IllegalArgumentException();
        }
    }
}