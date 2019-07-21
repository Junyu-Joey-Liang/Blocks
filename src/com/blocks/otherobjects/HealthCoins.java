package com.blocks.otherobjects;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HealthCoins extends GameObject {

    private Handler handler;
    private int timer = 0;

    public HealthCoins(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 3f;
        this.velY = 3f;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 32);
    }


    public void tick() {
        if (timer > 300) {
            handler.removeObject(this);
        }

        timer++;

//		x+=velX;
//		y+=velY;
//		
//		if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
//		if(x<=0 || x>=Game.WIDTH) velX*=-1f;

//		handler.addObject(new Trail(x,y,ObjectType.Trail,Color.red,16,16,0.05f,handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval((int) x, (int) y, 20, 32);

    }

}
