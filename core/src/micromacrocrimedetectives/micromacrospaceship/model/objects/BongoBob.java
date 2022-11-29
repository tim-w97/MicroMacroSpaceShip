package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.Direction;

import java.util.HashMap;
import java.util.Map;

public class BongoBob {
    public Rectangle frame;

    public float ringStateTime;

    public TextureAtlas atlas;
    public Map<Direction, TextureRegion> bodyTextures;
    public Animation<TextureRegion> faceAnimation;

    public Animation<TextureRegion> ringAnimation;

    public Direction direction;
    public float velocity;

    public BongoBob() {
        ringStateTime = 0;

        atlas = new TextureAtlas("BongoBob/BongoBob.atlas");

        float ringFrameDuration = 0.03f;
        float faceFrameDuration = 5f;

        ringAnimation = new Animation<TextureRegion>(
                ringFrameDuration,
                atlas.findRegions("ring"),
                Animation.PlayMode.LOOP
        );

        faceAnimation = new Animation<TextureRegion>(
                faceFrameDuration,
                atlas.findRegions("face"),
                Animation.PlayMode.LOOP
        );

        bodyTextures = new HashMap<>();

        bodyTextures.put(Direction.UP, atlas.findRegion("body/back"));
        bodyTextures.put(Direction.DOWN, atlas.findRegion("body/front"));
        bodyTextures.put(Direction.LEFT, atlas.findRegion("body/side"));

        TextureRegion flippedSide = new TextureRegion(atlas.findRegion("body/side"));
        flippedSide.flip(true, false);

        bodyTextures.put(Direction.RIGHT, flippedSide);

        TextureRegion misusedTextureRegion = bodyTextures.get(Direction.DOWN);

        frame = new Rectangle(
                -misusedTextureRegion.getRegionWidth() / 2f,
                -misusedTextureRegion.getRegionHeight() / 2f,
                misusedTextureRegion.getRegionWidth(),
                misusedTextureRegion.getRegionHeight()
        );

        velocity = 300;
        direction = Direction.DOWN;
    }
}
