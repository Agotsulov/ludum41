package com.lde.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.lde.GameObject;

import java.util.List;


public class TouchListener implements InputProcessor{

    public List<GameObject> inputs;
    Vector2 vector;
    int firstX;
    int firstY;

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        firstX=screenX;
        firstY=Gdx.graphics.getHeight()-screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {


     vector=new Vector2(screenX-firstX,Gdx.graphics.getHeight()-screenY-firstY);
     vector.setLength(vector.len()/30);
     Gdx.app.log("psina",""+vector.x+" "+vector.y);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
      return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
