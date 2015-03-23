/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenes;

public class SceneExit {
    private String direction;
    private Scene destinationScene;

    public SceneExit() {
        initialize();
    }

    /**
     * Initializes the attributes of a new SceneExit object.
     */
    private void initialize() {
        direction = "Default direction.";
        destinationScene = new Scene("Default Scene Description.");
    }

    /**
     * Constructor with arguments for SceneExit objects.
     * @param newDirection direction to which you can change scene (e.g. west)
     * @param newDestinationScene Scene of the direction of the exit (e.g. 2)
     */
    public SceneExit(String newDirection, Scene newDestinationScene) {
        this.direction = newDirection;
        this.destinationScene = newDestinationScene;
    }

    public String getDirection() {
        return direction;
    }

    public Scene getDestinationScene() {
        return destinationScene;
    }
}
