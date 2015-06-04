/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.parsers;

import com.kroz.scenario.CustomScenario;
import com.kroz.scenario.DefaultScenario;
import com.kroz.scenario.IScenario;
import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class ConsoleInputParser {
    private Scanner scanner;

    public ConsoleInputParser() {
        initialize();
    }

    /**
    *Initializes scanner object
    */
    private void initialize() {
        scanner = new Scanner(System.in);
    }

    /**
    *@return user's input in order to become a command
    */
    public String getInputFromConsole() {
        System.out.println("\nEnter Command:");
        String temp = scanner.nextLine();
        while (temp.startsWith(" ") || temp.isEmpty()) {
            System.out.println("Wrong Syndax. Enter new input: ");
            temp = scanner.nextLine();
        }
        return temp;
    }
    /**
    *Closes scanner object
    */
    public void closeStream() {
        scanner.close();
    }
}
