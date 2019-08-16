package com.mygdx.game.states;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ChatBird;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;


public class PlayState extends State {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bird bird;
    private Texture bg;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {

        super(gsm);
        bird = new Bird(50,320);
        camera.setToOrtho(false, ChatBird.WIDTH/2,ChatBird.HEIGTH/2);
        bg = new Texture("bg.png");
        tubes = new Array<Tube>();

        for (int i = 1; i<= TUBE_COUNT; i++){
            tubes.add(new Tube(i*(TUBE_SPACING+Tube.TUBE_WIDTH)));

        }


    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        camera.position.x = bird.getPosition().x + 80;

        for (int i=0; i<tubes.size;i++){

            Tube tube = tubes.get(i);

            if (camera.position.x - (camera.viewportWidth/2) > tube.getPosTopTube().x+tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH+ TUBE_SPACING) * TUBE_COUNT));
            }
            if (tube.collides(bird.getBounds())){
                gsm.set(new MenuState(gsm));
            }
        }
        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bg,camera.position.x-(camera.viewportWidth/2),camera.position.y-(camera.viewportHeight/2),ChatBird.WIDTH/2,ChatBird.HEIGTH/2);
        spriteBatch.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);
        for(Tube tube: tubes) {
           spriteBatch.draw(tube.getTopTube(),tube.getPosTopTube().x,tube.getPosTopTube().y);
           spriteBatch.draw(tube.getBottomTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        bird.dispose();
        for (Tube tube : tubes){
            tube.dispose();
            System.out.println("PLAYSTATE DISPOSE");
        }
    }
}
