package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class SpaceshipGameScreen implements Screen {

    private final MicroMacroGame game;
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

        moveObjects(delta);
        drawObjects();
    }

    private void moveObjects(float delta) {
        boolean playerGoesLeft = Gdx.input.isKeyPressed(Keys.LEFT);
        boolean playerGoesRight = Gdx.input.isKeyPressed(Keys.RIGHT);
        boolean playerShoots = Gdx.input.isKeyPressed(Keys.SPACE);

        if (playerGoesLeft) {
            game.controller.moveUfoLeft(delta);
        } else if (playerGoesRight) {
            game.controller.moveUfoRight(delta);
        }

        if (playerShoots) {
            game.controller.shootProjectile();
        }

        game.controller.moveProjectiles(delta);

        game.controller.generateAsteroids();
        game.controller.moveAsteroids(delta);
        game.controller.checkAsteroidProjectileCollision();
    }

    private void drawObjects() {
        game.batch.begin();

        for (Rectangle asteroid : game.controller.getCurrentAsteroids()) {
            game.batch.draw(
                    game.controller.getAsteroidTexture(),
                    asteroid.x,
                    asteroid.y
            );
        }

        game.batch.draw(
                game.controller.getUfoTexture(),
                game.controller.getUfoPositionX(),
                game.controller.getUfoPositionY()
        );

        game.batch.end();

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Rectangle projectile : game.controller.getCurrentProjectiles()) {
            game.shapeRenderer.circle(
                    projectile.x,
                    projectile.y,
                    projectile.width / 2
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

    }
}
