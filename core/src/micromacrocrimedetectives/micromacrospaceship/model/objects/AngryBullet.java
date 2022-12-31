package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

public class AngryBullet {
    public Rectangle frame;
    public AtlasRegion texture;
    public float velocity;

    public AngryBullet(MicroMacroAssets assets) {
        texture = assets.atlas.findRegion("Bullet/angry");

        frame = new Rectangle();

        frame.setWidth(texture.getRegionWidth());
        frame.setHeight(texture.getRegionHeight());

        velocity = 200;
    }

    public void dispose() {
    }
}
