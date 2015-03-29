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
 * @author Eleni
 */
public class Key extends Item {
    public Key() {
        super("Key", "a key that unlocks a door", ItemType.PLAYER_OBJECT, ItemState.DISABLED);
    }
    @Override
    public void useItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
