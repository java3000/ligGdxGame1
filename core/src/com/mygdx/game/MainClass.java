package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x = 0.0f;
	float y = 0.0f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("duck.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(img, x, y);
		batch.end();
	}

	public void update() {
		x++;
		y++;
		if (x > Gdx.graphics.getWidth()) x = -40;
		if (y > Gdx.graphics.getHeight()) y = -40;
		if (x < -img.getWidth()) x = Gdx.graphics.getWidth();
		if (y < -img.getWidth()) y = Gdx.graphics.getHeight();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
