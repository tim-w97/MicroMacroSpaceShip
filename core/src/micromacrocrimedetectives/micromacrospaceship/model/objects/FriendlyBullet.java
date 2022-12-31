package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

public class FriendlyBullet {
    public Rectangle frame;
    public AtlasRegion texture;
    public float velocity;

    public FriendlyBullet(MicroMacroAssets assets) {
        texture = assets.atlas.findRegion("Bullet/friendly");

        frame = new Rectangle();

        frame.setWidth(texture.getRegionWidth());
        frame.setHeight(texture.getRegionHeight());

        velocity = 200;
    }

    public void dispose() {
    }
}
