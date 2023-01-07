package micromacrocrimedetectives.micromacrospaceship.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.SpaceshipGameController;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;

public class SpaceshipGameScreen implements Screen {

    public final MicroMacroGame game;
    private final OrthographicCamera camera;
    private final SpaceshipGameController controller;

    public SpaceshipGameScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        controller = new SpaceshipGameController(new SpaceshipGameModel(game));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.font.setColor(CustomColors.pink);

        moveObjects(delta);
        drawObjects();

        controller.decreaseElapsedTime(delta, this);
    }

    private void moveObjects(float delta) {
        boolean playerGoesLeft = Gdx.input.isKeyPressed(Keys.LEFT);
        boolean playerGoesRight = Gdx.input.isKeyPressed(Keys.RIGHT);
        boolean playerShoots = Gdx.input.isKeyPressed(Keys.SPACE);

        if (playerGoesLeft) {
            controller.moveUfoLeft(delta);
        } else if (playerGoesRight) {
            controller.moveUfoRight(delta);
        }

        if (playerShoots) {
            controller.shootFriendlyBullet();
        }

        controller.moveFriendlyBullets(delta);

        controller.movePlanetsBackground(delta);

        controller.generateOpponentUfos();
        controller.generateAngryBullets();

        controller.moveOpponentUfos(delta);
        controller.moveAngryBullets(delta);

        controller.checkForCollisions();
    }

    private void drawObjects() {
        game.batch.begin();

        controller.drawPlanetsBackground(game.batch);

        controller.drawUfo(game.batch);
        controller.drawOpponentUfo(game.batch);

        controller.drawBullets(game.batch);

        controller.drawElapsedTime(game.batch);

        game.batch.end();
    }

    @Override
    public void show() {
        controller.playSpaceMusic();
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
        controller.dispose();
    }
}
