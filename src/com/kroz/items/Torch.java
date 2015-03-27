/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
 *
 * @author Immortuon
 */
public class Torch extends Item {

    public Torch(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState) {
        super(newItemName, newItemDescription, newItemType, newItemState);
    }
    /**
     * Implementation of the abstract method of the Item superclass.
     */
    @Override
    public void useItem() {
        if (itemState == ItemState.DISABLED) {
            itemState = ItemState.ENABLED;
        }
        System.out.println("Light up the Darkness!");
    }
}