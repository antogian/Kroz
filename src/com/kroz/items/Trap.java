package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Trap extends Item {
    /*
    An attribute should be added which will embody the entities of 
    something like green and red wires on bombs (boolean or a new enum).
    Given that the player owns a knife he can cut the one or the other wire.
    If it is the one on ,for example, boolean 0 then the trap detonates 
    and the player dies. Else, a door opens.
    */

    public Trap() {
        super("Trap", "a hidden trap", ItemType.SCENE_OBJECT, ItemState.ENABLED);
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
