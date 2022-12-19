package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

public class Asteroid {
    public final AtlasRegion texture;
    public final Rectangle frame;

    public float originX, originY;
    public final float velocity;

    public float rotation;
    public final float rotationVelocity;

    public final boolean rotateClockwise;

    public Asteroid(int spawnPosition) {
        texture = MicroMacroAssets.getInstance().atlas.findRegion("asteroid");

        frame = new Rectangle(
                spawnPosition * texture.getRegionWidth(),
                Gdx.graphics.getHeight(),
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );

        originX = frame.width / 2;
        originY = frame.height / 2;

        velocity = 200;
        rotation = (int) (Math.random() * 360);
        rotationVelocity = (int) (Math.random() * 50) + 50;

        rotateClockwise = rotation % 2 == 0;
    }

    public void dispose() {
    }
}
