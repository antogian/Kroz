package com.kroz.enums;

/**
*
* @author Immortuon
*/
public enum ItemType {
  SCENE_OBJECT("SO"), 
  PLAYER_OBJECT("PO"); 
  
  private String type;
  
  ItemType(String name){
      this.type = name;
  }
  
  public void setValue(String name){
      this.type = name;
  }
  
  public String getValue(){
      return this.type;
  }
}
