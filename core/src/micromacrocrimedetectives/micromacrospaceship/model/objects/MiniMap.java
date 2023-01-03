package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

public class MiniMap {
    public final float hintSize = 40;

    public TextureRegion background;
    public TextureRegion bongoBob;

    public Vector2 position;
    public Vector2 bongoBobPosition;
    public Vector2 hintPosition;

    public float margin;

    public Animation<TextureRegion> hintAnimation;
    public float hintAnimationStateTime;

    public MiniMap(MicroMacroAssets assets) {
        TextureAtlas atlas = assets.atlas;

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

        hintPosition = new Vector2();

        float hintAnimationFrameDuration = 0.5f;

        hintAnimation = new Animation<TextureRegion>(
                hintAnimationFrameDuration,
                assets.atlas.findRegions("MiniMap/Hint/hint"),
                Animation.PlayMode.LOOP_REVERSED
        );

        hintAnimationStateTime = 0;
    }

    public void dispose() {
    }
}
