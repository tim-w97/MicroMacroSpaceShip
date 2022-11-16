package micromacrocrimedetectives.micromacrospaceship.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class SpaceshipGameScreen implements Screen {

    private final MicroMacroGame game;

    private final OrthographicCamera camera;

    public SpaceshipGameScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.CLEAR);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();


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
