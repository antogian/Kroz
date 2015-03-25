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
abstract public class Item {
    String name;
    String itemDescription;
    ItemType type;
    ItemState state;
    
    public Item(String name, String itemDescription, ItemType type, ItemState state)
    {
        this.name = name;
        this.itemDescription = itemDescription;
        this.type = ItemType.SCENE_OBJECT;
        this.state = ItemState.DISABLED;
    }
    abstract public void useItem();
    
}