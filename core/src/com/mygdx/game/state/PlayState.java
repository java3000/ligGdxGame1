package com.mygdx.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.InputHandler;
import com.mygdx.game.sprite.Duck;

public class PlayState extends AbstractState {
    private BitmapFont font;
    private Texture sight;
    private Texture fon;
    private int score;
    private final int DUCKS_COUNT = 5;
    private Duck[] ducks;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        fon = new Texture("fon.png");
        sight = new Texture("sight_red.png");
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"),false);
        score = 0;
        ducks = new Duck[DUCKS_COUNT];
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(fon,0,0);
        font.draw(batch, "Scores: " + score, 10,Gdx.graphics.getHeight() - 20);
        batch.draw(sight, InputHandler.getMousePosition().x - sight.getWidth()/2,InputHandler.getMousePosition().y - sight.getHeight()/2);
        batch.end();
    }

    @Override
    public void dispose() {
        fon.dispose();
        sight.dispose();
    }
}
