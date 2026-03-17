package io.github.goblinvault.entity;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Rock extends GameObject implements Pushable {
    private ShapeRenderer shape;
    public static final float RADIUS = 22f;

    public Rock(float x, float y) {
        super(x, y, RADIUS * 2, RADIUS * 2);
        shape = new ShapeRenderer();
    }

    public Circle getCircle() {
        return new Circle(x + RADIUS, y + RADIUS, RADIUS);
    }

    @Override
    public void push(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update(float delta) {}

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.setColor(0.25f, 0.25f, 0.25f, 1f);
        shape.circle(x + RADIUS + 4, y + RADIUS - 4, RADIUS);

        shape.setColor(0.55f, 0.55f, 0.55f, 1f);
        shape.circle(x + RADIUS, y + RADIUS, RADIUS);

        shape.setColor(0.75f, 0.75f, 0.75f, 1f);
        shape.circle(x + RADIUS - 6, y + RADIUS + 7, RADIUS * 0.35f);

        shape.end();
        batch.begin();
    }

    @Override
    public void dispose() { shape.dispose(); }
}