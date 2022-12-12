package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Asteroid;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Projectile;

public class SpaceshipGameScreen implements Screen {

    public final MicroMacroGame game;
    private final OrthographicCamera camera;

    public SpaceshipGameScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.shapeRenderer.setProjectionMatrix(camera.combined);
        game.shapeRenderer.setColor(CustomColors.pink);

        if (Gdx.input.isKeyPressed(Keys.C)) {
            game.spaceshipGameController.switchToMicroMacroGameScreen(this);
        }

        moveObjects(delta);
        drawObjects();
    }

    private void moveObjects(float delta) {
        boolean playerGoesLeft = Gdx.input.isKeyPressed(Keys.LEFT);
        boolean playerGoesRight = Gdx.input.isKeyPressed(Keys.RIGHT);
        boolean playerShoots = Gdx.input.isKeyPressed(Keys.SPACE);

        if (playerGoesLeft) {
            game.spaceshipGameController.moveUfoLeft(delta);
        } else if (playerGoesRight) {
            game.spaceshipGameController.moveUfoRight(delta);
        }

        if (playerShoots) {
            game.spaceshipGameController.shootProjectile();
        }

        game.spaceshipGameController.moveProjectiles(delta);

        game.spaceshipGameController.movePlanetsBackground(delta);

        game.spaceshipGameController.generateAsteroids();
        game.spaceshipGameController.moveAndRotateAsteroids(delta);
        game.spaceshipGameController.checkAsteroidProjectileCollision();
    }

    private void drawObjects() {
        game.batch.begin();

        game.batch.draw(
                game.spaceshipGameController.getPlanetsBackground().texture,
                game.spaceshipGameController.getPlanetsBackground().x,
                game.spaceshipGameController.getPlanetsBackground().y
        );

        for (Asteroid asteroid : game.spaceshipGameController.getCurrentAsteroids()) {
            game.batch.draw(
                    asteroid.textureRegion,
                    asteroid.frame.x,
                    asteroid.frame.y,
                    asteroid.originX,
                    asteroid.originY,
                    asteroid.frame.width,
                    asteroid.frame.height,
                    1,
                    1,
                    asteroid.rotation
            );
        }

        game.batch.draw(
                game.spaceshipGameController.getUfo().texture,
                game.spaceshipGameController.getUfo().frame.x,
                game.spaceshipGameController.getUfo().frame.y
        );

        game.batch.end();

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Projectile projectile : game.spaceshipGameController.getCurrentProjectiles()) {
            game.shapeRenderer.circle(
                    projectile.frame.x,
                    projectile.frame.y,
                    projectile.frame.radius
            );
        }

        game.shapeRenderer.end();
    }

    @Override
    public void show() {

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
        game.spaceshipGameController.dispose();
    }
}
