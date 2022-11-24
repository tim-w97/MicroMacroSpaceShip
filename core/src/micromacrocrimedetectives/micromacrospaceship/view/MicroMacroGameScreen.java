package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class MicroMacroGameScreen implements Screen {
    private final MicroMacroGame game;

    private final OrthographicCamera camera;

    public MicroMacroGameScreen(MicroMacroGame game) {
        this.game = game;

        game.shapeRenderer.setColor(CustomColors.red);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.shapeRenderer.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.microMacroGameController.drawMap(game.batch);
        game.batch.end();

        game.shapeRenderer.begin(ShapeType.Filled);
        game.shapeRenderer.circle(camera.position.x, camera.position.y, 16);
        game.shapeRenderer.end();

        camera.position.set(game.microMacroGameController.getCameraPosition());

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            game.microMacroGameController.goLeft(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            game.microMacroGameController.goRight(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            game.microMacroGameController.goUp(delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
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
