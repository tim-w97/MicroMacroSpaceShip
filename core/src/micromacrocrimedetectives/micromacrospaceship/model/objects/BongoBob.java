package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.Direction;

import java.util.HashMap;
import java.util.Map;

public class BongoBob implements Disposable {
    public final float defaultVelocity = 300;
    public final float turboVelocity = 1200;

    public Rectangle frame;

    public Map<Direction, Texture> bodyTextures;
    public Texture face;

    public Animation<Texture> ringAnimation;
    public float ringAnimationStateTime;

    public Direction direction;
    public float velocity;

    public Sound robotSound;
    public boolean robotMakesSound;

    public BongoBob() {
        ringAnimationStateTime = 0;

        initRingAnimation();

        face = new Texture("images/micro-macro-game/bongo-bob/face/cool.png");

        bodyTextures = new HashMap<>();

        bodyTextures.put(Direction.UP, new Texture("images/micro-macro-game/bongo-bob/body/back.png"));
        bodyTextures.put(Direction.DOWN, new Texture("images/micro-macro-game/bongo-bob/body/front.png"));
        bodyTextures.put(Direction.LEFT, new Texture("images/micro-macro-game/bongo-bob/body/left-side.png"));
        bodyTextures.put(Direction.RIGHT, new Texture("images/micro-macro-game/bongo-bob/body/right-side.png"));

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - face.getWidth()) / 2f,
                (Gdx.graphics.getHeight() - face.getHeight()) / 2f,
                face.getWidth(),
                face.getHeight()
        );

        velocity = defaultVelocity;
        direction = Direction.DOWN;

        robotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/robot sounds.mp3"));
        robotSound.loop();
        robotSound.pause();

        robotMakesSound = false;
    }

    private void initRingAnimation() {
        float ringFrameDuration = 0.03f;

        Array<Texture> frames = new Array<>();

        for (int i = 1; i <= 8; i++) {
            frames.add(new Texture("images/micro-macro-game/bongo-bob/ring/ring_" + i + ".png"));
        }

        ringAnimation = new Animation<>(
                ringFrameDuration,
                frames,
                Animation.PlayMode.LOOP
        );
    }

    @Override
    public void dispose() {
        robotSound.dispose();
        face.dispose();

        for (Texture ring : ringAnimation.getKeyFrames()) {
            ring.dispose();
        }

        for (Texture bodyTexture : bodyTextures.values()) {
            bodyTexture.dispose();
        }
    }
}
