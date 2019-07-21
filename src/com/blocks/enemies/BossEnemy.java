package com.blocks.enemies;

import com.blocks.core.Game;
import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject {

    private Handler handler;
    private int timer = 80;
    private int timer2 = 50;
    private Random r = new Random();
    private int timer3 = 0;

    public BossEnemy(float x, float y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 0;
        this.velY = 1f;
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 96);
    }


    public void tick() {
        x += velX;
        y += velY;
        timer3++;

        if (timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            if (velX == 0) velX = 2;
            int spawn = r.nextInt(15);
            if (spawn == 0) {
                handler.addObject(new BossBullet(x + 48, y + 48, ObjectType.BossBullet, handler));
            }
        }

        //if(y<=0 || y>=Game.HEIGHT) velY*=-1f;
        if (x <= 0 || x >= Game.WIDTH - 96) velX *= -1f;


        handler.addObject(new Trail(x, y, ObjectType.Trail, Color.blue, 96, 96, 0.8f, handler));

        if (timer3 > 1000) {
            handler.removeObject(this);
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y, 96, 96);

    }

}
