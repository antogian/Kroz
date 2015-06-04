/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scene.templates;

import com.kroz.items.Briefcase;
import com.kroz.items.Key;
import com.kroz.items.Torch;
import com.kroz.scene.Scene;

/**
 *
 * @author Eleni
 */
public class Forest extends Scene{

    public Forest() {
        super("You are in a Forest. West there is a Clearing.", 1);
        this.setLighting(true);
        this.getSceneInventory().addItemInInventory(new Key());
    }

}
