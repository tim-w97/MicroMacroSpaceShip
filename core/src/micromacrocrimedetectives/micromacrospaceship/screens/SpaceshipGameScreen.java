package micromacrocrimedetectives.micromacrospaceship.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.objects.Asteroid;
import micromacrocrimedetectives.micromacrospaceship.objects.Projectile;
import micromacrocrimedetectives.micromacrospaceship.objects.Ufo;

import java.util.ArrayList;

public class SpaceshipGameScreen implements Screen {

    private final MicroMacroGame game;

    private final OrthographicCamera camera;
    private final Ufo ufo;

    private final ArrayList<Projectile> projectiles;
    private final ArrayList<Asteroid> asteroids;

    private long lastShootTime;
    private long lastAsteroidSpawnTime;
    private final int shootDelay = 600;
    private final int asteroidSpawnDelay = 1000;

    int lastAsteroidSpawnPosition = getRandomAsteroidSpawnPosition();

    public SpaceshipGameScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        ufo = new Ufo();
        asteroids = new ArrayList<>();
        projectiles = new ArrayList<>();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        ufo.moveWhenUserInput(delta);

        for (Asteroid asteroid : asteroids) {
            asteroid.moveAndRotate(delta);
        }

        // Spawn asteroids
        if (TimeUtils.timeSinceMillis(lastAsteroidSpawnTime) > asteroidSpawnDelay) {
            int asteroidSpawnPosition = getRandomAsteroidSpawnPosition();

            // prevent same spawn position of two asteroids
            while (asteroidSpawnPosition == lastAsteroidSpawnPosition) {
                asteroidSpawnPosition = getRandomAsteroidSpawnPosition();
            }

            lastAsteroidSpawnPosition = asteroidSpawnPosition;

            asteroids.add(new Asteroid(120 * asteroidSpawnPosition));

            lastAsteroidSpawnTime = TimeUtils.millis();
        }

        // Shoot projectiles if the user presses space
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)
                && TimeUtils.timeSinceMillis(lastShootTime) > shootDelay) {
            projectiles.add(new Projectile((ufo.getOriginX())));
            lastShootTime = TimeUtils.millis();
        }

        ArrayList<Projectile> offScreenProjectiles = new ArrayList<>();
        ArrayList<Asteroid> asteroidsToRemove = new ArrayList<>();

        for (Projectile projectile : projectiles) {
            projectile.move(delta);

            if (projectile.ifOffScreen()) {
                offScreenProjectiles.add(projectile);
            }

            // collision with asteroid
            for (Asteroid asteroid : asteroids) {
                if (asteroid.frame.overlaps(projectile.frame)) {
                    asteroidsToRemove.add(asteroid);
                }
            }
        }

        // asteroid is off-screen
        for (Asteroid asteroid : asteroids) {
            if (asteroid.ifOffScreen()) {
                asteroidsToRemove.add(asteroid);
            }
        }

        projectiles.removeAll(offScreenProjectiles);
        asteroids.removeAll(asteroidsToRemove);

        renderObjects();
    }

    private int getRandomAsteroidSpawnPosition() {
        return (int) (Math.random() * 6);
    }

    private void renderObjects() {
        // render the projectiles
        game.shapeRenderer.setColor(CustomColors.pink);

        game.shapeRenderer.begin(ShapeType.Filled);

        for (Projectile projectile : projectiles) {
            projectile.draw(game.shapeRenderer);
        }

        game.shapeRenderer.end();

        game.batch.begin();

        for (Asteroid asteroid : asteroids) {
            asteroid.draw(game.batch);
        }

        ufo.draw(game.batch);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
