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
    public GO(final Player player, final IScenario scenario, final String direction) {
        this.currentScenario = scenario;
        this.toDirection = direction;
        this.map = scenario.getScenarioMap();
    }
    /**
     * Checks if the direction is available in the current scene.
     * @param currentScene The current scene the player is in.
     * @return True if the direction is available. False if it isn't.
     */
    public boolean isCommandValid(Scene currentScene) {
        return map.canGoThere(currentScene.getSceneId(), toDirection);
    }
    
    @Override
    public Scene executeCommand(Scene currentScene, Player currentPlayer) {
        Scene newScene;
        if (this.isCommandValid(currentScene)) {
            try {
                SceneExit exitToGoTo = extractCurrentSceneExit(currentScene);
                currentScene = setCurrentScene(exitToGoTo.getDestinationSceneId());
                currentPlayer.setPlayerCurrentSceneId(currentScene.getSceneId());
            } catch (NoSuchFieldException e) {
                System.out.println("You can't go that way.");
            }
        } else {
            System.out.println("Direction doesn't exist");
        }
        newScene = currentScene;
        System.out.println("\n" + currentScene.getSceneDescription());
        return newScene;
    }
    /**
     * Extracts the Current Scenes Exit where the direction equals the direction given by the player.
     * @param currentScene The current scene the player is in.
     * @return The Scene Exit object that matches the direction given by the player.
     * @throws NoSuchFieldException Is thrown if the direction asked isn't available.
     */
    private SceneExit extractCurrentSceneExit(Scene currentScene) throws NoSuchFieldException {
        SceneExit exit = new SceneExit();
        for (SceneExit sceneExit : map.getMap().get(currentScene.getSceneId())) {
            if (sceneExit.getDirection().equalsIgnoreCase(toDirection)) {
                exit = sceneExit;
            }
        }
        if (exit.getDestinationSceneId() == -1) {
            throw new NoSuchFieldException();
        }
        return exit;
    }
    /**
     * Changes the current scene with the destination scene.
     * @param sceneId The destination scenes id.
     * @return The destination scene object.
     */
    public Scene setCurrentScene(Integer sceneId) {
        Scene temp = new Scene();
        for (Scene scene : currentScenario.getScenarioSceneList()) {
            if (scene.getSceneId() == sceneId) {
                temp = scene;
            }
        }
        return temp;
    }
}
