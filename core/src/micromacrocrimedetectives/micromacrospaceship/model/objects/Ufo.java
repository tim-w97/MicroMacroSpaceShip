package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

public class Ufo implements Disposable {
    public final Texture threeLivesTexture = new Texture("images/spaceship-game/ufo/three-lives.png");
    public final Texture twoLivesTexture = new Texture("images/spaceship-game/ufo/two-lives.png");
    public final Texture oneLifeTexture = new Texture("images/spaceship-game/ufo/one-life.png");

    public int lives;

    public final ArrayList<FriendlyBullet> bullets;
    public final Rectangle frame;
    public final float velocity;

    public static float bottomMargin = 20;

    public Sound laserSound;
    public Sound crumbleSound;
    public Sound auaSound;

    public long lastShootTime;
    public final int shootDelay;

    public Ufo() {
        bullets = new ArrayList<>();

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - threeLivesTexture.getWidth()) / 2f,
                bottomMargin,
                threeLivesTexture.getWidth(),
                threeLivesTexture.getHeight()
        );

        velocity = 300;

        laserSound = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/pop.mp3"));
        crumbleSound = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/explosion.mp3"));
        auaSound = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/aua.mp3"));

        shootDelay = 400;
        lives = 3;
    }

    @Override
    public void dispose() {
        threeLivesTexture.dispose();
        twoLivesTexture.dispose();
        oneLifeTexture.dispose();

        crumbleSound.dispose();
        laserSound.dispose();
        auaSound.dispose();

        for (Disposable bullet : bullets) {
            bullet.dispose();
        }
    }
}
