package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Asteroid;
import micromacrocrimedetectives.micromacrospaceship.model.objects.PlanetsBackground;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Projectile;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Ufo;

import java.util.ArrayList;

public class SpaceshipGameModel {
    public PlanetsBackground planetsBackground;
    public Ufo ufo;
    public final ArrayList<Projectile> projectiles;
    public final ArrayList<Asteroid> asteroids;
    public long lastShootTime;
    public final int shootDelay;

    public long lastAsteroidSpawnTime;
    public final int asteroidSpawnDelay;
    public int lastAsteroidSpawnPosition;
    public final int asteroidRows;

    public Music spaceMusic;

    public GlyphLayout elapsedTimeLayout;
    public long elapsedTime;

    public SpaceshipGameModel() {
        planetsBackground = new PlanetsBackground();
        ufo = new Ufo();

        projectiles = new ArrayList<>();
        shootDelay = 400;

        asteroids = new ArrayList<>();
        asteroidSpawnDelay = 1000;
        asteroidRows = 6;

        spaceMusic = Gdx.audio.newMusic(Gdx.files.internal("music/space music.mp3"));
        spaceMusic.setVolume(0.1f);

        elapsedTimeLayout = new GlyphLayout();
        elapsedTime = 1000 * 3;
    }

    public void dispose() {
        planetsBackground.dispose();
        ufo.dispose();
        spaceMusic.dispose();

        for (Projectile projectile : projectiles) {
            projectile.dispose();
        }

        for (Asteroid asteroid : asteroids) {
            asteroid.dispose();
        }
    }
}
