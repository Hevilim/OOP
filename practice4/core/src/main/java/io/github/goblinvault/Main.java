package io.github.goblinvault;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import io.github.goblinvault.entity.*;

public class Main implements ApplicationListener {

    private SpriteBatch batch;
    private BitmapFont font;

    private Knight knight;
    private Goblin goblin;
    private Chest chest;

    private List<WoodenBox>  boxes;
    private List<Rock>       rocks;
    private List<GameObject> allObstacles;
    private List<GameObject> pushables;

    private static final int   BOX_COUNT   = 4;
    private static final int   ROCK_COUNT  = 4;
    private static final float SAFE_RADIUS = 160f;
    private static final float OBJ_SIZE    = 50f;
    private static final int   MAX_TRIES   = 200;

    private enum GameState { PLAYING, WIN, LOSE }
    private GameState state = GameState.PLAYING;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font  = new BitmapFont();
        font.setColor(Color.WHITE);

        knight = new Knight(120, 510);
        chest  = new Chest(1720, 510);

        boxes        = new ArrayList<>();
        rocks        = new ArrayList<>();
        allObstacles = new ArrayList<>();
        pushables    = new ArrayList<>();

        List<Rectangle> occupied = new ArrayList<>();
        occupied.add(new Rectangle(120 - SAFE_RADIUS, 510 - SAFE_RADIUS, SAFE_RADIUS * 2, SAFE_RADIUS * 2));
        occupied.add(new Rectangle(1720 - SAFE_RADIUS, 510 - SAFE_RADIUS, SAFE_RADIUS * 2, SAFE_RADIUS * 2));
        occupied.add(new Rectangle(1050 - SAFE_RADIUS, 510 - SAFE_RADIUS, SAFE_RADIUS * 2, SAFE_RADIUS * 2));

        Random rng = new Random();

        for (int i = 0; i < BOX_COUNT; i++) {
            Rectangle rect = spawnRect(rng, occupied);
            if (rect == null) continue;
            WoodenBox b = new WoodenBox(rect.x, rect.y);
            boxes.add(b);
            allObstacles.add(b);
            pushables.add(b);
            occupied.add(rect);
        }

        for (int i = 0; i < ROCK_COUNT; i++) {
            Rectangle rect = spawnRect(rng, occupied);
            if (rect == null) continue;
            Rock r = new Rock(rect.x, rect.y);
            rocks.add(r);
            allObstacles.add(r);
            pushables.add(r);
            occupied.add(rect);
        }

