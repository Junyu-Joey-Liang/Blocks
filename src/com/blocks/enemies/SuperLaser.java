package com.blocks.enemies;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SuperLaser extends GameObject {

    private Handler handler;
    private Random r = new Random();
    private int timer = 0;

    public SuperLaser(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = r.nextInt(5 - -5) + -5;
        this.velY = 5;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 640, 48);
    }


    public void tick() {
//		x+=velX;
//		y+=velY;

        //if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
        //if(x<=0 || x>=Game.WIDTH) velX*=-1f;
        timer++;
        if (timer > 20) handler.removeObject(this);

    }

    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int) x, (int) y, 640, 48);

    }

}
