package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.Direction;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

import java.util.HashMap;
import java.util.Map;

public class BongoBob {
    public Rectangle frame;

    public float ringStateTime;
    public Map<Direction, TextureRegion> bodyTextures;
    public TextureRegion face;

    public Animation<TextureRegion> ringAnimation;

    public Direction direction;
    public float velocity;

    public Sound robotSound;
    public boolean robotMakesSound;

    public BongoBob() {
        ringStateTime = 0;

        float ringFrameDuration = 0.03f;

        ringAnimation = new Animation<TextureRegion>(
                ringFrameDuration,
                MicroMacroAssets.getInstance().atlas.findRegions("BongoBob/Ring/ring"),
                Animation.PlayMode.LOOP
        );

        face = MicroMacroAssets.getInstance().atlas.findRegion("BongoBob/Face/cool");

        bodyTextures = new HashMap<>();

        bodyTextures.put(Direction.UP, MicroMacroAssets.getInstance().atlas.findRegion("BongoBob/Body/back"));
        bodyTextures.put(Direction.DOWN, MicroMacroAssets.getInstance().atlas.findRegion("BongoBob/Body/front"));
        bodyTextures.put(Direction.LEFT, MicroMacroAssets.getInstance().atlas.findRegion("BongoBob/Body/side"));

        TextureRegion flippedSide = new TextureRegion(
                MicroMacroAssets.getInstance().atlas.findRegion("BongoBob/Body/side")
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

        velocity = 300;
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
