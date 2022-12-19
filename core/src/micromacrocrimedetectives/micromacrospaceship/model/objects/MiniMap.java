package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

public class MiniMap {
    public TextureRegion background;
    public TextureRegion bongoBob;

    public Vector2 position;
    public Vector2 bongoBobPosition;

    public float margin;

    public MiniMap() {
        TextureAtlas atlas = MicroMacroAssets.getInstance().atlas;

        margin = 10;

        background = atlas.findRegion("MiniMap/background");
        bongoBob = atlas.findRegion("MiniMap/bongoBob");

        position = new Vector2(
                margin,
                Gdx.graphics.getHeight() - background.getRegionHeight() - margin
        );

        bongoBobPosition = new Vector2(
                10,
                Gdx.graphics.getHeight() - 10 - background.getRegionHeight()
        );
    }

    public void dispose() {
    }
}
