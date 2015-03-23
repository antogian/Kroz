/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.commands;

/**
 * Command EXIT closes the game.
 * @author Eleni Aidonidou
 */
public class EXIT implements ICommand {

    @Override
    public void executeCommand() {
        System.exit(0);
    }
}
