package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

import java.util.ArrayList;

public class Ufo {
    public final ArrayList<FriendlyBullet> bullets;

    public final AtlasRegion texture;
    public final Rectangle frame;
    public final float velocity;

    public static float bottomMargin = 20;

    public Sound laserSound;
    public Sound crumbleSound;

    public Ufo() {
        bullets = new ArrayList<>();

        texture = MicroMacroAssets.getInstance().atlas.findRegion("ufo");

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - texture.getRegionWidth()) / 2f,
                bottomMargin,
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );

        velocity = 300;

        laserSound = Gdx.audio.newSound(Gdx.files.internal("sounds/pop.mp3"));
        crumbleSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
    }

    public void dispose() {
        crumbleSound.dispose();
        laserSound.dispose();

        for (FriendlyBullet friendlyBullet : bullets) {
            friendlyBullet.dispose();
        }
    }
}
