/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.scene.templates;

import com.kroz.items.Torch;
import com.kroz.scene.Scene;

/**
 *
 * @author Eleni
 */
public class Garden extends Scene {

    public Garden() {
        super("You are in a Garden. East there is a Clearing. South there is a House.", 2);
        this.setLighting(true);
        this.getSceneInventory().addItemInInventory(new Torch());
    }

}
