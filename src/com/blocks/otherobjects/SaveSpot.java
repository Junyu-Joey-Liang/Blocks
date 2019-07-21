package com.blocks.otherobjects;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SaveSpot extends GameObject {

    private Handler handler;

    public SaveSpot(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 3f;
        this.velY = 3f;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 40, 40);
    }


    public void tick() {
//		x+=velX;
//		y+=velY;
//		
//		if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
//		if(x<=0 || x>=Game.WIDTH) velX*=-1f;
//		
//		handler.addObject(new Trail(x,y,ObjectType.Trail,Color.yellow,40,40,0.05f,handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, 40, 40);

    }

}
