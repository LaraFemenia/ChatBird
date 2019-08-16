package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 90;
    private static final int LOWEST_OPENING = 120;
    public static final int TUBE_WIDTH = 52;

    private Texture bottomTube;
    private Texture topTube;

    private Vector2 posTopTube;
    private Vector2 posBotTube;

    private Random random;

    private Rectangle boundsTop;
    private Rectangle boundsBot;

    public Tube(float x){

        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");

        random = new Random();

        posTopTube = new Vector2(x,random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle(getPosTopTube().x,getPosTopTube().y,topTube.getWidth(),topTube.getHeight());
        boundsBot = new Rectangle(getPosBotTube().x,getPosBotTube().y,bottomTube.getWidth(),bottomTube.getHeight());

    }

    public void reposition(float x){
        posTopTube.set(x,random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
    }

    public boolean collides (Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public void setBottomTube(Texture bottomTube) {
        this.bottomTube = bottomTube;
    }

    public Texture getTopTube() {
        return topTube;
    }

    public void setTopTube(Texture topTube) {
        this.topTube = topTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public void setPosTopTube(Vector2 posTopTube) {
        this.posTopTube = posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void setPosBotTube(Vector2 posBotTube) {
        this.posBotTube = posBotTube;
    }

    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}
