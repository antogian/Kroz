package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Torch extends Item {

    public Torch() {
        super("Torch", "an unused torch", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
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
