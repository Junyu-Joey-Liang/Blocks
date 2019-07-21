package com.blocks.enemies;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SuperEnemy extends GameObject {

    private Handler handler;
    private int timer = 0;
    private int timer2 = 0;

    public SuperEnemy(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 0f;
        this.velY = 0f;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 48, 48);
    }


    public void tick() {
//		x+=velX;
//		y+=velY;
//		
//		if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
//		if(x<=0 || x>=Game.WIDTH) velX*=-1f;

//		handler.addObject(new Trail(x,y,ObjectType.Trail,Color.red,16,16,0.05f,handler));
        timer++;
        timer2++;

        if (timer > 100) {
            timer = 0;
            handler.addObject(new SuperLaser(x, y, ObjectType.BossBullet, handler));
        }
        if (timer2 > 300) {
            handler.gameObjects.remove(this);
        }


    }

    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int) x, (int) y, 48, 48);

    }

}
