/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import com.kroz.scenario.DefaultScenario;
import com.kroz.scenario.IScenario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tony
 */
public class RESTART implements ICommand{
    public Player currentPlayer;
    public List<String> currentCommandTextList;
    public IScenario scenario;
    
    public RESTART(){
        this.initialize();
    }
    
    public void initialize(){
        this.currentPlayer = new Player();
        this.currentCommandTextList = new ArrayList<String>();
        scenario = new DefaultScenario();
        
    }
    
    @Override
    public void executeCommand(){
        this.currentPlayer.setPlayerCurrentScene(scenario.getScenarioSceneList().get(0));
        this.currentPlayer.getPlayerInventory().clearInventory();
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
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    @Override
    public String getInvalidInputMessage() {
        return "Command RESTART doesnt get any parameters. Try: [RESTART]";
    }
}
