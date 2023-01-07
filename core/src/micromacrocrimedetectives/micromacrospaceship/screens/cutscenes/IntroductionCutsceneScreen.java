package micromacrocrimedetectives.micromacrospaceship.screens.cutscenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.cutscenes.IntroductionCutsceneController;
import micromacrocrimedetectives.micromacrospaceship.model.cutscenes.IntroductionCutsceneModel;

public class IntroductionCutsceneScreen implements Screen {
    public final MicroMacroGame game;
    private final OrthographicCamera camera;
    private final IntroductionCutsceneController controller;

    public IntroductionCutsceneScreen(MicroMacroGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 480);

        controller = new IntroductionCutsceneController(new IntroductionCutsceneModel(game), this);
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
        controller.drawStartButton();
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
