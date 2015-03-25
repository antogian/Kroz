/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.map.Map;
import com.kroz.player.Player;
import com.kroz.scenes.Scene;
import com.kroz.scenes.SceneExit;
import java.util.ArrayList;
import java.util.List;
import com.kroz.enums.Direction;
/**
 *
 * @author Eleni Aidonidou
 */
public class GO implements ICommand {
    /**
     * The current Player in the game.
     */
    private Player currentPlayer;
    /**
     * The map of the current Scenario.
     */
    private Map map;
    /**
     * The direction where the player wants to go to.
     */
    private Direction toDirection;
    private List<String> currentCommandTextList;

    public GO() {
        initialize();
    }
    private void initialize() {
        this.toDirection = Direction.DEFAULT;
        this.currentPlayer = new Player();
        this.map = currentPlayer.getCurrentScenario().getScenarioMap();
        currentCommandTextList = new ArrayList<String>();
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
            if (sceneExit.getDirection().getValue().equalsIgnoreCase(this.toDirection.getValue())) {
                exit = sceneExit;
            }
        }
        if (exit.getDestinationScene().equals(new Scene())) {
            throw new NoSuchFieldException();
        }
        return exit;
    }

    @Override
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void setCommandTextList(List<String> rawCommandText) {
        this.currentCommandTextList = rawCommandText;
    }

    @Override
    public boolean isValid() {
        if (this.currentCommandTextList.size() != 1) {
           System.out.println("Command GO takes one parameter. Try: [GO parameter]");
           return false;
        } else {
            return true;
        }
    }
}
