/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.scenes.Scene;

/**
 * Look command displays the description of the current scene.
 * @author Eleni Aidonidou
 */
public class LOOK implements ICommand {
    /**
     * Empty Constructor.
     */
    public LOOK() {
    }

    @Override
    public Scene executeCommand(Scene currentScene, Player currentPlayer) {
        System.out.println("\n" + currentScene.getSceneDescription());
        return currentScene;
    }
}
