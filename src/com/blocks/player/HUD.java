package com.blocks.player;

import com.blocks.core.Game;

import java.awt.Color;
import java.awt.Graphics;

// heads up display
public class HUD {

    public float HEALTH = 100;
    public float greenValue = 250;
    public int score = 0;
    public int level = 1;

    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, HEALTH * 2);

        score++;

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 20);
        g.setColor(new Color(75, (int) greenValue, 0));
        g.fillRect(15, 15, (int) HEALTH * 2, 20);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 20);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
