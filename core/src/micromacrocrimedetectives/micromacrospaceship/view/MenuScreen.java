package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.MenuController;
import micromacrocrimedetectives.micromacrospaceship.model.MenuModel;

public class MenuScreen implements Screen {
    public final MicroMacroGame game;
    private final OrthographicCamera camera;
    private final MenuController controller;

    public MenuScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 480);

        controller = new MenuController(new MenuModel(game));
        controller.initStage(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.shapeRenderer.setProjectionMatrix(camera.combined);

        game.shapeRenderer.begin(ShapeType.Filled);
        controller.drawUfoLight(game.shapeRenderer);
        game.shapeRenderer.end();

        game.batch.begin();
        controller.drawUfo(game.batch);
        controller.drawGear(game.batch);
        game.batch.end();

        controller.getStage().act();
        controller.getStage().draw();
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
        controller.dispose();
    }
}
