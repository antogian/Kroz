/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.items;

import com.kroz.enums.ItemState;
import com.kroz.enums.ItemType;
import com.kroz.scene.Scene;

/**
 *
 * @author Tony
 */
public class LightableItem extends Item{
    
    public LightableItem(){
        super("Lightable Item", "A Lightable Item", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
    }
    
    public LightableItem(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState) {
        super(newItemName, newItemDescription, newItemType, newItemState);
    }
    
    public LightableItem(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState, Scene newScene) {
        super(newItemName, newItemDescription, newItemType, newItemState);
    }
    
    public void lightItem(Scene currentScene){
        currentScene.setLighting(true);
        this.setItemState(ItemState.ENABLED);
    }
    
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
