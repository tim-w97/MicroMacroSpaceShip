package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.model.MenuModel;
import micromacrocrimedetectives.micromacrospaceship.view.MenuScreen;
import micromacrocrimedetectives.micromacrospaceship.view.MicroMacroGameScreen;
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
                menuScreen.game.setScreen(new MicroMacroGameScreen(menuScreen.game));
                //menuScreen.game.setScreen(new SpaceshipGameScreen(menuScreen.game));
                menuScreen.dispose();
            }
        });

        model.stage.addActor(model.startGameButton);
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

    public void dispose() {
        model.stage.dispose();
        model.skin.dispose();
        model.ufoTexture.dispose();
    }
}
