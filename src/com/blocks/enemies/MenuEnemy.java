package com.blocks.enemies;

import com.blocks.core.Game;
import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuEnemy extends GameObject {

    private Handler handler;
    private Random r = new Random();
    private int red = r.nextInt(255);
    private int blue = r.nextInt(255);
    private int green = r.nextInt(255);
    Color mycolor = new Color(red, green, blue);

    public MenuEnemy(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = (float) r.nextInt(12);
        this.velY = (float) r.nextInt(12);
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

        handler.addObject(new Trail(x, y, ObjectType.Trail, mycolor, 16, 16, 0.03f, handler));

    }

    public void render(Graphics g) {
        g.setColor(mycolor);
        g.fillRect((int) x, (int) y, 16, 16);

    }

}

