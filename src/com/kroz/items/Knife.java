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
    public void useItem(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * Implementation of the abstract method of the Item superclass.
     */
    @Override
    public void changeItemState() {
        if (itemState == ItemState.DISABLED) {
            itemState = ItemState.ENABLED;
        }
        else if (itemState == ItemState.ENABLED){
            itemState = ItemState.DISABLED;
        }
    }
}
