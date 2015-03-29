/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scene;

import com.kroz.inventory.Inventory;
import java.util.EmptyStackException;

public class Scene {
    private String sceneDescription;
    private Inventory sceneInventory;

    public Scene() {
        initialize();
    }

    /**
     * Initializes the attributes of a new Scene object.
     */
    private void initialize() {
        sceneDescription = "Default Scene Description.";
        sceneInventory = new Inventory();
    }

    /**
     * Constructor with arguments for Scene objects.
     * @param newSceneDescription new Scene object's description.
     */
    public Scene(String newSceneDescription) {
        this.sceneDescription = newSceneDescription;
        sceneInventory = new Inventory();
    }

    public void setSceneDescription(String newSceneDescription) {
        this.sceneDescription = newSceneDescription;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }

    public Inventory getSceneInventory() {
        return sceneInventory;
    }

    public void showSceneInventory() {
        try {
            this.getSceneInventory().showInventory();
        } catch (EmptyStackException e) {
            //if there are no available items for the scene
            //there is no reason to print a message.
        }
    }
}
