/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scenes;

public class Scene {
    private String sceneDescription;

    public Scene() {
        initialize();
    }

    /**
     * Initializes the attributes of a new Scene object.
     */
    private void initialize() {
        sceneDescription = "Default Scene Description.";
    }

    /**
     * Constructor with arguments for Scene objects.
     * @param newSceneDescription new Scene object's description.
     */
    public Scene(String newSceneDescription) {
        this.sceneDescription = newSceneDescription;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }
}
