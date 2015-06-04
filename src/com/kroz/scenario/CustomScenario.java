/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenario;

import com.kroz.map.Map;
import com.kroz.scene.Scene;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eleni
 */
public class CustomScenario implements IScenario {
    private List<Scene> customScenarioSceneList;
    private Map customScenarioMap;
    private Boolean scenarioComplete;

    public CustomScenario() {
        this.initialize();
        this.setScenarioSceneList();
        this.setScenarioMap();
        this.scenarioComplete = false;
    }
    
    private void initialize() {
        this.customScenarioMap = new Map();
        this.customScenarioSceneList = new ArrayList<Scene>();
        this.scenarioComplete = false;
    }

    public List<Scene> getCustomScenarioSceneList() {
        return this.customScenarioSceneList;
    }

    public void setCustomScenarioSceneList(List<Scene> customScenarioSceneList) {
        this.customScenarioSceneList = customScenarioSceneList;
    }

    public Map getCustomScenarioMap() {
        return this.customScenarioMap;
    }

    public void setCustomScenarioMap(Map customScenarioMap) {
        this.customScenarioMap = customScenarioMap;
    }

    public Boolean getScenarioComplete() {
        return this.scenarioComplete;
    }

    public void setScenarioComplete(Boolean scenarioComplete) {
        this.scenarioComplete = scenarioComplete;
    }
    
    /**
     * Checks whether or not the player has completed his/her adventure.
     * @return Whether the scenario is completed.
     */
    @Override
    public boolean isScenarioComplete() {
        return this.scenarioComplete;
    }

    @Override
    public void setScenarioSceneList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setScenarioMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getScenarioMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Scene> getScenarioSceneList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
