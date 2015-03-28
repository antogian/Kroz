package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
*
* @author Immortuon
*/
abstract public class Item {
   String name;
   String itemDescription;
   ItemType type;
   ItemState state;
   
   public Item(String name, String itemDescription, ItemType type, ItemState state)
   {
       this.name = name;
       this.itemDescription = itemDescription;
       this.type = ItemType.SCENE_OBJECT;
       this.state = ItemState.DISABLED;
   }
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	public ItemState getState() {
		return state;
	}
	public void setState(ItemState state) {
		this.state = state;
	}
	abstract public void useItem();  
	}
   
