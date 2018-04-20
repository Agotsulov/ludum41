package com.lde;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LDE extends Game {

	public static final int WIDTH = 1024;
	public static final int HEIGHT = 512;

	private Screen screen;

	public LDE(){
		screen = new MainScreen();
	}

	@Override
	public void create() {
		setScreen(screen);
	}

	@Override
	public void render(){
		super.render();
	}

	@Override
	public void dispose(){
		screen.dispose();
	}
}
