package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Leaflet extends Item {
    private String message;//e.g. a riddle

    /*
    We must add a multiple choice answers "sheet" (switch case) for message.
    For the correct answer, the player continues his/her journey.
    For the wrong answer, the player dies or activates a trap.
    */
    public Leaflet() {
        super("Leaflet", "an unread leaflet", ItemType.SCENE_OBJECT, ItemState.DISABLED);
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

