/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenario;

import com.kroz.map.Map;
import com.kroz.scenes.Scene;
import com.kroz.scenes.SceneExit;
import java.util.ArrayList;
import java.util.List;


public class DefaultScenario implements IScenario {
    private List<Scene> defaultScenarioSceneList;
    private Map defaultScenarioMap;

    public DefaultScenario() {
        initialize();
        this.setScenarioSceneList();
        this.setScenarioMap();
    }
/**
 * Initializes the attributes of a new Scenario object.
 */
    private void initialize() {
        defaultScenarioMap = new Map();
        defaultScenarioSceneList = new ArrayList<Scene>();
    }

    @Override
    public Map getScenarioMap() {
        return defaultScenarioMap;
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
        return false;
    //TODO right code that defines when the scenario is complete.
    }

    /**
     * Setting of the default scenario map.
     */
    @Override
    public final void setScenarioMap() {
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(0), new SceneExit("west", 2));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(2), new SceneExit("east", 0));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(2), new SceneExit("south", 3));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3), new SceneExit("east", 1));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3), new SceneExit("south", 4));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3), new SceneExit("north", 2));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(1), new SceneExit("west", 3));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(4), new SceneExit("north", 3));
    }
    /**
     *Setting of the default scenario scenes.
     */
    @Override
    public final void setScenarioSceneList() {
        Scene newScene;
        newScene = new Scene("You are in a forest. West there is a garden.");
        this.defaultScenarioSceneList.add(newScene);
        newScene = new Scene("You are in a kitchen. West there is a door leading to a room.");
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
}
