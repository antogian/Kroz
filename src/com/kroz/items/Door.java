package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Door extends Item {

    public Door() {
        super("Door", "a door", ItemType.SCENE_OBJECT, ItemState.ENABLED);
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
