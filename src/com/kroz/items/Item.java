package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
abstract public class Item {
   protected String itemName;
   protected String itemDescription;
   protected ItemType itemType;
   protected ItemState itemState;
   
   public Item(String newItemName, String newItemDescription, ItemType newItemType, ItemState newItemState)
   {
       this.itemName = newItemName;
       this.itemDescription = newItemDescription;
       this.itemType = ItemType.SCENE_OBJECT;
       this.itemState = ItemState.DISABLED;
   }
    public String getItemName() {
        return itemName.toUpperCase();
    }
    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public void setItemDescription(String newItemDescription) {
        this.itemDescription = newItemDescription;
    }
    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType newItemType) {
        this.itemType = newItemType;
    }
    public ItemState getItemState() {
        return itemState;
    }
    public void setItemState(ItemState newItemState) {
        this.itemState = newItemState;
    }
    abstract public void changeItemState();
}

