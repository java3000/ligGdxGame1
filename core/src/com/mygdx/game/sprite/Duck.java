package com.mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Duck {
    private  Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;

    public Duck() {
        this.position = new Vector2(0,0);
        this.velocity = new Vector2(2.0f,2.0f);
        this.texture = new Texture("duck.png");
        bounds = new Rectangle(position.x,position.y, texture.getWidth(),texture.getHeight());
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture,position.x - texture.getWidth()/2, position.y - texture.getHeight()/2);
    }

    public void dispose() {
        texture.dispose();
    }

    public void update() {
        position.add(velocity);
        if (position.x < -texture.getWidth()) position.x = Gdx.graphics.getWidth();
        if (position.y < -texture.getHeight()) position.y = Gdx.graphics.getHeight();
        if (position.x > Gdx.graphics.getWidth()) position.x = -texture.getWidth();
        if (position.y > Gdx.graphics.getHeight()) position.y = -texture.getHeight();
    }

    public boolean collide(Rectangle player) {
        return bounds.overlaps(player);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
