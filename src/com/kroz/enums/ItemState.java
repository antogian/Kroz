package com.kroz.enums;

/**
*
* @author Immortuon
*/

public enum ItemState {
   ENABLED("ON"), 
   DISABLED("OFF");
   
   private String state;
   
   ItemState(String name){
       this.state = name;
   }
   
   public void setValue(String name){
       this.state = name;
   }
   
   public String getValue(){
       return this.state;
   }
}
