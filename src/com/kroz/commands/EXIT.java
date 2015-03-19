/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.scenes.Scene;

/**
 * Command EXIT closes the game.
 * @author Eleni Aidonidou
 */
public class EXIT implements ICommand {

    @Override
    public Scene executeCommand(Scene currentScene, Player currentPlayer) {
        System.exit(0);
        return currentScene;
    }

}
