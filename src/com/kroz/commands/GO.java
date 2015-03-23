/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.map.Map;
import com.kroz.player.Player;
import com.kroz.scenario.IScenario;
import com.kroz.scenes.Scene;
import com.kroz.scenes.SceneExit;

/**
 *
 * @author Eleni Aidonidou
 */
public class GO implements ICommand {
    /**
     * The current scenario.
     */
    private final IScenario currentScenario;
    /**
     * The current Player in the game.
     */
    private Player currentPlayer;
    /**
     * The map of the current Scenario.
     */
    private final Map map;
    /**
     * The direction where the player wants to go to.
     */
    private final String toDirection;
    /**
     * Constructor of class Go with parameters.
     * @param player The player that asked to execute the command GO.
     * @param scenario The scenario the player is playing in.
     * @param direction The direction the player wants to move to.
     */
    public GO(Player player, final IScenario scenario, final String direction) {
        this.currentScenario = scenario;
        this.toDirection = direction;
        this.currentPlayer = player;
        this.map = scenario.getScenarioMap();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Checks if the direction is available in the current scene.
     * @param currentScene The current scene the player is in.
     * @return True if the direction is available. False if it isn't.
     */
    public boolean isDirectionValid(Scene currentScene) {
        return map.canGoThere(currentScene, toDirection);
    }
    
    @Override
    public void executeCommand() {
        if (this.isDirectionValid(this.currentPlayer.getPlayerCurrentScene())) {
            try {
                SceneExit exitToGoTo = extractCurrentSceneExit(this.currentPlayer.getPlayerCurrentScene());
                this.currentPlayer.setPlayerCurrentScene(exitToGoTo.getDestinationScene());
            } catch (NoSuchFieldException e) {
                System.out.println("You can't go that way.");
            }
        } else {
            System.out.println("Direction doesn't exist");
        }
        System.out.println("\n" + this.currentPlayer.getPlayerCurrentScene().getSceneDescription());
    }
    /**
     * Extracts the Current Scenes Exit where the direction equals the direction given by the player.
     * @param currentScene The current scene the player is in.
     * @return The Scene Exit object that matches the direction given by the player.
     * @throws NoSuchFieldException Is thrown if the direction asked isn't available.
     */
    private SceneExit extractCurrentSceneExit(Scene currentScene) throws NoSuchFieldException {
        SceneExit exit = new SceneExit();
        for (SceneExit sceneExit : map.getMap().get(currentScene)) {
            if (sceneExit.getDirection().equalsIgnoreCase(toDirection)) {
                exit = sceneExit;
            }
        }
        if (exit.getDestinationScene().equals(new Scene())) {
            throw new NoSuchFieldException();
        }
        return exit;
    }
}
