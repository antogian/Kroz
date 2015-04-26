/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scene;


import com.kroz.enums.Direction;
import com.kroz.enums.ItemState;
import com.kroz.items.Door;

public class SceneExit {
    private Direction direction;
    private Scene destinationScene;
    private Door sceneDoor;

    public SceneExit() {
        initialize();
    }

    /**
     * Initializes the attributes of a new SceneExit object.
     */
    private void initialize() {
        this.direction = Direction.DEFAULT;
        this.destinationScene = new Scene("Default Scene Description.");
        this.sceneDoor = new Door();
    }

    /**
     * Constructor with arguments for SceneExit objects.
     * @param newDirection direction to which you can change scene (e.g. west)
     * @param newDestinationScene Scene of the direction of the exit (e.g. 2)
     */
    public SceneExit(Direction newDirection, Scene newDestinationScene) {
        this.direction = newDirection;
        this.destinationScene = newDestinationScene;
        this.sceneDoor = new Door();
    }
    
    public SceneExit(Direction newDirection, Scene newDestinationScene, ItemState itemState) {
        this.direction = newDirection;
        this.destinationScene = newDestinationScene;
        this.sceneDoor = new Door();
        this.sceneDoor.setItemState(itemState);
        //this.destinationScene.getSceneInventory().addItemInInventory(sceneDoor);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Scene getDestinationScene() {
        return destinationScene;
    }
    
    public Door getSceneDoor(){
        return this.sceneDoor;
    }
}
