package com.blocks.enemies;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Lightning extends GameObject {

    private Handler handler;
    private int timer;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Lightning(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 3f;
        this.velY = 3f;
        this.handler = handler;
        this.handler.lightningOn = true;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);
    }


    public void tick() {
        timer++;

        if(timer>50){
            this.handler.lightningOn = false;
            handler.gameObjects.remove(this);
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0, 0, WIDTH, HEIGHT);

    }

}
