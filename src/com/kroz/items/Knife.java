package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Knife extends Item {

    public Knife() {
        super("Knife", "a sharpened knife", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
    }

    /**
     * Implementation of the abstract method of the Item superclass.
     */
    @Override
    public void useItem() {
        if (itemState == ItemState.DISABLED) {
            itemState = ItemState.ENABLED;
        }
        System.out.println("A drop of blood runs from your thumb as you touch the sharpened edge...");
    }
}
