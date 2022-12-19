package micromacrocrimedetectives.micromacrospaceship;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import micromacrocrimedetectives.micromacrospaceship.controller.MenuController;
import micromacrocrimedetectives.micromacrospaceship.controller.MicroMacroGameController;
import micromacrocrimedetectives.micromacrospaceship.controller.SpaceshipGameController;
import micromacrocrimedetectives.micromacrospaceship.model.MenuModel;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import micromacrocrimedetectives.micromacrospaceship.view.MenuScreen;

public class MicroMacroGame extends Game {
    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;
    public BitmapFont font;

    // TODO: Put controller instances inside the screens (View)
    public SpaceshipGameController spaceshipGameController;
    public MenuController menuController;
    public MicroMacroGameController microMacroGameController;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();

        spaceshipGameController = new SpaceshipGameController(
                new SpaceshipGameModel()
        );

        menuController = new MenuController(
                new MenuModel()
        );

        microMacroGameController = new MicroMacroGameController(
                new MicroMacroGameModel()
        );

        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }
}
