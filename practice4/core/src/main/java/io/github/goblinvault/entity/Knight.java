package io.github.goblinvault.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Knight extends GameObject {
    private static final float SPEED = 90f;
    private static final float SIZE  = 64f;

    private Texture texture;
    private Sprite  sprite;

    private float lastDx = 0, lastDy = 0;

    public Knight(float x, float y) {
        super(x, y, SIZE, SIZE);
        texture = new Texture("knight.png");
        sprite  = new Sprite(texture);
        sprite.setSize(SIZE, SIZE);
    }

    @Override
    public void update(float delta) {
        lastDx = 0;
        lastDy = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) lastDy =  SPEED * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) lastDy = -SPEED * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) lastDx = -SPEED * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) lastDx =  SPEED * delta;

        if (lastDx < 0)      sprite.setFlip(true,  false);
        else if (lastDx > 0) sprite.setFlip(false, false);

        x += lastDx;
        y += lastDy;

        x = Math.max(0, Math.min(x, Gdx.graphics.getWidth()  - width));
        y = Math.max(0, Math.min(y, Gdx.graphics.getHeight() - height));

        sprite.setPosition(x, y);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public float getLastDx() { return lastDx; }
    public float getLastDy() { return lastDy; }

    public void nudge(float dx, float dy) {
        x += dx;
        y += dy;
        sprite.setPosition(x, y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}