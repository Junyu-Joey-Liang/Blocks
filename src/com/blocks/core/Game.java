package com.blocks.core;

import com.blocks.enemies.BasicEnemy;
import com.blocks.enemies.MenuEnemy;
import com.blocks.enemies.SafeSpot;
import com.blocks.player.HUD;
import com.blocks.player.Player;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;

    // variables
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private Boolean running = false;
    private Handler handler;
    private Random r;
    public HUD hud;
    private Levels spawner;
    private Menus menus;
    private GameObject player;


    public enum STATE {
        Menu,
        Game,
        Dead,
    }

    public STATE state = STATE.Menu;


    public Game() {
        handler = new Handler();
        hud = new HUD();
        player = new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ObjectType.Player, handler, hud);
        menus = new Menus(this, this.handler, this.hud);
        this.addKeyListener(new KeyInput(handler, this.player));
        this.addMouseListener(menus);

        new Window(WIDTH, HEIGHT, "Avoid The Blocks", this);
        r = new Random();

        spawner = new Levels(handler, hud, player);

        if (state == STATE.Game) {
            handler.gameObjects.clear();
//            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
        } else {
            for (int i = 0; i < 8; i++) {
                handler.addObject(new MenuEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.MenuEnemy, handler));
            }
        }
    }


    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }


    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }


    public void tick() {
        handler.tick();
        player.tick();

        if (state == STATE.Game) {
            hud.tick();
            spawner.tick();

            if (hud.HEALTH <= 0) {
                hud.HEALTH = 100;
                hud.greenValue = 250;
                this.state = STATE.Dead;
            }

        } else if (state == STATE.Menu || state == STATE.Dead) {
            menus.tick();
        }


    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if (state == STATE.Game) {
            hud.render(g);
            player.render(g);
        } else if (state == STATE.Menu || state == STATE.Dead) {
            menus.render(g);
        }


        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max) {
        if (var >= max) return max;
        else if (var <= min) return min;
        else return var;
    }


    public static void main(String args[]) {
        new Game();

    }

}
