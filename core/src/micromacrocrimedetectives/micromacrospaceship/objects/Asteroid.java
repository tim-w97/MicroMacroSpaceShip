package micromacrocrimedetectives.micromacrospaceship.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Asteroid {
    private final Texture texture;
    public final Rectangle frame;

    private float rotation;

    public Asteroid() {
        texture = new Texture("asteroid.png");

        frame = new Rectangle();
        frame.width = texture.getWidth();
        frame.height = texture.getHeight();
        frame.x = 64;
        frame.y = 300;
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

    public void rotate(float delta) {
        rotation += delta * 64;

        if (rotation == 360) {
            rotation = 0;
        }
    }
}
