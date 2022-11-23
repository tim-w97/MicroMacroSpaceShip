package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import micromacrocrimedetectives.micromacrospaceship.model.MenuModel;
import micromacrocrimedetectives.micromacrospaceship.view.MenuScreen;
import micromacrocrimedetectives.micromacrospaceship.view.SpaceshipGameScreen;

public class MenuController {
    private final MenuModel model;

    public MenuController(MenuModel model) {
        this.model = model;
    }

    public Stage getStage() {
        return model.stage;
    }

    public void initStage(final MenuScreen menuScreen) {
        Gdx.input.setInputProcessor(model.stage);

        model.startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuScreen.game.setScreen(new SpaceshipGameScreen(menuScreen.game));
                menuScreen.dispose();
            }
        });

        model.stage.addActor(model.startGameButton);
    }
}
