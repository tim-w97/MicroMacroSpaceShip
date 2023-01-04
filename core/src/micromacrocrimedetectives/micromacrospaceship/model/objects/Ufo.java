package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Ufo {
    public final Texture texture = new Texture("images/spaceship-game/ufo.png");

    public final ArrayList<FriendlyBullet> bullets;
    public final Rectangle frame;
    public final float velocity;

    public static float bottomMargin = 20;

    public Sound laserSound;
    public Sound crumbleSound;

    public long lastShootTime;
    public final int shootDelay;

    public Ufo() {
        bullets = new ArrayList<>();

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - texture.getWidth()) / 2f,
                bottomMargin,
                texture.getWidth(),
                texture.getHeight()
        );

        velocity = 300;

        laserSound = Gdx.audio.newSound(Gdx.files.internal("sounds/pop.mp3"));
        crumbleSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));

        shootDelay = 400;
    }

    public void dispose() {
        crumbleSound.dispose();
        laserSound.dispose();

        for (FriendlyBullet friendlyBullet : bullets) {
            friendlyBullet.dispose();
        }
    }
}
