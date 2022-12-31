package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

public class ClosedPhone {
    public TextureRegion texture;
    public Rectangle frame;
    public float margin;

    public ClosedPhone(MicroMacroAssets assets) {
        margin = 10;

        this.texture = assets.atlas.findRegion("Phone/closed");

        frame = new Rectangle(
                Gdx.graphics.getWidth() - texture.getRegionWidth() - margin,
                margin,
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );
    }

    public void dispose() {
    }
}
