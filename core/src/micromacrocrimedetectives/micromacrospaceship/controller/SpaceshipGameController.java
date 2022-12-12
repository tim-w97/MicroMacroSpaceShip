package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Asteroid;
import micromacrocrimedetectives.micromacrospaceship.model.objects.PlanetsBackground;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Projectile;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Ufo;
import micromacrocrimedetectives.micromacrospaceship.view.MicroMacroGameScreen;
import micromacrocrimedetectives.micromacrospaceship.view.SpaceshipGameScreen;

import java.util.ArrayList;

public class SpaceshipGameController {
    private final SpaceshipGameModel model;

    public SpaceshipGameController(SpaceshipGameModel model) {
        this.model = model;
    }

    public PlanetsBackground getPlanetsBackground() {
        return model.planetsBackground;
    }

    public void movePlanetsBackground(float delta) {
        model.planetsBackground.y -= delta * model.planetsBackground.velocity;

        if (model.planetsBackground.y < -model.planetsBackground.texture.getHeight() + Gdx.graphics.getHeight()) {
            model.planetsBackground.y = 0;
        }
    }

    public Ufo getUfo() {
        return model.ufo;
    }

    public void moveUfoLeft(float delta) {
        model.ufo.frame.x -= delta * model.ufo.velocity;

        if (model.ufo.frame.x < -model.ufo.frame.width) {
            model.ufo.frame.x = Gdx.graphics.getWidth();
        }
    }

    public void moveUfoRight(float delta) {
        model.ufo.frame.x += delta * model.ufo.velocity;

        if (model.ufo.frame.x > Gdx.graphics.getWidth()) {
            model.ufo.frame.x = -model.ufo.frame.width;
        }
    }

    public void shootProjectile() {
        if (TimeUtils.timeSinceMillis(model.lastShootTime) > model.shootDelay) {
            Projectile projectile = new Projectile(
                    model.ufo.frame.x + model.ufo.frame.width / 2,
                    model.ufo.frame.height + Ufo.bottomMargin
            );

            model.projectiles.add(projectile);
            model.lastShootTime = TimeUtils.millis();
        }
    }

    public ArrayList<Projectile> getCurrentProjectiles() {
        return model.projectiles;
    }

    public ArrayList<Asteroid> getCurrentAsteroids() {
        return model.asteroids;
    }

    public void moveProjectiles(float delta) {
        ArrayList<Projectile> offScreenProjectiles = new ArrayList<>();

        for (Projectile projectile : model.projectiles) {
            projectile.frame.y += delta * projectile.velocity;

            if (projectile.frame.y > Gdx.graphics.getHeight() + projectile.frame.radius) {
                offScreenProjectiles.add(projectile);
            }
        }
        model.projectiles.removeAll(offScreenProjectiles);
    }

    public void generateAsteroids() {
        model.lastAsteroidSpawnPosition = (int) (Math.random() * model.asteroidRows);

        if (TimeUtils.timeSinceMillis(model.lastAsteroidSpawnTime) > model.asteroidSpawnDelay) {
            model.asteroids.add(new Asteroid(model.lastAsteroidSpawnPosition));
            model.lastAsteroidSpawnTime = TimeUtils.millis();
        }
    }

    public void moveAndRotateAsteroids(float delta) {
        ArrayList<Asteroid> offScreenAsteroids = new ArrayList<>();

        for (Asteroid asteroid : model.asteroids) {
            asteroid.frame.y -= delta * asteroid.velocity;

            if (asteroid.rotateClockwise) {
                asteroid.rotation += delta * asteroid.rotationVelocity;
            } else {
                asteroid.rotation -= delta * asteroid.rotationVelocity;
            }

            if (asteroid.frame.y < -asteroid.frame.getHeight()) {
                offScreenAsteroids.add(asteroid);
            }
        }
        model.asteroids.removeAll(offScreenAsteroids);
    }

    public void checkAsteroidProjectileCollision() {
        ArrayList<Asteroid> shotAsteroids = new ArrayList<>();

        for (Projectile projectile : model.projectiles) {
            for (Asteroid asteroid : model.asteroids) {
                if (Intersector.overlaps(projectile.frame, asteroid.frame)) {
                    shotAsteroids.add(asteroid);
                }
            }
        }
        model.asteroids.removeAll(shotAsteroids);
    }

    public void switchToMicroMacroGameScreen(SpaceshipGameScreen screen) {
        screen.game.setScreen(new MicroMacroGameScreen(screen.game));
        screen.dispose();
    }

    public void dispose() {
        model.dispose();
    }
}
