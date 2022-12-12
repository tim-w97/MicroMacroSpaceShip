package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Ufo {
    public final Texture texture;
    public final Rectangle frame;
    public final float velocity;

    public static float bottomMargin = 20;

    public Sound laserSound;
    public Sound crumbleSound;

    public Ufo() {
        texture = new Texture("ufo.png");

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - texture.getWidth()) / 2f,
                bottomMargin,
                texture.getWidth(),
                texture.getHeight()
        );

        velocity = 300;

        laserSound = Gdx.audio.newSound(Gdx.files.internal("sounds/pop.mp3"));
        crumbleSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
    }

    public void dispose() {
        texture.dispose();
        crumbleSound.dispose();
        laserSound.dispose();
    }
}
