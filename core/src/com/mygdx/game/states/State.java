package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    //Constructor
    protected State(GameStateManager gameStateManager){
        this.gsm= gameStateManager;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    //Loop Game
    protected abstract void handleInput ();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();

}
