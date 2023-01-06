package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.model.MenuModel;
import micromacrocrimedetectives.micromacrospaceship.screens.MenuScreen;
import micromacrocrimedetectives.micromacrospaceship.screens.MicroMacroGameScreen;
import micromacrocrimedetectives.micromacrospaceship.screens.SpaceshipGameScreen;

public class MenuController implements Disposable {
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
                if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                    menuScreen.game.setScreen(new MicroMacroGameScreen(menuScreen.game));
                } else {
                    menuScreen.game.setScreen(new SpaceshipGameScreen(menuScreen.game));
                }

                menuScreen.dispose();
            }
        });

        model.stage.addActor(model.startGameButton);
        model.stage.addActor(model.caseDropdown);
        model.stage.addActor(model.caseDropdownLabel);
    }

    public void drawUfo(SpriteBatch batch) {
        batch.draw(model.ufoTexture, model.ufoX, model.ufoY);
    }

    public void drawUfoLight(ShapeRenderer shapeRenderer) {
        shapeRenderer.triangle(
                model.ufoLightX1,
                model.ufoLightY1,
                model.ufoLightX2,
                model.ufoLightY2,
                model.ufoLightX3,
                model.ufoLightY3,
                CustomColors.purple,
                CustomColors.darkPurple,
                CustomColors.darkPurple
        );
    }

    public void drawGear(SpriteBatch batch) {
        batch.draw(
                model.gearTexture,
                (Gdx.graphics.getWidth() - model.gearTexture.getWidth()) / 2f,
                20
        );
    }

    @Override
    public void dispose() {
        model.dispose();
    }
}
