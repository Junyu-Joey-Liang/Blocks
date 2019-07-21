package com.blocks.enemies;

import com.blocks.core.Game;
import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 7.5f;
        this.velY = 7.5f;
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }


    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT) velY *= -1f;
        if (x <= 0 || x >= Game.WIDTH) velX *= -1f;

        handler.addObject(new Trail(x, y, ObjectType.Trail, Color.cyan, 16, 16, 0.05f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int) x, (int) y, 16, 16);

    }

}
