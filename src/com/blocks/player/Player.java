package com.blocks.player;

import com.blocks.core.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

    Handler handler;
    HUD hud;
    private Boolean bonus = false;
    private int timer = 0;


    public Player(float x, float y, ObjectType objectType, Handler handler, HUD hud) {
        super(x, y, objectType);
        this.handler = handler;
        this.hud = hud;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        this.x += this.velX;
        this.y += this.velY;
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);
            if (tempObject.getObjectType() == ObjectType.BasicEnemy || tempObject.getObjectType() == ObjectType.FastEnemy || tempObject.getObjectType() == ObjectType.SmartEnemy || tempObject.getObjectType() == ObjectType.BossEnemy || tempObject.getObjectType() == ObjectType.BossBullet || tempObject.getObjectType() == ObjectType.SuperEnemy || tempObject.getObjectType() == ObjectType.SuperLaser) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (this.handler.gameMode == GameMode.HARD) this.hud.HEALTH -= 2;
                    if (this.handler.gameMode == GameMode.EASY) this.hud.HEALTH -= 1;
                    if (this.handler.gameMode == GameMode.UNDEFEATABLE) {}
                }
            }
            if (tempObject.getObjectType() == ObjectType.HealthCoins) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (this.hud.HEALTH == 100) {
                        this.hud.score += 500;
                        bonus = true;
                        timer = 0;
                    }
                    this.hud.HEALTH += 15;
                    handler.removeObject(tempObject);
                }
            }
            if(tempObject.getObjectType() == ObjectType.SafeSpot){
                if (!getBounds().intersects(tempObject.getBounds())) {
                    if (this.handler.lightningOn){
                        this.hud.HEALTH -= 1;
                    }
                }
            }
        }
    }

    public void render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);

        if (bonus && timer < 80) {
            timer++;
            Font font2 = new Font("arial", 1, 50);
            g.setFont(font2);
            g.setColor(Color.lightGray);
            g.drawString("BONUS!", 80, 200);
        } else if (bonus && timer >= 80) {
            bonus = false;
        }

    }


}
