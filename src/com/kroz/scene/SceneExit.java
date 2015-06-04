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

    private void initialize() {
        this.direction = Direction.DEFAULT;
        this.destinationScene = new Scene("Default Scene Description.");
        this.sceneDoor = new Door();
    }

    public SceneExit(Direction newDirection, Scene newDestinationScene) {
        this.direction = newDirection;
        this.destinationScene = newDestinationScene;
        this.sceneDoor = new Door();
    }
    
    public SceneExit(Direction newDirection, Scene newDestinationScene, ItemState doorState) {
        this.direction = newDirection;
        this.destinationScene = newDestinationScene;
        this.sceneDoor = new Door();
        this.sceneDoor.setItemState(doorState);
        this.sceneDoor.setLockState(ItemState.DEFAULT);
    }
    
    public SceneExit(Direction newDirection, Scene newDestinationScene, ItemState doorState, ItemState lockState) {
        this.direction = newDirection;
        this.destinationScene = newDestinationScene;
        this.sceneDoor = new Door();
        this.sceneDoor.setItemState(doorState);
        this.sceneDoor.setLockState(lockState);
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
