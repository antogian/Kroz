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
import com.kroz.scene.templates.Basement;
import com.kroz.scene.templates.Clearing;
import com.kroz.scene.templates.Forest;
import com.kroz.scene.templates.Garden;
import com.kroz.scene.templates.Kitchen;
import com.kroz.scene.templates.Room;


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
                new SceneExit(Direction.W, this.getScenarioSceneList().get(3), ItemState.DISABLED, ItemState.DISABLED));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3),
                new SceneExit(Direction.E, this.getScenarioSceneList().get(2)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(1),
                new SceneExit(Direction.W, this.getScenarioSceneList().get(4)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(3),
                new SceneExit(Direction.S, this.getScenarioSceneList().get(4), ItemState.DISABLED, ItemState.ENABLED));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(4),
                new SceneExit(Direction.N, this.getScenarioSceneList().get(3)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(4),
                new SceneExit(Direction.E, this.getScenarioSceneList().get(1)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(4),
                new SceneExit(Direction.S, this.getScenarioSceneList().get(5)));
        this.defaultScenarioMap.addExitToScene(this.getScenarioSceneList().get(5),
                new SceneExit(Direction.N, this.getScenarioSceneList().get(4)));
    }
    /**
     *Setting of the default scenario scenes.
     */
    @Override
    public final void setScenarioSceneList() {
        this.defaultScenarioSceneList.add(new Forest());
        this.defaultScenarioSceneList.add(new Kitchen());
        this.defaultScenarioSceneList.add(new Clearing());
        this.defaultScenarioSceneList.add(new Garden());
        this.defaultScenarioSceneList.add(new Room());
        this.defaultScenarioSceneList.add(new Basement());
    }

    public void setScenarioComplete(Boolean scenarioComplete) {
        this.scenarioComplete = scenarioComplete;
    }
}