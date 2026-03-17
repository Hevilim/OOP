package io.github.goblinvault.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Chest extends GameObject implements Interactable {
    private boolean opened = false;
    private ShapeRenderer shape;

    public Chest(float x, float y) {
        super(x, y, 60, 60);
        shape = new ShapeRenderer();
    }

    @Override
    public void interact() {
        opened = true;
    }

    public boolean isOpened() { return opened; }

    @Override
    public void update(float delta) {}

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(opened ? Color.YELLOW : Color.GOLD);
        shape.rect(x, y, width, height);
        shape.setColor(Color.DARK_GRAY);
        if (!opened) shape.rect(x + 22, y + 15, 16, 16);
        shape.end();
        batch.begin();
    }

    @Override
    public void dispose() { shape.dispose(); }
}