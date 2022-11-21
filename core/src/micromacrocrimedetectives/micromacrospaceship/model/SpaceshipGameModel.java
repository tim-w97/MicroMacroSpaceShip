package micromacrocrimedetectives.micromacrospaceship.model;

import micromacrocrimedetectives.micromacrospaceship.model.objects.Asteroid;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Projectile;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Ufo;

import java.util.ArrayList;

public class SpaceshipGameModel {
    public Ufo ufo;
    public final ArrayList<Projectile> projectiles;
    public final ArrayList<Asteroid> asteroids;
    public long lastShootTime;
    public final int shootDelay;

    public long lastAsteroidSpawnTime;
    public final int asteroidSpawnDelay;
    public int lastAsteroidSpawnPosition;
    public final int asteroidRows;

    public SpaceshipGameModel() {
        ufo = new Ufo();

        projectiles = new ArrayList<>();
        shootDelay = 400;

        asteroids = new ArrayList<>();
        asteroidSpawnDelay = 1000;
        asteroidRows = 6;
    }
}
