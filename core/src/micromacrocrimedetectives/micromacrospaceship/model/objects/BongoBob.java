package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.Direction;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

import java.util.HashMap;
import java.util.Map;

public class BongoBob {
    public final float defaultVelocity = 300;
    public final float turboVelocity = 1200;

    public Rectangle frame;

    public Map<Direction, TextureRegion> bodyTextures;
    public TextureRegion face;

    public Animation<TextureRegion> ringAnimation;
    public float ringAnimationStateTime;

    public Direction direction;
    public float velocity;

    public Sound robotSound;
    public boolean robotMakesSound;

    public BongoBob(MicroMacroAssets assets) {
        ringAnimationStateTime = 0;

        float ringFrameDuration = 0.03f;

        ringAnimation = new Animation<TextureRegion>(
                ringFrameDuration,
                assets.atlas.findRegions("BongoBob/Ring/ring"),
                Animation.PlayMode.LOOP
        );

        face = assets.atlas.findRegion("BongoBob/Face/cool");

        bodyTextures = new HashMap<>();

        bodyTextures.put(Direction.UP, assets.atlas.findRegion("BongoBob/Body/back"));
        bodyTextures.put(Direction.DOWN, assets.atlas.findRegion("BongoBob/Body/front"));
        bodyTextures.put(Direction.LEFT, assets.atlas.findRegion("BongoBob/Body/side"));

        TextureRegion flippedSide = new TextureRegion(
                assets.atlas.findRegion("BongoBob/Body/side")
        );

        flippedSide.flip(true, false);

        bodyTextures.put(Direction.RIGHT, flippedSide);

        TextureRegion misusedTextureRegion = bodyTextures.get(Direction.DOWN);

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - misusedTextureRegion.getRegionWidth()) / 2f,
                (Gdx.graphics.getHeight() - misusedTextureRegion.getRegionHeight()) / 2f,
                misusedTextureRegion.getRegionWidth(),
                misusedTextureRegion.getRegionHeight()
        );

        velocity = defaultVelocity;
        direction = Direction.DOWN;

        robotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/robot sounds.mp3"));
        robotSound.loop();
        robotSound.pause();

        robotMakesSound = false;
    }

    public void dispose() {
        robotSound.dispose();
    }
}
