package micromacrocrimedetectives.micromacrospaceship.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.objects.Ufo;

public class SpaceshipGameScreen implements Screen {

    private final MicroMacroGame game;

    private final OrthographicCamera camera;
    private final Ufo ufo;

    public SpaceshipGameScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        ufo = new Ufo();
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

        game.batch.begin();
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
