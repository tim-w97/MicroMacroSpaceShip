package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

public class OpponentUfo {
    public Rectangle frame;

    public AtlasRegion texture;

    public float verticalVelocity;
    public float horizontalVelocity;

    public int lives;

    public OpponentUfo() {
        texture = MicroMacroAssets.getInstance().atlas.findRegion("opponentUfo");

        frame = new Rectangle(
                (float) (Math.random() * (Gdx.graphics.getWidth() - texture.getRegionWidth())),
                Gdx.graphics.getHeight(),
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );

        verticalVelocity = 60;
        horizontalVelocity = 80;

        lives = 3;
    }

    public void dispose() {
    }
}
