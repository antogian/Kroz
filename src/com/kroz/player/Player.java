/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.player;

import com.kroz.scenario.IScenario;
import com.kroz.scenes.Scene;
import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class Player {
    private String playerName;
    private Scene playerCurrentScene;
    private IScenario currentScenario;

    public Player() {
        initialize();
    }
    /**
     * 
     * @param playerName playersName to set 
     */
    public Player(String playerName, IScenario scenario) {
        this.playerName = playerName;
        this.playerCurrentScene = new Scene("Default Scene Desctiption.");
        this.currentScenario = scenario;
    }
    /*
    * Initializing attributes with default values.
    */
    private void initialize() {
        playerName = "Default Player";
        playerCurrentScene = new Scene("Default Scene Desctiption.");
    }
    /**
    *Sets the player's name.
    * 
    *Doesn't have parameters because it reads the data from keyboard
    * and then sets the player's name.
    */
    public void setPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String temp = scanner.nextLine();
        while (temp.startsWith(" ") || temp.isEmpty()) {
            System.out.println("Invalid Name.");
            System.out.println("Enter player name: ");
            temp = scanner.nextLine();
        }
        this.playerName = temp;
    }
    /**
     * Displays player's name at screen
     */
    public void getPlayerName() {
        System.out.println("Current Player: " + this.playerName);
    }
    /**
    * 
    * @param playerCurrentScene playerCurrentScene to set
    */
    public void setPlayerCurrentScene(Scene playerCurrentScene) {
        this.playerCurrentScene = playerCurrentScene;
    }
    /**
     * Getter for IScenario attribute.
     * @return returns the IScenario object stored in current player object.
     */
    public IScenario getCurrentScenario() {
        return currentScenario;
    }
    /**
     * Setter for IScenario attribute.
     * @param currentScenario New IScenario object to be put in the attribute.
     */
    public void setCurrentScenario(IScenario currentScenario) {
        this.currentScenario = currentScenario;
    }
    /**
     * 
     * @return playerCurrentSceneId 
     */
    public Scene getPlayerCurrentScene() {
        return this.playerCurrentScene;
    }
}
