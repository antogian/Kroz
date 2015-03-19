/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenes;

public class SceneExit {
    private String direction;
    private Integer destinationSceneId;

    public SceneExit() {
        initialize();
    }

    /**
     * Initializes the attributes of a new SceneExit object.
     */
    private void initialize() {
        direction = "default destination";
        destinationSceneId = -1;
    }

    /**
     * Constructor with arguments for SceneExit objects.
     * @param newDirection direction to which you can change scene (e.g. west)
     * @param newDestinationSceneId SceneID of the scene following the exit (e.g. 2)
     */
    public SceneExit(String newDirection, Integer newDestinationSceneId) {
        this.direction = newDirection;
        this.destinationSceneId = newDestinationSceneId;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getDestinationSceneId() {
        return destinationSceneId;
    }
}
