package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Door extends Item {

    public Door(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState) {
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
        System.out.println("The sound of rust pierces through your ears as the door opens...");
    }
}
