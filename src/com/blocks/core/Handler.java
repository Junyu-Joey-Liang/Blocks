package com.blocks.core;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    public Boolean lightningOn = false;
//    public Boolean unDefeatableMode = true; //set true for testing
    public GameMode gameMode;
    public LinkedList<GameObject> gameObjects;

    public Handler() {
        gameObjects = new LinkedList<>();
    }

    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            // loop through every gameObjects in the program
            GameObject tempObject = gameObjects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);
            tempObject.render(g);
        }

    }

    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    public void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }

    public void clearEnemies() {
        this.gameObjects.clear();
    }
}
