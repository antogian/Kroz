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
abstract public class Item {
    protected String itemName;
    protected String itemDescription;
    protected ItemType itemType;
    protected ItemState itemState;

    public Item (String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState) {
        this.itemName = newItemName;
        this.itemDescription = newItemDescription;
        this.itemType = newItemType.SCENE_OBJECT;
        this.itemState = newItemState.DISABLED;
    }
    abstract public void useItem();
}