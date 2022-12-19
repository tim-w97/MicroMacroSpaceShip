package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Asteroid;
import micromacrocrimedetectives.micromacrospaceship.model.objects.PlanetsBackground;
import micromacrocrimedetectives.micromacrospaceship.model.objects.FriendlyBullet;
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

    public void shootFriendlyBullet() {
        if (TimeUtils.timeSinceMillis(model.lastShootTime) > model.shootDelay) {
            model.ufo.laserSound.play();

            FriendlyBullet friendlyBullet = new FriendlyBullet();

            friendlyBullet.frame.setX(model.ufo.frame.x + (model.ufo.frame.width - friendlyBullet.frame.width) / 2);
            friendlyBullet.frame.setY(model.ufo.frame.height + Ufo.bottomMargin);

            model.friendlyBullets.add(friendlyBullet);
            model.lastShootTime = TimeUtils.millis();
        }
    }

    public ArrayList<FriendlyBullet> getCurrentFriendlyBullets() {
        return model.friendlyBullets;
    }

    public ArrayList<Asteroid> getCurrentAsteroids() {
        return model.asteroids;
    }

    public void moveFriendlyBullets(float delta) {
        ArrayList<FriendlyBullet> offScreenFriendlyBullets = new ArrayList<>();

        for (FriendlyBullet friendlyBullet : model.friendlyBullets) {
            friendlyBullet.frame.y += delta * friendlyBullet.velocity;

            if (friendlyBullet.frame.y > Gdx.graphics.getHeight()) {
                offScreenFriendlyBullets.add(friendlyBullet);
            }
        }
        model.friendlyBullets.removeAll(offScreenFriendlyBullets);
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

    public void checkAsteroidFriendlyBulletCollision() {
        ArrayList<Asteroid> shotAsteroids = new ArrayList<>();

        for (FriendlyBullet friendlyBullet : model.friendlyBullets) {
            for (Asteroid asteroid : model.asteroids) {
                if (Intersector.overlaps(friendlyBullet.frame, asteroid.frame)) {
                    model.ufo.crumbleSound.play();
                    shotAsteroids.add(asteroid);
                }
            }
        }
        model.asteroids.removeAll(shotAsteroids);
    }

    public void dispose() {
        model.dispose();
    }

    public void playSpaceMusic() {
        model.spaceMusic.play();
    }

    public void drawElapsedTime(SpriteBatch batch, BitmapFont font) {
        int elapsedTimeInSeconds = (int) (model.elapsedTime / 1000);

        String text = "Verbleibende Zeit: " + Long.toString(elapsedTimeInSeconds) + " Sekunden";

        model.elapsedTimeLayout.setText(font, text);

        font.draw(
                batch,
                text,
                (Gdx.graphics.getWidth() - model.elapsedTimeLayout.width) / 2f,
                Gdx.graphics.getHeight() - 10
        );
    }

    public void decreaseElapsedTime(float delta, SpaceshipGameScreen screen) {
        if (model.elapsedTime < 0) {
            screen.game.setScreen(new MicroMacroGameScreen(screen.game));
            screen.dispose();
        }

        model.elapsedTime -= delta * 1000;
    }
}
