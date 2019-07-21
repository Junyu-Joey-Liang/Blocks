package com.blocks.enemies;

import com.blocks.core.Handler;
import com.blocks.core.*;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, ObjectType objectType, Handler handler, GameObject player) {
        super(x, y, objectType);

        for (int i = 0; i < handler.gameObjects.size(); i++) {
            if (handler.gameObjects.get(i).getObjectType() == ObjectType.Player) player = handler.gameObjects.get(i);
        }

//		this.velX = 7;
//		this.velY = 7;
        this.handler = handler;
        this.player = player;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }


    public void tick() {
        x += velX;
        y += velY;

        float diffx = x - player.getX() - 16f;
        float diffy = y - player.getY() - 16f;
        float dis = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        this.velX = (-2 / dis) * diffx;
        this.velY = (-2 / dis) * diffy;

//		if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
//		if(x<=0 || x>=Game.WIDTH) velX*=-1f;
//		
        handler.addObject(new Trail(x, y, ObjectType.Trail, Color.magenta, 16, 16, 0.02f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, 16, 16);

    }

}
