package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.state.GameStateManager;
import com.mygdx.game.state.MenuState;

import java.util.Random;

public class MainClass extends ApplicationAdapter {
	private GameStateManager gsm;
	private SpriteBatch batch;
	private BitmapFont font;
    private Texture sight;
	static final int DUCKS_COUNT = 2;
	Duck[] duck = new Duck[DUCKS_COUNT];
	Random rand = new Random();
	int scores;

	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		sight = new Texture("sight_red.png");
		font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"),false);
//        scores = 0;
//		for (int i = 0; i < DUCKS_COUNT; i++) {
//			duck[i] = new Duck(new Vector2(rand.nextInt(400),rand.nextInt(300)), new Vector2(3.0f * (rand.nextFloat() + 0.5f), 3.0f * (rand.nextFloat() + 0.5f)));
//			duck[i].setTexture(new Texture("duck.png"));
//		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		//update();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		//batch.begin();

//		for (int i = 0; i < DUCKS_COUNT; i++) {
//			duck[i].render(batch);
//			if (InputHandler.isPressed()) {
//                if (duck[i].getTexture().getHeight() == InputHandler.getMousePosition().y) scores++;
//            }
//		}
//		batch.draw(sight, InputHandler.getMousePosition().x - sight.getWidth()/2,InputHandler.getMousePosition().y - sight.getHeight()/2);
//        font.draw(batch, "Scores: " + scores, 50,50);
		//batch.end();
	}

	public void update() {
		for (int i = 0; i < DUCKS_COUNT; i++) {
			duck[i].update();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		for (int i = 0; i < DUCKS_COUNT; i++) {
//			duck[i].dispose();
//		}
	}
}
