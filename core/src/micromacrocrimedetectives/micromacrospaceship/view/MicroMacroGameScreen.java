package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class MicroMacroGameScreen implements Screen {
    private final MicroMacroGame game;

    private final OrthographicCamera movingCamera;
    private final OrthographicCamera fixedCamera;

    public MicroMacroGameScreen(MicroMacroGame game) {
        this.game = game;

        game.shapeRenderer.setColor(CustomColors.red);

        fixedCamera = new OrthographicCamera();
        movingCamera = new OrthographicCamera();

        fixedCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        movingCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        movingCamera.update();

        game.batch.setProjectionMatrix(movingCamera.combined);
        game.shapeRenderer.setProjectionMatrix(movingCamera.combined);

        game.batch.begin();

        game.microMacroGameController.drawMap(game.batch);
        game.microMacroGameController.drawBongoBob(game.batch);

        game.batch.setProjectionMatrix(fixedCamera.combined);

        game.microMacroGameController.drawPhone(game.batch);

        game.batch.end();

        handleUserInput(delta);
        movingCamera.position.set(game.microMacroGameController.getCameraPosition());
    }

    private void handleUserInput(float delta) {
        boolean playerGoesLeft = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean playerGoesRight = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean playerGoesUp = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean playerGoesDown = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (playerGoesLeft || playerGoesRight || playerGoesUp || playerGoesDown) {
            game.microMacroGameController.playerMoves(delta);
        }

        if (playerGoesLeft && playerGoesUp) {
            game.microMacroGameController.goDiagonalUp(delta);
        } else if (playerGoesLeft && playerGoesDown) {
            game.microMacroGameController.goDiagonalLeft(delta);
        } else if (playerGoesRight && playerGoesUp) {
            game.microMacroGameController.goDiagonalRight(delta);
        } else if (playerGoesRight && playerGoesDown) {
            game.microMacroGameController.goDiagonalDown(delta);
        } else if (playerGoesLeft) {
            game.microMacroGameController.goLeft(delta);
        } else if (playerGoesRight) {
            game.microMacroGameController.goRight(delta);
        } else if (playerGoesUp) {
            game.microMacroGameController.goUp(delta);
        } else if (playerGoesDown) {
            game.microMacroGameController.goDown(delta);
        }
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
