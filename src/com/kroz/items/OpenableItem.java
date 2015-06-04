/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.items;

import com.kroz.enums.ItemState;
import com.kroz.enums.ItemType;

/**
 *
 * @author Tony
 */
public class OpenableItem extends Item{
    
    protected ItemState currentLock;
    
    public OpenableItem(){
        super("Openable Item", "An openable item", ItemType.SCENE_OBJECT, ItemState.DEFAULT);
        this.currentLock = ItemState.DEFAULT;
    }
    
    public OpenableItem(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState) {
        super(newItemName, newItemDescription, newItemType, newItemState);
        this.currentLock = ItemState.DEFAULT;
    }
    
    public OpenableItem(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState, ItemState lockState) {
        super(newItemName, newItemDescription, newItemType, newItemState);
        this.currentLock = lockState;
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
    
    public boolean hasItemLock(){
        return !this.currentLock.DEFAULT.getValue().equals("DEFAULT");
    }
    
    public void setLockState(ItemState newLockState){
        this.currentLock = newLockState;
    }
    
    public boolean isItemLocked(){
        if (this.currentLock == ItemState.ENABLED){
            return true;
        }
        else {
            return false;
        }
    }
}