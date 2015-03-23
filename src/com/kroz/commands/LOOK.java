/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;

/**
 * Look command displays the description of the current scene.
 * @author Eleni Aidonidou
 */
public class LOOK implements ICommand {
    private Player currentPlayer;
    /**
     * Constructor of LOOK command with parameters.
     * @param newCurrentPlayer Current Player.
     */
    public LOOK(Player newCurrentPlayer) {
        this.currentPlayer = newCurrentPlayer;
    }

    @Override
    public void executeCommand() {
        System.out.println("\n" + currentPlayer.getPlayerCurrentScene().getSceneDescription());
    }
}