/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scene.templates;

import com.kroz.items.Briefcase;
import com.kroz.scene.Scene;

/**
 *
 * @author Eleni
 */
public class Basement extends Scene {

    public Basement() {
        super("You are in a Basement. North there is a staircase leading upwards.", 1);
        this.setLighting(false);
        this.getSceneInventory().addItemInInventory(new Briefcase());
    }
}