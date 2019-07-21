package com.blocks.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.blocks.core.Game.STATE;
import com.blocks.enemies.BasicEnemy;
import com.blocks.player.HUD;

public class Menus extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random r = new Random();


    public Menus(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println(mx);

        // play button
        if (mouseOver(mx, my, 210, 150, 200, 64) && game.state== STATE.Menu ) {
            game.state = STATE.Game;
            game.hud.score = 0;
            game.hud.level = 1;
            handler.gameObjects.clear();
            handler.gameMode = GameMode.EASY;
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
        }

        // hard
        if (mouseOver(mx, my, 210, 240, 200, 64) && game.state== STATE.Menu){
            game.state = STATE.Game;
            game.hud.score = 0;
            game.hud.level = 1;
            handler.gameObjects.clear();
            handler.gameMode = GameMode.HARD;
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
        }

        // undefeatable
        if (mouseOver(mx, my, 210, 330, 200, 64) && game.state== STATE.Menu){
            game.state = STATE.Game;
            game.hud.score = 0;
            game.hud.level = 1;
            handler.gameObjects.clear();
            handler.gameMode = GameMode.UNDEFEATABLE;
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ObjectType.BasicEnemy, handler));
        }



        // restart
        if  (mouseOver(mx, my, 200, 350, 200, 64)&& game.state== STATE.Dead){
            game.state = STATE.Menu;
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public Boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width && my > y && my < y + height) {
            return true;
        } else {
            return false;
        }
    }

    public void tick() {
    }

    public void render(Graphics g) {

        if (game.state == STATE.Menu) {
            Font font = new Font("arial", 1, 50);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("The World of Blocks", 60, 70);

            Font font2 = new Font("arial", 1, 30);
            g.setFont(font2);
            g.setColor(Color.white);
            g.drawRect(210, 150, 200, 64);
            g.drawString("EASY", 270, 190);

            g.setFont(font2);
            g.setColor(Color.white);
            g.drawRect(210, 240, 200, 64);
            g.drawString("HARD", 270, 280);

            g.setFont(font2);
            g.setColor(Color.white);
            g.drawRect(210, 330, 200, 64);
            g.drawString("TEST", 270, 370);
        }


        if (game.state == STATE.Dead) {

            handler.gameObjects.clear();

            Font font = new Font("arial", 1, 40);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString("!! YOU ARE DEAD !!", 120, 70);

            Font font2 = new Font("arial", 1, 30);
            g.setFont(font2);
            g.setColor(Color.white);
            //g.drawRect(210, 150, 200, 64);
            String score = "SCORE: " + game.hud.getScore();
            g.drawString(score, 80, 200);

            g.setColor(Color.white);
            g.drawRect(200, 350, 200, 64);
            g.drawString("Play Again", 220, 390);

            //game.hud.score=0;


        }

//		g.setColor(Color.white);
//		g.drawRect(210, 250, 200, 64);
//		g.drawString("Help", 270, 290);
//		g.setColor(Color.white);
//		g.drawRect(210, 350, 200, 64);
//		g.drawString("Quit", 270, 390);

    }

}
