package micromacrocrimedetectives.micromacrospaceship;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import micromacrocrimedetectives.micromacrospaceship.model.AvailableCase;
import micromacrocrimedetectives.micromacrospaceship.screens.MenuScreen;

public class MicroMacroGame extends Game {
    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;
    public BitmapFont font;
    public Skin skin;

    public AvailableCase selectedCase;
    public boolean skipCutscenes;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));

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
        skin.dispose();
    }
}
