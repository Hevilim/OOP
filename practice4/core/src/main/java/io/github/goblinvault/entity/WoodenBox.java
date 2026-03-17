package io.github.goblinvault.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class WoodenBox extends GameObject implements Pushable {
    private ShapeRenderer shape;

    public WoodenBox(float x, float y) {
        super(x, y, 40, 40);
        shape = new ShapeRenderer();
    }

    @Override
    public void push(float dx, float dy) {
        x += dx * 2f;
        y += dy * 2f;
    }

    @Override
    public void update(float delta) {}

    @Override
    public void render(SpriteBatch batch) {
        if (!active) return;
        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BROWN);
        shape.rect(x, y, width, height);
        shape.end();

        batch.begin();
    }

    @Override
    public void dispose() { shape.dispose(); }
}