        allObstacles.add(chest);
        goblin = new Goblin(1050, 510, knight, allObstacles);
    }

    private Rectangle spawnRect(Random rng, List<Rectangle> occupied) {
        for (int attempt = 0; attempt < MAX_TRIES; attempt++) {
            float x = 300 + rng.nextFloat() * 1200;
            float y =  80 + rng.nextFloat() *  900;
            Rectangle candidate = new Rectangle(x, y, OBJ_SIZE, OBJ_SIZE);
            boolean overlaps = false;
            for (Rectangle occ : occupied) {
                if (candidate.overlaps(occ)) { overlaps = true; break; }
            }
            if (!overlaps) return candidate;
        }
        return null;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.15f, 0.1f, 0.05f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float delta = Gdx.graphics.getDeltaTime();
        if (state == GameState.PLAYING) update(delta);

        batch.begin();
        for (WoodenBox b : boxes) b.render(batch);
        for (Rock r      : rocks) r.render(batch);
        chest.render(batch);
        goblin.render(batch);
        knight.render(batch);
        renderUI();
        batch.end();
    }

    private void update(float delta) {
        knight.update(delta);
        goblin.update(delta);

        Rectangle kb = knight.getBounds();

        for (WoodenBox b : boxes) {
            if (b.isActive() && kb.overlaps(b.getBounds())) {
                b.push(knight.getLastDx(), knight.getLastDy());
            }
        }

        for (Rock r : rocks) {
            Circle rc = r.getCircle();
            if (Intersector.overlaps(rc, kb)) {
                r.push(knight.getLastDx(), knight.getLastDy());
                float cx = rc.x, cy = rc.y;
                float mx = kb.x + kb.width / 2f, my = kb.y + kb.height / 2f;
                float ndx = mx - cx, ndy = my - cy;
                float dist = (float) Math.sqrt(ndx * ndx + ndy * ndy);
                if (dist > 0.01f) {
                    float overlap = (rc.radius + kb.width / 2f) - dist;
                    if (overlap > 0) knight.nudge((ndx / dist) * overlap, (ndy / dist) * overlap);
                }
            }
        }

        resolvePushableCollisions();

        if (expand(knight, 10).overlaps(chest.getBounds()) &&
            Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            chest.interact();
        }

        if (goblin.isActive() && knight.getBounds().overlaps(goblin.getBounds())) {
            state = GameState.LOSE;
        }

        if (chest.isOpened()) state = GameState.WIN;
    }

    private void resolvePushableCollisions() {
        for (int i = 0; i < pushables.size(); i++) {
            GameObject a = pushables.get(i);
            if (!a.isActive()) continue;
            for (int j = i + 1; j < pushables.size(); j++) {
                GameObject b = pushables.get(j);
                if (!b.isActive()) continue;

                boolean aIsRock = a instanceof Rock;
                boolean bIsRock = b instanceof Rock;

                if (aIsRock && bIsRock) {
                    Circle ca = ((Rock) a).getCircle();
                    Circle cb = ((Rock) b).getCircle();
                    float dx = cb.x - ca.x, dy = cb.y - ca.y;
                    float dist = (float) Math.sqrt(dx * dx + dy * dy);
                    float minDist = ca.radius + cb.radius;
                    if (dist < minDist && dist > 0.01f) {
                        float overlap = (minDist - dist) / 2f;
                        a.setPosition(a.getX() - (dx / dist) * overlap, a.getY() - (dy / dist) * overlap);
                        b.setPosition(b.getX() + (dx / dist) * overlap, b.getY() + (dy / dist) * overlap);
                    }
                } else if (aIsRock) {
                    resolveCircleRect((Rock) a, b, false);
                } else if (bIsRock) {
                    resolveCircleRect((Rock) b, a, true);
                } else {
                    Rectangle ra = a.getBounds(), rb = b.getBounds();
                    if (!ra.overlaps(rb)) continue;
                    float overlapX = Math.min(ra.x + ra.width,  rb.x + rb.width)  - Math.max(ra.x, rb.x);
                    float overlapY = Math.min(ra.y + ra.height, rb.y + rb.height) - Math.max(ra.y, rb.y);
                    float half;
                    if (overlapX < overlapY) {
                        half = overlapX / 2f;
                        if (ra.x < rb.x) { a.setPosition(a.getX() - half, a.getY()); b.setPosition(b.getX() + half, b.getY()); }
                        else             { a.setPosition(a.getX() + half, a.getY()); b.setPosition(b.getX() - half, b.getY()); }
                    } else {
                        half = overlapY / 2f;
                        if (ra.y < rb.y) { a.setPosition(a.getX(), a.getY() - half); b.setPosition(b.getX(), b.getY() + half); }
                        else             { a.setPosition(a.getX(), a.getY() + half); b.setPosition(b.getX(), b.getY() - half); }
                    }
                }
            }
        }
    }

    private void resolveCircleRect(Rock rock, GameObject rect, boolean invertPush) {
        Circle c = rock.getCircle();
        Rectangle r = rect.getBounds();
        if (!Intersector.overlaps(c, r)) return;

        float cx = c.x, cy = c.y;
        float rx = r.x + r.width / 2f, ry = r.y + r.height / 2f;
        float dx = rx - cx, dy = ry - cy;
        float dist = (float) Math.sqrt(dx * dx + dy * dy);
        if (dist < 0.01f) dist = 0.01f;
        float overlap = (c.radius + r.width / 2f - dist) / 2f;

        float px = (dx / dist) * overlap;
        float py = (dy / dist) * overlap;

        if (!invertPush) {
            rock.setPosition(rock.getX() - px, rock.getY() - py);
            rect.setPosition(rect.getX() + px, rect.getY() + py);
        } else {
            rect.setPosition(rect.getX() - px, rect.getY() - py);
            rock.setPosition(rock.getX() + px, rock.getY() + py);
        }
    }

    private Rectangle expand(Knight k, float margin) {
        return new Rectangle(k.getX() - margin, k.getY() - margin,
            k.getBounds().width + margin * 2, k.getBounds().height + margin * 2);
    }

    private void renderUI() {
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        switch (state) {
            case PLAYING:
                font.getData().setScale(1.8f);
                font.setColor(Color.WHITE);
                font.draw(batch, "WASD - move   O - open chest", 20, h - 20);
                break;
            case WIN:
                font.getData().setScale(4f);
                font.setColor(Color.GOLD);
                font.draw(batch, "YOU WIN!", w / 2f - 180, h / 2f + 60);
                font.getData().setScale(2f);
                font.setColor(Color.WHITE);
                checkRestart();
                break;
            case LOSE:
                font.getData().setScale(4f);
                font.setColor(Color.RED);
                font.draw(batch, "GAME OVER", w / 2f - 210, h / 2f + 60);
                font.getData().setScale(2f);
                font.setColor(Color.WHITE);
                checkRestart();
                break;
        }
    }

    private void checkRestart() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            disposeEntities();
            create();
            state = GameState.PLAYING;
        }
    }

    private void disposeEntities() {
        knight.dispose();
        goblin.dispose();
        chest.dispose();
        for (WoodenBox b : boxes) b.dispose();
        for (Rock r      : rocks) r.dispose();
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        disposeEntities();
    }
}