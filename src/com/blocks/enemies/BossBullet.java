package com.blocks.enemies;

import com.blocks.core.Game;
import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBullet extends GameObject {

    private Handler handler;
    private Random r = new Random();

    public BossBullet(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = r.nextInt(5 - -5) + -5;
        this.velY = 5;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }


    public void tick() {
        x += velX;
        y += velY;

        //if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
        //if(x<=0 || x>=Game.WIDTH) velX*=-1f;
        if (y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail(x, y, ObjectType.Trail, Color.blue, 16, 16, 0.05f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y, 16, 16);

    }

}
