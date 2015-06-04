/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.inventory;

import com.kroz.items.Item;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 *
 * @author Eleni
 */
public class Inventory {
    private List<Item> itemList;

    public Inventory() {
        initialize();
    }

    private void initialize() {
        itemList = new ArrayList<Item>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> newItemList) {
        this.itemList = newItemList;
    }

    /**
     * Shows the inventory.
     */
    public void showInventory() {
        if (this.itemList.isEmpty()) {
            throw new EmptyStackException();
        } else {
            System.out.println("There is: ");
            for (Item temp : itemList) {
                System.out.println(temp.getItemDescription());
            }
        }
    }

    public void addItemInInventory (Item newItem) {
        this.itemList.add(newItem);
    }

    public void removeItemFromInventory (Item newItem) {
        if (itemExists(newItem)) {
            this.itemList.remove(newItem);
        } else {
            System.out.println("Item doesn't exist and can't be removed.");
        }
    }

    public boolean itemExists (Item newItem) {
        for (Item tempItem : this.itemList){
            if (tempItem.getItemName().equalsIgnoreCase(newItem.getItemName()))
                return true;
        }
        return false;
    }
    
    public void clearInventory(){
        this.itemList.clear();
    }
    
    public Item getItemFromInventory(Item newItem){
        for (Item tempItem : this.itemList){
            if (tempItem.getItemName().equalsIgnoreCase(newItem.getItemName())){
                return tempItem;
            }
        }
        return null;
    }
}
