/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenes;

import com.kroz.player.Player;
import com.kroz.scenario.IScenario;

public class Scene {
    private int sceneId;
    private String sceneDescription;

    public Scene() {
        initialize();
    }
    
    /**
     * Initializes the attributes of a new Scene object.
     */
    private void initialize() {
        sceneId = -1;
        sceneDescription = "Default Scene Description.";
    }

    /**
     * Constructor with arguments for Scene objects.
     * @param sceneId new Scene object's ID.
     * @param sceneDescription new Scene object's description.
     */
    public Scene(int sceneId, String sceneDescription) {
        this.sceneId = sceneId;
        this.sceneDescription = sceneDescription;
    }

    public int getSceneId() {
        return sceneId;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }
    
    /**
     * Extracts the scene in which Player is acting (i.e. where he is currently in).
     * @param player used to define where player is through playerCurrentSceneId attribute of Player class.
     * @param scenario used to define scenario's scene list through defaultScenarioSceneList attribute of DefaultScenario class.
     * @return the scene where the player currently is in.
     */
    public Scene extractCurrentScene(Player player, IScenario scenario) {
        Scene tempScene = new Scene();
        for (Scene aScene : scenario.getScenarioSceneList()) {
            if (aScene.getSceneId() == player.getPlayerCurrentSceneId()) {
                tempScene = aScene;
            }
        }
        return tempScene;
    }
}
