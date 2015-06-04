/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenario;

import com.kroz.map.Map;
import com.kroz.scene.Scene;
import java.util.List;

public interface IScenario {
    boolean isScenarioComplete();
    void setScenarioSceneList();
    void setScenarioMap();
    Map getScenarioMap();
    List<Scene> getScenarioSceneList();
    void setScenarioComplete(Boolean scenarioComplete);
}
