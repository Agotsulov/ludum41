package com.lde;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.lde.helper.Pair;
import com.lde.tests.TestScene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byzilio on 20.04.18.
 */

public class MainScreen implements Screen {

    public static Camera camera;

    public static Scene scene;

    @Override
    public void show() {
        camera = new Camera();

        scene = new TestScene();
        scene.init();
        scene.resize();
        for(int i = 0;i < scene.size();i++)
            scene.get(i).start();

        //Gdx.input.setInputProcessor(touchListener);
    }

    @Override
    public void render(float delta) {
        update();
        draw();
    }

    public void update(){
        List<Pair<GameObject,GameObject>> encountered = new ArrayList<Pair<GameObject, GameObject>>();

        for(int i = 0; i < scene.size(); i++)
            if(scene.get(i).isAlive)
                scene.get(i).fixedUpdate();


        for(int i = 0; i < scene.size(); i++)
            if(scene.get(i).isAlive)
                scene.get(i).moveX();



        for(int j = 0;j < scene.collide.size();j++) {
            GameObject f = scene.collide.get(j).getFirst();
            GameObject s = scene.collide.get(j).getSecond();
            if(f.overlaps(s) ){
                encountered.add(new Pair<GameObject,GameObject>(f, s));
                f.repelX(s);
            }
        }


        for(int i = 0; i < scene.size(); i++)
            if(scene.get(i).isAlive)
                scene.get(i).moveY();


        for(int j = 0;j < scene.collide.size(); j++) {
            GameObject f = scene.collide.get(j).getFirst();
            GameObject s = scene.collide.get(j).getSecond();
            if(f.overlaps(s)){
                encountered.add(new Pair<GameObject,GameObject>(f, s));
                f.repelY(s);
            }
        }


        for(int j = 0;j < scene.overlap.size();j++) {
            GameObject f = scene.overlap.get(j).getFirst();
            GameObject s = scene.overlap.get(j).getSecond();
            if(f.overlaps(s) && f.isAlive && s.isAlive)
                encountered.add(new Pair<GameObject,GameObject>(f, s));
        }

        for(int i = 0; i < scene.size(); i++)
            if(scene.get(i).isAlive) scene.get(i).update();

        for(int i = 0; i < encountered.size(); i++){
            encountered.get(i).getFirst().collide(encountered.get(i).getSecond());
            encountered.get(i).getSecond().collide(encountered.get(i).getFirst());
        }

    }



    public void draw() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.begin();
        camera.render(scene);
        camera.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose () {
        scene.dispose();
        camera.dispose();
    }


}
