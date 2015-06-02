package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Torch extends LightableItem {

    public Torch() {
        super("Torch", "an unused torch", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
    }
}
