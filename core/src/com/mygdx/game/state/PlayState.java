package com.mygdx.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.InputHandler;
import com.mygdx.game.sprite.Duck;

import java.util.Random;

public class PlayState extends AbstractState {
    private BitmapFont font;
    private Texture sight;
    private Texture fon;
    private Texture gras;
    private int score;
    private final int DUCKS_COUNT = 5;
    private Duck[] ducks;
    private Rectangle bounds;
    private Random rand;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        fon = new Texture("fon.png");
        sight = new Texture("sight.png");
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"),false);
        gras = new Texture("gras.png");
        score = 0;
        ducks = new Duck[DUCKS_COUNT];
        rand = new Random();
        for (int i = 0; i < DUCKS_COUNT; i++) {
            ducks[i] = new Duck(new Vector2(rand.nextFloat(),rand.nextFloat()), new Vector2(rand.nextFloat(),rand.nextFloat()));
        }
    }

    @Override
    public void update(float delta) {
        for (int i = 0; i < DUCKS_COUNT; i++) {
            ducks[i].update();

        }

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(fon,0,0);
        for (int i = 0; i < DUCKS_COUNT; i++) {
            ducks[i].render(batch);
        }
        font.draw(batch, "Scores: " + score, 10,Gdx.graphics.getHeight() - 20);
        batch.draw(gras,-50,-50);
        batch.draw(sight, InputHandler.getMousePosition().x - sight.getWidth()/2,InputHandler.getMousePosition().y - sight.getHeight()/2);
        batch.end();
    }

    @Override
    public void dispose() {
        fon.dispose();
        sight.dispose();
        for (int i = 0; i < DUCKS_COUNT; i++) {
            ducks[i].dispose();
        }
    }
}

