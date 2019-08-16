package com.mygdx.game.states;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ChatBird;

public class MenuState extends State {

    private Texture background;
    private Texture playButtom;
    //Constructor
    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bg.png");
        playButtom = new Texture("playbtn.png");
    }

    //State Class Methods
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background,0,0, ChatBird.WIDTH, ChatBird.HEIGTH);
        spriteBatch.draw(playButtom, (ChatBird.WIDTH/2) - (playButtom.getWidth()/2),(ChatBird.HEIGTH/2)-(playButtom.getHeight()/2));
        spriteBatch.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playButtom.dispose();
        System.out.println("MENU STATE DISPOSED");
    }

}
