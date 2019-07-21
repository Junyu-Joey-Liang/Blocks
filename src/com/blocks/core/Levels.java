package com.blocks.core;

import com.blocks.enemies.*;
import com.blocks.player.HUD;
import com.blocks.otherobjects.*;
import com.blocks.otherobjects.*;

import java.util.Random;

public class Levels {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();
    private GameObject player;

    public Levels(Handler handler, HUD hud, GameObject player) {
        this.handler = handler;
        this.hud = hud;
        this.player = player;

    }

    public void tick() {
        scoreKeep++;
        if (scoreKeep >= 300) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
            }
            if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
                //handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) ,ObjectType.BasicEnemy,handler));
            }
            if (hud.getLevel() == 4) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.SmartEnemy, handler, player));
                handler.removeObject(handler.gameObjects.get(1));
                //handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) ,ObjectType.FastEnemy,handler));
            }
            if (hud.getLevel() == 5) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                //handler.addObject(new FastEnemy( r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) ,ObjectType.FastEnemy,handler));
            }
            if (hud.getLevel() == 6) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 7) {
                handler.clearEnemies();
                handler.addObject(new BossEnemy(Game.WIDTH / 2 - 48, -120, ObjectType.BossEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.SmartEnemy, handler, player));

                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 9) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 10) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));

                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 11) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));

                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 12) {
                handler.addObject(new SuperEnemy(0, r.nextInt(Game.HEIGHT), ObjectType.SuperEnemy, handler));
            }
            if (hud.getLevel() == 13) {
                handler.addObject(new SuperEnemy(0, r.nextInt(Game.HEIGHT), ObjectType.SuperEnemy, handler));
            }
            if (hud.getLevel() == 14) {
                handler.addObject(new SuperEnemy(0, r.nextInt(Game.HEIGHT), ObjectType.SuperEnemy, handler));
                handler.addObject(new SuperEnemy(0, r.nextInt(Game.HEIGHT), ObjectType.SuperEnemy, handler));

                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 15) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
            }
            if (hud.getLevel() == 16) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));

                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
                handler.addObject(new HealthCoins(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.HealthCoins, handler));
            }
            if (hud.getLevel() == 17) {
                handler.clearEnemies();
                handler.addObject(new BossEnemy(Game.WIDTH / 2 - 48, -120, ObjectType.BossEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.SmartEnemy, handler, player));
            }
            if (hud.getLevel() == 18) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
                //handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) ,ObjectType.BasicEnemy,handler));
            }
            if (hud.getLevel() == 19) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
            }
            if (hud.getLevel() == 20) {
                handler.clearEnemies();
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.SmartEnemy, handler, player));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
                handler.addObject(new SafeSpot(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.SafeSpot, handler));
            }
            if (hud.getLevel() == 21) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.FastEnemy, handler));
                handler.addObject(new SafeSpot(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ObjectType.SafeSpot, handler));
            }

        }
    }
}
