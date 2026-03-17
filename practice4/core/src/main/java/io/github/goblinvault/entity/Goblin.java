package io.github.goblinvault.entity;

import java.util.List;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Goblin extends GameObject implements Attackable {
    private static final float SPEED = 60f;
    private static final float SIZE  = 64f;

    private int hp = 100;
    private Texture texture;
    private Sprite  sprite;
    private Knight target;
    private List<GameObject> obstacles;

    public Goblin(float x, float y, Knight target, List<GameObject> obstacles) {
        super(x, y, SIZE, SIZE);
        this.target = target;
        this.obstacles = obstacles;
        texture = new Texture("goblin.gif");
        sprite  = new Sprite(texture);
        sprite.setSize(SIZE, SIZE);
        sprite.setPosition(x, y);
    }

    @Override
    public void update(float delta) {
        if (!active) return;

        float dx = target.getX() - x;
        float dy = target.getY() - y;
        float len = (float) Math.sqrt(dx * dx + dy * dy);
        if (len <= 1f) return;

        if (dx < 0)      sprite.setFlip(true,  false);
        else if (dx > 0) sprite.setFlip(false, false);

        x += (dx / len) * SPEED * delta;
        y += (dy / len) * SPEED * delta;

        for (int iter = 0; iter < 3; iter++) {
            if (!resolveCollisions()) break;
        }

        sprite.setPosition(x, y);
    }

    private boolean resolveCollisions() {
        boolean any = false;
        for (GameObject obj : obstacles) {
            if (!obj.isActive()) continue;

            if (obj instanceof Rock) {
                Circle rock = ((Rock) obj).getCircle();
                Rectangle me = getBounds();
                if (!Intersector.overlaps(rock, me)) continue;

                any = true;
                float cx = rock.x, cy = rock.y;
                float mx = me.x + me.width / 2f, my = me.y + me.height / 2f;
                float ndx = mx - cx, ndy = my - cy;
                float dist = (float) Math.sqrt(ndx * ndx + ndy * ndy);
                if (dist < 0.01f) { x += 1; continue; }
                float overlap = (rock.radius + me.width / 2f) - dist;
                x += (ndx / dist) * overlap;
                y += (ndy / dist) * overlap;
            } else {
                Rectangle a = getBounds();
                Rectangle b = obj.getBounds();
                if (!a.overlaps(b)) continue;

                any = true;
                float overlapX = Math.min(a.x + a.width,  b.x + b.width)  - Math.max(a.x, b.x);
                float overlapY = Math.min(a.y + a.height, b.y + b.height) - Math.max(a.y, b.y);

                if (overlapX < overlapY) {
                    if (a.x < b.x) x -= overlapX; else x += overlapX;
                } else {
                    if (a.y < b.y) y -= overlapY; else y += overlapY;
                }
            }
        }
        return any;
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!active) return;
        sprite.draw(batch);
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) active = false;
    }

    @Override
    public boolean isAlive() { return hp > 0; }

    @Override
    public void dispose() { texture.dispose(); }
}