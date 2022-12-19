package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

public class FriendlyBullet {
    public Rectangle frame;
    public AtlasRegion texture;
    public float velocity;

    public FriendlyBullet() {
        texture = MicroMacroAssets.getInstance().atlas.findRegion("friendlyBullet");

        frame = new Rectangle();

        frame.setWidth(texture.getRegionWidth());
        frame.setHeight(texture.getRegionHeight());

        velocity = 600;
    }

    public void dispose() {
    }
}
