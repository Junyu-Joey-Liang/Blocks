package com.blocks.core;

import com.blocks.core.GameObject;
import com.blocks.core.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private GameObject player;
    private Handler handler;
    private Boolean[] keyDown = new Boolean[4];

    public KeyInput(Handler handler, GameObject player) {
        this.handler = handler;
        this.player = player;

        keyDown[0] = false; //up
        keyDown[1] = false; // down
        keyDown[2] = false; // right
        keyDown[3] = false; // left
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

//		for (int i=0;i<handler.gameObjects.size();i++) {
//			GameObject tempObject = handler.gameObjects.get(i);
//			if (tempObject.objectType==ObjectType.Player) {
//				if (key== KeyEvent.VK_UP) {tempObject.setVelY(-7f); keyDown[0]=true;} 
//				if (key== KeyEvent.VK_DOWN) {tempObject.setVelY(7f);keyDown[1]=true;}
//				if (key== KeyEvent.VK_RIGHT) {tempObject.setVelX(7f);keyDown[2]=true;}
//				if (key== KeyEvent.VK_LEFT) {tempObject.setVelX(-7f);keyDown[3]=true;}
//			}
//		}
        GameObject tempObject = player;
        if (key == KeyEvent.VK_UP) {
            tempObject.setVelY(-7f);
            keyDown[0] = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            tempObject.setVelY(7f);
            keyDown[1] = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            tempObject.setVelX(7f);
            keyDown[2] = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            tempObject.setVelX(-7f);
            keyDown[3] = true;
        }

        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        GameObject tempObject = player;
        if (key == KeyEvent.VK_UP) {
            keyDown[0] = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            keyDown[1] = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            keyDown[2] = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            keyDown[3] = false;
        }
        if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0f);
        if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0f);

//		for (int i=0;i<handler.gameObjects.size();i++) {
//			GameObject tempObject = handler.gameObjects.get(i);
//			if (tempObject.objectType==ObjectType.Player) {
//				if (key== KeyEvent.VK_UP) {keyDown[0]=false;} 
//				if (key== KeyEvent.VK_DOWN) {keyDown[1]=false;}
//				if (key== KeyEvent.VK_RIGHT) {keyDown[2]=false;}
//				if (key== KeyEvent.VK_LEFT) {keyDown[3]=false;}
//				
//				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0f);
//				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0f);
//				
//			}

    }

}
