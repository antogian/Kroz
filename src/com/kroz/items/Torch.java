package com.kroz.items;

import com.kroz.enums.ItemState;
import com.kroz.enums.ItemType;

/**
*
* @author Immortuon
*/
public class Torch extends Item {

   public Torch(String name, String itemDescription, ItemType type, ItemState state) {
       super(name, itemDescription, type, state);
   }
   /**
    * Implementation of the abstract method of the Item superclass.
    */
   @Override
   public void useItem(){
       if(state == ItemState.DISABLED)
           state = ItemState.ENABLED;
       System.out.println("Light up the Darkness!");
}
   
}