package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.Direction;

import java.util.HashMap;
import java.util.Map;

public class BongoBob {
    public Rectangle frame;

    public TextureAtlas atlas;
    public Map<Direction, TextureRegion> bodyTextures;
    public TextureRegion face;
    public Animation<TextureRegion> ringAnimation;

    public Direction direction;
    public float velocity;

    public BongoBob() {
        atlas = new TextureAtlas("BongoBob/BongoBob.atlas");

        float frameDuration = 0.03f;

        ringAnimation = new Animation<TextureRegion>(
                frameDuration,
                atlas.findRegions("ring"),
                Animation.PlayMode.LOOP
        );

        bodyTextures = new HashMap<>();

        bodyTextures.put(Direction.UP, atlas.findRegion("body/back"));
        bodyTextures.put(Direction.DOWN, atlas.findRegion("body/front"));
        bodyTextures.put(Direction.LEFT, atlas.findRegion("body/side"));

        TextureRegion flippedSide = new TextureRegion(atlas.findRegion("body/side"));
        flippedSide.flip(true, false);

        bodyTextures.put(Direction.RIGHT, flippedSide);

        face = atlas.findRegion("face/cool");

        frame = new Rectangle(
                -face.getRegionWidth() / 2f,
                -face.getRegionHeight() / 2f,
                face.getRegionWidth(),
                face.getRegionHeight()
        );

        velocity = 300;
        direction = Direction.DOWN;
    }
}
