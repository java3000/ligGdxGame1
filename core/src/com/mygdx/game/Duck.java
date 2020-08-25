package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Duck {
    private Vector2 position;
    private Vector2 velocity;
    private int width;
    private int height;

    public Duck(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        this.width = 80;
        this.height = 100;
    }

    public void update() {}
}
