package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Door extends OpenableItem {

    public Door() {
        super("Door", "a door", ItemType.SCENE_OBJECT, ItemState.DEFAULT);
    }
    
    public Door(ItemState lockState) {
        super("Door", "a door", ItemType.SCENE_OBJECT, ItemState.DEFAULT, lockState);
    }
}
