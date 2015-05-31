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
        super("You are in a room. East there is a kitchen."
                + "\nSouth you can see a staircase leading to the basement."
                + "\nNorth is an open door leading to a garden.\n", 2);
    }

}
