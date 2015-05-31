/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.items;

import com.kroz.commands.DROP;
import com.kroz.commands.TAKE;
import com.kroz.enums.ItemState;
import com.kroz.enums.ItemType;

/**
 *
 * @author Eleni
 */
public class Key extends Item {
    
    private Door currentItem;
    
    public Key() {
        super("Key", "a key that unlocks a door", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
        this.currentItem = new Door();
        this.setLegalActions();
    }
    
    public Key(Door newDoor){
        super("Key", "a key that unlocks a door", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
        this.currentItem = newDoor;
        this.setLegalActions();
    }
    
    public void unlockItem(){
        this.currentItem.unlockDoor();
    }
    
    public void lockItem(){
        this.currentItem.lockDoor();
    }
    
    @Override
    public void changeItemState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setCurrentItem(Item newItem){
        this.currentItem = (Door)newItem;
    }
    
    public void setLegalActions(){
        TAKE.addTakeableItem(this);
        DROP.addDroppableItem(this);
    }
    
}