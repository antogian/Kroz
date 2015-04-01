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
    /**
     * Implementation of the abstract method of the Item superclass.
     */
    @Override
    public void useItem() {
        if (itemState == ItemState.DISABLED) {
            itemState = ItemState.ENABLED;
        }
        System.out.println("You cannot contain your fear as you read through this damned leaflet. Why is this happening to me?");
    }
}

