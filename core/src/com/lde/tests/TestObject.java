package com.lde.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lde.GameObject;

/**
 * Created by byzilio on 20.04.18.
 */

public class TestObject extends GameObject{

    private Texture texture;



    public TestObject(int x,int y){
        texture = new Texture("badlogic.jpg");
        this.x = x;
        this.y = y;
        this.height = 50;
        this.width = 100;
        a.add(3,4);
    }

    @Override
    public void start() {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture,x,y,width,height);
    }

    @Override
    public void collide(GameObject another) {

    }
}
