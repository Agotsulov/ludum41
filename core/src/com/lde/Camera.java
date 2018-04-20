package com.lde;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by byzilio on 02.12.17.
 */

public class Camera extends SpriteBatch {

    private float x,y;

    public float scale = Math.min(
            (float) Gdx.graphics.getWidth()/LDE.WIDTH,
            (float) Gdx.graphics.getHeight()/LDE.HEIGHT
    );

    public Camera(){
        x = 0;
        y = 0;
    }

    public Camera(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void draw(Texture texture, float x, float y, float width, float height){
        super.draw(texture, ((x - this.x) ), (int) ((y - this.y) ),width,height );
    }

    public void render(Scene scene){
        for (int j = 0; j < 10; j++)
            for (int i = 0; i < scene.layers[j].size(); i++)
                if(scene.layers[j].get(i).isVisible)
                    scene.layers[j].get(i).draw(this);
    }

    public void move(int x,int y){
        this.x += x;
        this.y += y;
    }


    public void move(Vector2 v){
        this.x += v.x;
        this.y += v.y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getScale() {
        scale = Math.min(
                (float) Gdx.graphics.getWidth()/LDE.WIDTH,
                (float) Gdx.graphics.getHeight()/LDE.HEIGHT
        );
        return scale;
    }
}
