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
    private Integer numberOfExits;

    public Scene() {
        initialize();
    }

    /**
     * Initializes the attributes of a new Scene object.
     */
    private void initialize() {
        this.sceneDescription = "Default Scene Description.";
        this.sceneInventory = new Inventory();
        this.numberOfExits = 0;
    }

    /**
     * Constructor with arguments for Scene objects.
     * @param newSceneDescription new Scene object's description.
     */
    public Scene(String newSceneDescription) {
        this.sceneDescription = newSceneDescription;
        this.sceneInventory = new Inventory();
    }
    
    public Scene(String newSceneDescription, Integer newNumberOfExits) {
        this.sceneDescription = newSceneDescription;
        this.sceneInventory = new Inventory();
        this.numberOfExits = newNumberOfExits;
    }

    public void setSceneDescription(String newSceneDescription) {
        this.sceneDescription = newSceneDescription;
    }

    public String getSceneDescription() {
        return this.sceneDescription;
    }

    public Inventory getSceneInventory() {
        return this.sceneInventory;
    }

    public Integer getNumberOfExits() {
        return this.numberOfExits;
    }

    public void setNumberOfExits(Integer numberOfExits) {
        this.numberOfExits = numberOfExits;
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
