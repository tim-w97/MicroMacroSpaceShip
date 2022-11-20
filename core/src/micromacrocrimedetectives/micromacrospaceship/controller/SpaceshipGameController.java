package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;

import java.util.ArrayList;

public class SpaceshipGameController {
    private final SpaceshipGameModel model;

    public SpaceshipGameController(SpaceshipGameModel model) {
        this.model = model;
    }

    public float getUfoPositionX() {
        return model.ufoFrame.x;
    }

    public float getUfoPositionY() {
        return model.ufoFrame.y;
    }

    public Texture getUfoTexture() {
        return model.ufoTexture;
    }

    public void moveUfoLeft(float delta) {
        model.ufoFrame.x -= delta * model.ufoVelocity;

        if (model.ufoFrame.x < -model.ufoFrame.width) {
            model.ufoFrame.x = Gdx.graphics.getWidth();
        }
    }

    public void moveUfoRight(float delta) {
        model.ufoFrame.x += delta * model.ufoVelocity;

        if (model.ufoFrame.x > Gdx.graphics.getWidth()) {
            model.ufoFrame.x = -model.ufoFrame.width;
        }
    }

    public void shootProjectile() {
        if (TimeUtils.timeSinceMillis(model.lastShootTime) > model.shootDelay) {
            Rectangle projectile = new Rectangle(model.projectileTemplate);
            projectile.setX(model.ufoFrame.x + model.ufoFrame.width / 2);
            model.projectiles.add(projectile);
            model.lastShootTime = TimeUtils.millis();
        }
    }

    public ArrayList<Rectangle> getCurrentProjectiles() {
        return model.projectiles;
    }

    public Texture getAsteroidTexture() {
        return model.asteroidTexture;
    }

    public ArrayList<Rectangle> getCurrentAsteroids() {
        return model.asteroids;
    }

    public void moveProjectiles(float delta) {
        ArrayList<Rectangle> offScreenProjectiles = new ArrayList<>();

        for (Rectangle projectile : model.projectiles) {
            projectile.y += delta * model.projectileVelocity;

            if (projectile.y > Gdx.graphics.getHeight() + projectile.height) {
                offScreenProjectiles.add(projectile);
            }
        }

        model.projectiles.removeAll(offScreenProjectiles);
    }

    public void generateAsteroids() {
        model.lastAsteroidSpawnPosition = (int) (Math.random() * model.asteroidRows);

        if (TimeUtils.timeSinceMillis(model.lastAsteroidSpawnTime) > model.asteroidSpawnDelay) {
            Rectangle asteroid = new Rectangle(
                    model.lastAsteroidSpawnPosition * model.asteroidTexture.getWidth() + model.asteroidOffset,
                    Gdx.graphics.getHeight(),
                    model.asteroidTexture.getWidth(),
                    model.asteroidTexture.getHeight()
            );

            model.asteroids.add(asteroid);

            model.lastAsteroidSpawnTime = TimeUtils.millis();
        }
    }

    public void moveAsteroids(float delta) {
        ArrayList<Rectangle> offScreenAsteroids = new ArrayList<>();

        for (Rectangle asteroid : model.asteroids) {
            asteroid.y -= delta * model.asteroidVelocity;

            if (asteroid.y < -model.asteroidTexture.getHeight()) {
                offScreenAsteroids.add(asteroid);
            }
        }
        model.asteroids.removeAll(offScreenAsteroids);
    }

    public void checkAsteroidProjectileCollision() {
        ArrayList<Rectangle> shotAsteroids = new ArrayList<>();

        for (Rectangle projectile : model.projectiles) {
            for (Rectangle asteroid : model.asteroids) {
                if (projectile.overlaps(asteroid)) {
                    shotAsteroids.add(asteroid);
                }
            }
        }

        model.asteroids.removeAll(shotAsteroids);
    }
}
