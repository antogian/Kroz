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
    private boolean lighting;

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
        this.lighting = false;
    }

    /**
     * Constructor with arguments for Scene objects.
     * @param newSceneDescription new Scene object's description.
     */
    public Scene(String newSceneDescription) {
        this.sceneDescription = newSceneDescription;
        this.sceneInventory = new Inventory();
        this.lighting = false;
    }
    
    public Scene(String newSceneDescription, Integer newNumberOfExits) {
        this.sceneDescription = newSceneDescription;
        this.sceneInventory = new Inventory();
        this.numberOfExits = newNumberOfExits;
    }
    
    public Scene(String newSceneDescription, Integer newNumberOfExits, Boolean newLighting) {
        this.sceneDescription = newSceneDescription;
        this.sceneInventory = new Inventory();
        this.numberOfExits = newNumberOfExits;
        this.lighting = newLighting;
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

    public boolean hasLighting() {
        return lighting;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
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
