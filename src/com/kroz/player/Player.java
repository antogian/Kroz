/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.player;

import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class Player {
    private String playerName;
    private Integer playerCurrentSceneId;

    public Player() {
        initialize();
    }
    
    /**
     * 
     * @param playerName playersName to set 
     */
    public Player(String playerName) {
        this.playerName = playerName;
        this.playerCurrentSceneId = 0;
    }
    
    /*
    * Initializing attributes with default values.
    */
    private void initialize() {
        playerName = "Default Player";
        playerCurrentSceneId = -1;
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
    * 
    * @param playerCurrentSceneId playerCurrentSceneId to set
    */
    public void setPlayerCurrentSceneId(Integer playerCurrentSceneId) {
        this.playerCurrentSceneId = playerCurrentSceneId;
    }
    
    /**
     * Displays player's name at screen
     */
    public void getPlayerName() {
        System.out.println("Current Player: " + this.playerName);
    }

    /**
     * 
     * @return playerCurrentSceneId 
     */
    public Integer getPlayerCurrentSceneId() {
        return this.playerCurrentSceneId;
    }

}
