package com.mygdx.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.InputHandler;
import com.mygdx.game.Score;


public class GameOverState extends AbstractState {
    private Texture background;
    private BitmapFont font;
    private Rectangle rectangle;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("sky.jpg");
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"),false);
        rectangle = new Rectangle((Gdx.graphics.getWidth() / 2) - 90,(Gdx.graphics.getHeight() / 2) - 50,200,50);
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    private void handleInput() {
        if (InputHandler.isClicked()) {
            if (rectangle.contains(InputHandler.getMousePosition().x,InputHandler.getMousePosition().y)) {
                gsm.set(new PlayState(gsm));
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background,0,0);
        font.draw(batch, "Game over!", (Gdx.graphics.getWidth() / 2) - 90,Gdx.graphics.getHeight() / 2 + 100);
        font.draw(batch, "Scores: " + Score.getScores(), (Gdx.graphics.getWidth() / 2) - 90,Gdx.graphics.getHeight() / 2 + 50);
        font.draw(batch, "Start new game", (Gdx.graphics.getWidth() / 2) - 90,Gdx.graphics.getHeight() / 2);
        batch.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        font.dispose();
    }
}
