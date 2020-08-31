package com.mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.state.PlayState;

public class Duck {
    private  Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;
    private boolean isKilled;

    float time;
    private final int WIDTH = 256;
    private final int HEIGHT = 256;

    public Duck(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        this.texture = new Texture("duck_4.png");
        bounds = new Rectangle(position.x,position.y, WIDTH,HEIGHT);
    }

    public void render(SpriteBatch batch) {
        int frame = (int) (time / 0.1f);
        frame = frame % 2;
        if (!isKilled) {
            batch.draw(texture, position.x, position.y, frame * WIDTH, 0, WIDTH, HEIGHT);
        } else {
            batch.draw(texture,position.x,position.y,texture.getWidth()/2,texture.getHeight()/2,texture.getWidth(),texture.getHeight(),1,1,40,0,0,64,64,false,false);
        }
    }

    public void dispose() {
        texture.dispose();
    }

    public void update(float delta) {
        time+= delta;
        position.add(velocity);
        if (position.x < -texture.getWidth()) position.x = Gdx.graphics.getWidth();
        if (position.y < -texture.getHeight()) position.y = Gdx.graphics.getHeight();
        if (position.x > Gdx.graphics.getWidth()) position.x = -texture.getWidth();
        if (position.y > Gdx.graphics.getHeight()) position.y = -texture.getHeight();
        velocity.x += 0.5f * delta;
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

    public Rectangle getBounds() {
        return bounds;
    }
}
