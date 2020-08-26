package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class MainClass extends ApplicationAdapter {
	SpriteBatch batch;
	static final int DUCKS_COUNT = 15;
	Duck[] duck = new Duck[DUCKS_COUNT];
	Random rand = new Random();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Duck.setTexture(new Texture("duck.png"));
		for (int i = 0; i < DUCKS_COUNT; i++) {
			duck[i] = new Duck(new Vector2(rand.nextInt(800),rand.nextInt(600)), new Vector2(3.0f * (rand.nextFloat() - 0.5f), 3.0f * (rand.nextFloat() - 0.5f)));
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 191, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		for (int i = 0; i < DUCKS_COUNT; i++) {
			duck[i].render(batch);
		}

		batch.end();
	}

	public void update() {
		for (int i = 0; i < DUCKS_COUNT; i++) {
			duck[i].update();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (int i = 0; i < DUCKS_COUNT; i++) {
			duck[i].dispose();
		}
	}
}
