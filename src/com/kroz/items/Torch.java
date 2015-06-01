package com.kroz.items;

import com.kroz.commands.DROP;
import com.kroz.commands.LIGHT;
import com.kroz.commands.TAKE;
import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;
import com.kroz.scene.Scene;

/**
*
* @author Immortuon
*/
public class Torch extends Item {

    public Torch() {
        super("Torch", "an unused torch", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
        this.setLegalActions();
    }
    public void useItem(Scene currentScene){
        currentScene.setLighting(true);
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
    
    public void setLegalActions(){
        TAKE.addTakeableItem(this);
        DROP.addDroppableItem(this);
        LIGHT.addLightableItems(this);
    }
}
