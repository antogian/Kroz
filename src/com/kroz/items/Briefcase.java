/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.items;

import com.kroz.enums.ItemType;
import com.kroz.enums.ItemState;

/**
 *
 * @author Tony
 */
public class Briefcase extends Item{
    
    public Briefcase(){
        super("Briefcase", "A briefcase full of money", ItemType.PLAYER_OBJECT, ItemState.DISABLED);       
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