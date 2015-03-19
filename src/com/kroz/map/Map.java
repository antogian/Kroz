/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kroz.map;

import com.kroz.scenes.SceneExit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private HashMap<Integer, List<SceneExit>> map;

    public Map() {
        initialize();
    }

    private void initialize() {
        map = new HashMap<Integer, List<SceneExit>>();
    }

    public HashMap<Integer, List<SceneExit>> getMap() {
        return map;
    }

    /**
     * Setting of new map
     * @param map an argument of complete map (i.e. a HashMap filled with keys and values)
     */
    public void setMap(HashMap<Integer, List<SceneExit>> map) {
        this.map = map;
    }

    /**
     * Creates a list of possible exit objects in map's scenes.
     * If there is no such list, it creates it.
     * If there is an exit list and it does not contain the new exit already, it does add it.
     * @param mapKey it is actually the ID of the scene on exit.
     * @param newExit it is the direction and destination of the exit (i.e. attributes of SceneExit object).
     */
    public void addExitToScene(Integer mapKey, SceneExit newExit) {
        List<SceneExit> exitsList = map.get(mapKey);
        if (exitsList == null) {
            exitsList = new ArrayList<SceneExit>();
            exitsList.add(newExit);
            map.put(mapKey, exitsList);
        } else {
            if (!exitsList.contains(newExit)) {
                exitsList.add(newExit);
            }
        }
    }

    /**
     * Checks if movement through map is eligible 
     * (i.e. if the player is navigating in eligible for navigation directions).
     * @param mapKey where player is supposed to go.
     * @param direction the direction in which the player wants to move.
     * @return true if player is navigating correctly.
     */
    public boolean canGoThere(Integer mapKey, String direction) {
        boolean canGo = false;
        for (SceneExit tempExit : this.map.get(mapKey)) {
            if (tempExit.getDirection().equalsIgnoreCase(direction)) {
                canGo = true;
            }
        }
        return canGo;
    }
}
