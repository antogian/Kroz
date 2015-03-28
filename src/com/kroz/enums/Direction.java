/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.enums;

/**
 *
 * @author Tony
 */
public enum Direction {
    DEFAULT("DEFAULT"),
    N("NORTH"),
    NW("NORTHWEST"), NE("NORTHEAST"),
    W("WEST"), E("EAST"),
    SW("SOUTHWEST"), SE("SOUTHEAST"),
    S("SOUTH");
    
    private String name;
    
    Direction(String name){
        this.name = name;
    }
    
    public void setValue(String name){
        this.name = name;
    }
    
    public String getValue(){
        return this.name;
    }
    
    public static Direction extractDirection(String directionString) {
        Direction direction = Direction.DEFAULT;
        for (Direction temp : Direction.values()) {
            if (temp.getValue().equalsIgnoreCase(directionString)) {
                direction = temp;
            }                
        }
        return direction;
    } 
}
