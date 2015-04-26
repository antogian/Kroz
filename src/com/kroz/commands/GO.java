/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.map.Map;
import com.kroz.player.Player;
import com.kroz.scene.Scene;
import com.kroz.scene.SceneExit;
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
     * The currentMap of the current Scenario.
     */
    private Map currentMap;
    /**
     * The direction where the player wants to go to.
     */
    private Direction directionToGoTo;
    private List<String> currentCommandTextList;

    public GO() {
        initialize();
    }
    private void initialize() {
        this.directionToGoTo = Direction.DEFAULT;
        this.currentPlayer = new Player();
        this.currentMap = new Map();
        this.currentCommandTextList = new ArrayList<String>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Checks if the direction is available in the current scene.
     * @param newCurrentScene The current scene the player is in.
     * @return True if the direction is available. False if it isn't.
     */
    public boolean isDirectionValid(Scene newCurrentScene) {
        return currentMap.canGoThere(newCurrentScene, directionToGoTo);
    }

    @Override
    public void executeCommand() {
        //TODO call extractDirection
        isValid(); //throws exception if the command is not valid.
        setToDirection();
        if (this.isDirectionValid(this.currentPlayer.getPlayerCurrentScene())) {
            try {
                SceneExit exitToGoTo = extractCurrentSceneExit(this.currentPlayer.getPlayerCurrentScene());
                if (!this.isExitClear(exitToGoTo)){
                    System.out.println("You must open the door!");
                    return;
                }
                else{
                    this.currentPlayer.setPlayerCurrentScene(exitToGoTo.getDestinationScene());
                }
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
        for (SceneExit sceneExit : currentMap.getMap().get(currentScene)) {
            if (sceneExit.getDirection().getValue().equalsIgnoreCase(this.directionToGoTo.getValue())) {
                exit = sceneExit;
            }
        }
        if (exit.getDestinationScene().equals(new Scene())) {
            throw new NoSuchFieldException();
        }
        return exit;
    }

    @Override
    public void setCurrentPlayer(Player newCurrentPlayer) {
        this.currentPlayer = newCurrentPlayer;
        this.currentMap = newCurrentPlayer.getPlayerCurrentScenario().getScenarioMap();
    }

    @Override
    public void setCommandTextList(List<String> newRawCommandText) {
        this.currentCommandTextList = newRawCommandText;
    }

    @Override
    public void isValid() {
        if (this.currentCommandTextList.size() != 1) {
           System.out.println("Command GO takes one parameter. Try: [GO parameter]");
           throw new IllegalArgumentException();
        }
    }
    
    public boolean isExitClear(SceneExit exit){
        boolean exitClear = true;
        if(exit.getSceneDoor().getItemState().getValue().equals("OFF")){
            exitClear = false;
        }
        return exitClear;
    }

    public Direction getDirectionToGoTo() {
        return directionToGoTo;
    }

    public void setToDirection() {
        this.directionToGoTo = Direction.extractDirection(this.currentCommandTextList.get(0));
    }
}
