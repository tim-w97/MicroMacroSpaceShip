package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

public class OpponentUfo implements Disposable {
    public final Texture theeLivesTexture = new Texture("images/spaceship-game/opponent-ufo/three-lives.png");
    public final Texture twoLivesTexture = new Texture("images/spaceship-game/opponent-ufo/two-lives.png");
    public final Texture oneLifeTexture = new Texture("images/spaceship-game/opponent-ufo/one-life.png");

    public List<AngryBullet> bullets;
    public Rectangle frame;

    public Texture currentTexture;

    public float verticalVelocity;
    public float horizontalVelocity;

    public int lives;

    public long lastShootTime;
    public int shootDelay;

    public OpponentUfo() {
        bullets = new ArrayList<>();

        currentTexture = theeLivesTexture;

        frame = new Rectangle(
                (float) (Math.random() * (Gdx.graphics.getWidth() - currentTexture.getWidth())),
                Gdx.graphics.getHeight(),
                currentTexture.getWidth(),
                currentTexture.getHeight()
        );

        verticalVelocity = 60;
        horizontalVelocity = 80;

        lives = 3;

        shootDelay = 3000;
    }

    @Override
    public void dispose() {
        theeLivesTexture.dispose();
        twoLivesTexture.dispose();
        oneLifeTexture.dispose();
        currentTexture.dispose();

        for (Disposable bullet : bullets) {
            bullet.dispose();
        }
    }
}
