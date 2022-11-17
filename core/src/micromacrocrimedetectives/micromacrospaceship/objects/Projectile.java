package micromacrocrimedetectives.micromacrospaceship.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    private final Rectangle frame;

    private final float size = 24;
    private final float velocity = 500;

    public Projectile(float x) {
        frame = new Rectangle();

        frame.width = size;
        frame.height = size;
        frame.x = x;
        frame.y = 80;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        //shapeRenderer.rect(frame.x, frame.y, frame.width, frame.height);
        shapeRenderer.circle(frame.x, frame.y, size / 2f);
    }

    public void move(float delta) {
        frame.y += velocity * delta;
    }

    public boolean ifOffScreen() {
        return frame.y > Gdx.graphics.getHeight();
    }

    public float getX() {
        return frame.x + frame.width / 2;
    }

    public float getY() {
        return frame.y + frame.height / 2;
    }

    public float getWidth() {
        return frame.width;
    }

    public float getHeight() {
        return frame.getHeight();
    }
}
