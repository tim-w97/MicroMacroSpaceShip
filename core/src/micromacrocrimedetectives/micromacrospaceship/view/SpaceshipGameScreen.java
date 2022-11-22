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

        game.controller.movePlanetsBackground(delta);

        game.controller.generateAsteroids();
        game.controller.moveAndRotateAsteroids(delta);
        game.controller.checkAsteroidProjectileCollision();
    }

    private void drawObjects() {
        game.batch.begin();

        game.batch.draw(
                game.controller.getPlanetsBackground().texture,
                game.controller.getPlanetsBackground().x,
                game.controller.getPlanetsBackground().y
        );

        for (Asteroid asteroid : game.controller.getCurrentAsteroids()) {
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
                game.controller.getUfo().texture,
                game.controller.getUfo().frame.x,
                game.controller.getUfo().frame.y
        );

        game.batch.end();

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Projectile projectile : game.controller.getCurrentProjectiles()) {
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

    }
}
