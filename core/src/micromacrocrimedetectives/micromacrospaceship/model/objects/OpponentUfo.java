package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

public class OpponentUfo implements Disposable {
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

    @Override
    public void dispose() {
        texture.getTexture().dispose();
    }
}
