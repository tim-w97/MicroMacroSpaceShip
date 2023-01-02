package micromacrocrimedetectives.micromacrospaceship.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.MicroMacroGameController;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroGameModel;

public class MicroMacroGameScreen implements Screen {
    private final MicroMacroGame game;

    private final OrthographicCamera movingCamera;
    private final OrthographicCamera fixedCamera;
    private final MicroMacroGameController controller;

    public MicroMacroGameScreen(MicroMacroGame game) {
        this.game = game;

        fixedCamera = new OrthographicCamera();
        movingCamera = new OrthographicCamera();

        fixedCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        movingCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        controller = new MicroMacroGameController(new MicroMacroGameModel(game));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.red);

        movingCamera.update();
        fixedCamera.update();

        game.batch.setProjectionMatrix(movingCamera.combined);

        game.batch.begin();

        controller.drawMap(game.batch);

        game.batch.end();

        game.batch.setProjectionMatrix(fixedCamera.combined);

        game.batch.begin();

        controller.drawBongoBob(game.batch);
        controller.drawPhone(game.batch);
        controller.drawMiniMap(game.batch);

        game.batch.end();

        controller.setCursor(fixedCamera);

        handleUserInput(delta);

        movingCamera.position.set(controller.getCameraPosition());

        controller.checkForCaseStepAreaCollision();
    }

    private void handleUserInput(float delta) {
        boolean playerGoesLeft = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean playerGoesRight = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean playerGoesUp = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean playerGoesDown = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean playerUsesTurbo = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        if (playerGoesLeft || playerGoesRight || playerGoesUp || playerGoesDown) {
            controller.playRobotSound();
            controller.playerMoves(delta);
        } else {
            controller.stopRobotSound();
        }

        if (playerGoesLeft && playerGoesUp) {
            controller.goDiagonalUp(delta);
        } else if (playerGoesLeft && playerGoesDown) {
            controller.goDiagonalLeft(delta);
        } else if (playerGoesRight && playerGoesUp) {
            controller.goDiagonalRight(delta);
        } else if (playerGoesRight && playerGoesDown) {
            controller.goDiagonalDown(delta);
        } else if (playerGoesLeft) {
            controller.goLeft(delta);
        } else if (playerGoesRight) {
            controller.goRight(delta);
        } else if (playerGoesUp) {
            controller.goUp(delta);
        } else if (playerGoesDown) {
            controller.goDown(delta);
        }

        if (playerUsesTurbo) {
            controller.activateTurboDrive();
        } else {
            controller.deactivateTurboDrive();
        }

        if (Gdx.input.justTouched()) {
            controller.handleUserClick(fixedCamera);
        }
    }

    @Override
    public void show() {
        controller.playSpaceshipAmbienceMusic();
        controller.playWelcomeMessage();
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
