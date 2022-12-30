package micromacrocrimedetectives.micromacrospaceship.singletons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MicroMacroAssets {
    public TextureAtlas atlas;
    public Texture map;
    public Texture planetsBackground;
    public Skin skin;

    private static MicroMacroAssets instance;

    private MicroMacroAssets() {
        atlas = new TextureAtlas("images/atlas/MicroMacroAssets.atlas");
        map = new Texture("images/map.jpg");
        planetsBackground = new Texture("images/planetsBackground.png");
        skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
    }

    public static MicroMacroAssets getInstance() {
        if (instance == null) {
            instance = new MicroMacroAssets();
        }

        return instance;
    }
}
