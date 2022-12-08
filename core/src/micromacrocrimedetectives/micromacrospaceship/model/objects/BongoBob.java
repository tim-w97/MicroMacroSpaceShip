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

    public float ringStateTime;
    public Map<Direction, TextureRegion> bodyTextures;
    public TextureRegion face;

    public Animation<TextureRegion> ringAnimation;

    public Direction direction;
    public float velocity;

    public BongoBob(TextureAtlas atlas) {
        ringStateTime = 0;

        float ringFrameDuration = 0.03f;

        ringAnimation = new Animation<TextureRegion>(
                ringFrameDuration,
                atlas.findRegions("bongoBob/ring/ring"),
                Animation.PlayMode.LOOP
        );

        face = atlas.findRegion("bongoBob/face/cool");

        bodyTextures = new HashMap<>();

        bodyTextures.put(Direction.UP, atlas.findRegion("bongoBob/body/back"));
        bodyTextures.put(Direction.DOWN, atlas.findRegion("bongoBob/body/front"));
        bodyTextures.put(Direction.LEFT, atlas.findRegion("bongoBob/body/side"));

        TextureRegion flippedSide = new TextureRegion(atlas.findRegion("bongoBob/body/side"));
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
    }
}
