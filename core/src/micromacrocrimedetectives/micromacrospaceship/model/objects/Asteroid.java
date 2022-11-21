package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Asteroid {
    public final Texture texture;
    public final TextureRegion textureRegion;
    public final Rectangle frame;

    public float originX, originY;
    public final float velocity;

    public float rotation;
    public final float rotationVelocity;

    public final boolean rotateClockwise;

    public Asteroid(int spawnPosition) {
        texture = new Texture("asteroid.png");
        textureRegion = new TextureRegion(texture);

        frame = new Rectangle(
                spawnPosition * texture.getWidth(),
                Gdx.graphics.getHeight(),
                texture.getWidth(),
                texture.getHeight()
        );

        originX = frame.width / 2;
        originY = frame.height / 2;

        velocity = 200;
        rotation = (int) (Math.random() * 360);
        rotationVelocity = (int) (Math.random() * 50) + 50;

        rotateClockwise = rotation % 2 == 0;
    }
}
