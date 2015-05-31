package com.kroz.items;

import com.kroz.commands.CLOSE;
import com.kroz.commands.LOCK;
import com.kroz.commands.OPEN;
import com.kroz.commands.UNLOCK;
import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
public class Door extends Item {
    
    private ItemState lock;
    private Key doorKey;
    
    public Door() {
        super("Door", "a door", ItemType.SCENE_OBJECT, ItemState.DEFAULT);
        this.setLegalActions();
    }
    
    public Door(ItemState lockState) {
        super("Door", "a door", ItemType.SCENE_OBJECT, ItemState.DEFAULT);
        this.lock = lockState;
        this.setLegalActions();
    }
    
    public void setLegalActions(){
        OPEN.addOpenableItem(this);
        CLOSE.addCloseableItem(this);
        UNLOCK.addUnlockableItem(this);
        LOCK.addLockableItem(this);
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
    
    public void lockDoor(){
        if(this.lock == ItemState.DEFAULT){
            System.out.println("This door has no lock.");
        }
        else if (this.lock == ItemState.ENABLED){
            System.out.println("The door is already locked.");
        }
        else {
            this.lock = ItemState.ENABLED;
        }
    }
    
    public void unlockDoor(){
        if(this.lock == ItemState.DEFAULT){
            System.out.println("This door has no lock.");
        }
        else if (this.lock == ItemState.DISABLED){
            System.out.println("The door is already unlocked.");
        }
        else {
            this.lock = ItemState.DISABLED;
        }
    }
    
    public void setLockState(ItemState newLockState){
        this.lock = newLockState;
    }
    
    public boolean isItemLocked(){
        if (this.lock == ItemState.ENABLED){
            return true;
        }
        else {
            return false;
        }
    }
}
