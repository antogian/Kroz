/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.items;

/**
 *
 * @author Immortuon
 */
public class Torch extends Item {

    public Torch(String name, String itemDescription, ItemType type, ItemState state) {
        super(name, itemDescription, type, state);
    }
    /**
     * Implementation of the abstract method of the Item superclass.
     */
    @Override
    public void useItem(){
        if(state == ItemState.DISABLED)
            state = ItemState.ENABLED;
        System.out.println("Light up the Darkness!");
}
    
}
