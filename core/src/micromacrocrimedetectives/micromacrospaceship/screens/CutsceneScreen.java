package micromacrocrimedetectives.micromacrospaceship.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.CutsceneController;
import micromacrocrimedetectives.micromacrospaceship.model.cutscenes.CutsceneModel;

public class CutsceneScreen implements Screen {
    public final MicroMacroGame game;
    private final OrthographicCamera camera;
    private final CutsceneController controller;

    public CutsceneScreen(CutsceneModel model) {
        this.game = model.game;
        controller = new CutsceneController(model, this);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 480);
    }

    @Override
    public void show() {
        controller.beginSpeech();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        controller.drawCutscene(game.batch);
        controller.drawStage();
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
        controller.dispose();
    }
}
