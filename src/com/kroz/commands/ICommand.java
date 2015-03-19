/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.scenes.Scene;

/**
 * The interface that all commands implement.
 * @author Eleni Aidonidou
 */
public interface ICommand {
    /**
     * Executes the ICommand object that was created.
     * @param currentScene The scene the player is in at the moment.
     * @param currentPlayer The player.
     * @return The Scene where the player must
     * stay or move to, depending on the command.
     */
    Scene executeCommand(Scene currentScene, Player currentPlayer);
}
