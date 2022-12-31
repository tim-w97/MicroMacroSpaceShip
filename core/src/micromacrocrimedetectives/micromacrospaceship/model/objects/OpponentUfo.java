package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

import java.util.ArrayList;
import java.util.List;

public class OpponentUfo {
    public List<AngryBullet> bullets;
    public Rectangle frame;

    public AtlasRegion texture;

    public float verticalVelocity;
    public float horizontalVelocity;

    public int lives;

    public long lastShootTime;
    public int shootDelay;

    public OpponentUfo(MicroMacroAssets assets) {
        bullets = new ArrayList<>();

        texture = assets.atlas.findRegion("OpponentUfo/threeLives");

        frame = new Rectangle(
                (float) (Math.random() * (Gdx.graphics.getWidth() - texture.getRegionWidth())),
                Gdx.graphics.getHeight(),
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );

        verticalVelocity = 60;
        horizontalVelocity = 80;

        lives = 3;

        shootDelay = 3000;
    }

    public void dispose() {
    }
}
