package com.mygdx.game.sprite;

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

    private float time;
    private final int WIDTH = 252;
    private final int HEIGHT = 256;

    public Duck(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        this.texture = new Texture("duck.png");
        bounds = new Rectangle(position.x,position.y, WIDTH,HEIGHT);
    }

    public void render(SpriteBatch batch) {
        int frame = (int) (time / 0.1f);
        frame = frame % 4;
        batch.draw(texture, position.x, position.y, frame * WIDTH, 0, WIDTH, HEIGHT);
    }

    public void dispose() {
        texture.dispose();
    }

    public void update(float delta) {
        time+= delta;
        position.add(velocity);
        velocity.x += 0.05f * delta;
        bounds.setPosition(position.x,position.y);
        if (isKilled) {
            position.y = -256;
        }
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

    public Rectangle getBounds() {
        return bounds;
    }
}
