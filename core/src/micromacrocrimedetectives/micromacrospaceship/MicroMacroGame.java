package micromacrocrimedetectives.micromacrospaceship;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;
import micromacrocrimedetectives.micromacrospaceship.view.MenuScreen;

public class MicroMacroGame extends Game {
    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;
    public BitmapFont font;

    public MicroMacroAssets assets;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();

        assets = new MicroMacroAssets();

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
        assets.dispose();
    }
}
