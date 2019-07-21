package com.blocks.core;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    public float x, y;
    protected ObjectType objectType;
    protected float velX, velY; // velovity

    public GameObject(float x, float y, ObjectType objectType) {
        this.x = x;
        this.y = y;
        this.objectType = objectType;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return this.x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return this.y;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public ObjectType getObjectType() {
        return this.objectType;
    }

    public void setVelY(float vely) {
        this.velY = vely;
    }

    public float getVelY() {
        return this.velY;
    }

    public void setVelX(float velx) {
        this.velX = velx;
    }

    public float getVelX() {
        return this.velX;
    }

}
