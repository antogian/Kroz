/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class SAVE implements ICommand{
    public Player currentPlayer;
    public List<String> currentCommandTextList;
    
    public SAVE(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
    }
    
    @Override
    public void executeCommand(){
        String filename = this.currentPlayer.getRawPlayerName() + ".xml";
        try{
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
            encoder.writeObject(this.currentPlayer);
            encoder.close();
            System.out.println("Game saved");
        }
        catch(Exception e){
            System.out.println("Exception caught");
        }
    }
    
    @Override
    public void setCurrentPlayer(Player newCurrentPlayer){
        this.currentPlayer = newCurrentPlayer;
    }
    
    @Override
    public void setCommandTextList(List<String> newRawCommandText){
        this.currentCommandTextList = newRawCommandText;
    }

    @Override
    public boolean isValid(){
        return this.currentCommandTextList.isEmpty();
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command SAVE doesnt get any parameters. Try: [SAVE]";
    }
    
}
