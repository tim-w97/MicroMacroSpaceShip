package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.model.cutscenes.CutsceneModel;
import micromacrocrimedetectives.micromacrospaceship.model.cutscenes.UfoDestroyedCutsceneModel;
import micromacrocrimedetectives.micromacrospaceship.screens.MenuScreen;

public class CutsceneController implements Disposable {
    private final CutsceneModel model;

    public CutsceneController(CutsceneModel model, Screen screen) {
        this.model = model;

        model.button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.game.setScreen(model.newScreenToSwitch);
                screen.dispose();
            }
        });

        if (model instanceof UfoDestroyedCutsceneModel) {
            ((UfoDestroyedCutsceneModel) model).quitButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    model.game.setScreen(new MenuScreen(model.game));
                    screen.dispose();
                }
            });
        }
    }

    public void drawCutscene(SpriteBatch batch) {
        batch.draw(model.currentSlide, 0, 0);
    }

    @Override
    public void dispose() {
        model.dispose();
    }

    public void beginSpeech() {
        model.currentSpeech.play();

        model.currentSpeech.setOnCompletionListener(speech -> {
            model.index++;

            if (model.index == model.slides.size()) {
                return;
            }

            model.currentSlide = model.slides.get(model.index);
            model.currentSpeech = model.speeches.get(model.index);

            beginSpeech();
        });
    }

    public void drawStage() {
        if (model.index == model.slides.size()) {
            model.stage.act();
            model.stage.draw();
        }
    }
}
