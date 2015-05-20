/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

import com.kroz.player.Player;
import java.util.List;

/**
 * The interface that all commands implement.
 * @author Eleni Aidonidou
 */
public interface ICommand {
    /**
     * Executes the ICommand object that was created.
     */
    void executeCommand();
    void setCurrentPlayer(Player newCurrentPlayer);
    public void setCommandTextList(List<String> newRawCommandText);
    public boolean isValid();
    public String getInvalidInputMessage();
}
