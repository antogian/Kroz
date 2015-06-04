/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scene.templates;

import com.kroz.scene.Scene;

/**
 *
 * @author Eleni
 */
public class Room extends Scene {

    public Room() {
        super("You are in a Room. East there is a Kitchen. South you can see a staircase leading to the Basement."
               + "\nNorth is a Garden.\n", 3);
        this.setLighting(false);
    }

}
