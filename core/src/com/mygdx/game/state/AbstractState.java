package com.mygdx.game.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractState {
    
    protected GameStateManager gsm;

    public AbstractState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
