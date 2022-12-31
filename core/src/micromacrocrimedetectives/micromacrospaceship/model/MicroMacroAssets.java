package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public class MicroMacroAssets implements Disposable {
    // TODO: Put also all Sounds in here
    public TextureAtlas atlas;
    public Texture map;
    public Texture planetsBackground;
    public Skin skin;

    public MicroMacroAssets() {
        atlas = new TextureAtlas("images/atlas/MicroMacroAssets.atlas");
        map = new Texture("images/map.jpg");
        planetsBackground = new Texture("images/planetsBackground.png");
        skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
    }

    @Override
    public void dispose() {
        skin.dispose();
        planetsBackground.dispose();
        map.dispose();
        atlas.dispose();
    }
}
