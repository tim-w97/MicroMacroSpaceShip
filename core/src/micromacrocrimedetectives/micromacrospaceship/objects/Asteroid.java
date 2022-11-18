package micromacrocrimedetectives.micromacrospaceship.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Asteroid {
    private final Texture texture;
    public final Rectangle frame;

    private float rotation;
    private float rotationVelocity;
    private float velocity;

    public Asteroid(float x) {
        texture = new Texture("asteroid.png");

        frame = new Rectangle();
        frame.width = texture.getWidth();
        frame.height = texture.getHeight();
        frame.x = x;
        frame.y = Gdx.graphics.getHeight();

        rotation = (float) (360 * Math.random());
        rotationVelocity = (float) Math.random() * 200;

        velocity = 200 + (float) Math.random() * 100;
    }

    public void draw(SpriteBatch batch) {
        // SpriteBatch.draw(textureRegion, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
        batch.draw(
                new TextureRegion(texture),
                frame.x,
                frame.y,
                frame.width / 2f,
                frame.height / 2f,
                frame.width,
                frame.height,
                1,
                1,
                rotation
        );
    }

    public void moveAndRotate(float delta) {
        frame.y -= delta * velocity;

        rotation += delta * rotationVelocity;

        if (rotation == 360) {
            rotation = 0;
        }
    }

    public boolean ifOffScreen() {
        return frame.y < -frame.height;
    }
}
