/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenario;

import com.kroz.map.Map;
import com.kroz.scene.Scene;
import com.kroz.scene.SceneExit;
import java.util.ArrayList;
import java.util.List;
import com.kroz.enums.Direction;
import com.kroz.enums.ItemState;
import com.kroz.items.Door;
import com.kroz.items.Key;
import com.kroz.items.Torch;


public class DefaultScenario implements IScenario {
    private List<Scene> defaultScenarioSceneList;
    private Map defaultScenarioMap;
    private Boolean scenarioComplete;

    public DefaultScenario() {
        initialize();
        this.setScenarioSceneList();
        this.setScenarioMap();
        this.scenarioComplete = false;
    }
/**
 * Initializes the attributes of a new Scenario object.
 */
    private void initialize() {
        this.defaultScenarioMap = new Map();
        this.defaultScenarioSceneList = new ArrayList<Scene>();
        this.scenarioComplete = false;
    }

    @Override
    public Map getScenarioMap() {
        return this.defaultScenarioMap;
    }

    @Override
    public List<Scene> getScenarioSceneList() {
        return defaultScenarioSceneList;
    }
    /**
     * Checks if the scenario is completed.
     * @return false as long as scenario is in progress
     */
    @Override
    public boolean isScenarioComplete() {
        return this.scenarioComplete;
    }

    /**
     * Setting of the default scenario map.
     */
    @Override
    public final void setScenarioMap() {
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(0),
                new SceneExit(Direction.W, this.getScenarioSceneList().get(2)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(2),
                new SceneExit(Direction.E, this.getScenarioSceneList().get(0)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(2),
                new SceneExit(Direction.S, this.getScenarioSceneList().get(3), ItemState.ENABLED));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3),
                new SceneExit(Direction.E, this.getScenarioSceneList().get(1), ItemState.DISABLED));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3),
                new SceneExit(Direction.S, this.getScenarioSceneList().get(4), ItemState.DISABLED));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3),
                new SceneExit(Direction.N, this.getScenarioSceneList().get(2), ItemState.ENABLED));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(1),
                new SceneExit(Direction.W, this.getScenarioSceneList().get(3)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(4),
                new SceneExit(Direction.N, this.getScenarioSceneList().get(3), ItemState.ENABLED));
    }
    /**
     *Setting of the default scenario scenes.
     */
    @Override
    public final void setScenarioSceneList() {
        Scene newScene;
        newScene = new Scene("You are in a forest. West there is a garden.");
        newScene.getSceneInventory().addItemInInventory(new Door());
        newScene.getSceneInventory().addItemInInventory(new Torch());
        newScene.getSceneInventory().addItemInInventory(new Key());
        this.defaultScenarioSceneList.add(newScene);
        newScene = new Scene("You are in a kitchen. West there is a door leading to a room.");
        newScene.getSceneInventory().addItemInInventory(new Door());
        this.defaultScenarioSceneList.add(newScene);
        newScene = new Scene("You are in a garden. East there is a forest."
                + " South there is a house. The door is open.");
        this.defaultScenarioSceneList.add(newScene);
        newScene = new Scene("You are in a room. East there is a kitchen."
                + " South you can see a staircase leading to the basement."
                + " North is an open door leading to a garden.");
        this.defaultScenarioSceneList.add(newScene);
        newScene = new Scene("You are in a basement. North there is a staircase leading upwards.");
        this.defaultScenarioSceneList.add(newScene);
    }

    public void setScenarioComplete(Boolean scenarioComplete) {
        this.scenarioComplete = scenarioComplete;
    }

}
