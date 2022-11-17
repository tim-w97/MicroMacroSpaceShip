package micromacrocrimedetectives.micromacrospaceship.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    public final Rectangle frame;

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
}
