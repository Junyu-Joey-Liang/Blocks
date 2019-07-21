package com.blocks.enemies;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;
import com.blocks.core.ObjectType;
import com.blocks.otherobjects.SaveSpot;

import java.awt.*;
import java.util.Random;

public class SafeSpot extends GameObject {

    private Handler handler;
    private int timer;
    private Random r;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private final int width = 40;
    private final int height = 40;


    public SafeSpot(int x, int y, ObjectType objectType, Handler handler) {
        super(x, y, objectType);

        this.velX = 3f;
        this.velY = 3f;
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, this.width, this.height);
    }


    public void tick() {
        timer++;
        if (timer == 200) {
            handler.addObject(new Lightning(0, 0, ObjectType.Lightning, handler));
        }
        if (timer == 280) {
            handler.removeObject(this);
        }

    }

    public void render(Graphics g) {
        g.setColor(Color.green.brighter().brighter().brighter().brighter().brighter().brighter());
        g.fillRect((int) x, (int) y, this.width, this.height);

        Font font = new Font("arial", 1, 20);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString("hide to the green block!", 200, 40);
    }

}
