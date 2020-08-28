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
    private boolean isKilled;

    public Duck(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        this.texture = new Texture("duck.png");
        bounds = new Rectangle(position.x,position.y, texture.getWidth(),texture.getHeight());
    }

    public void render(SpriteBatch batch) {
        if (!isKilled) {
            batch.draw(texture, position.x, position.y);
        } else {
            batch.draw(texture,position.x,position.y,texture.getWidth()/2,texture.getHeight()/2,texture.getWidth(),texture.getHeight(),1,1,40,0,0,64,64,false,false);
        }
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

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}
