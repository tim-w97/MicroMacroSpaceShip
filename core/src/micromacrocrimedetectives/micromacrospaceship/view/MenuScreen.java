package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class MenuScreen implements Screen {
    public final MicroMacroGame game;

    private final OrthographicCamera camera;

    public MenuScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 480);

        game.menuController.initStage(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.menuController.drawUfo(game.batch);
        game.batch.end();

        game.menuController.getStage().act();
        game.menuController.getStage().draw();
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
