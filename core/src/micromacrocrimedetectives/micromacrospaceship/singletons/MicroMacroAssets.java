package micromacrocrimedetectives.micromacrospaceship.singletons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MicroMacroAssets {
    public TextureAtlas atlas;
    public Texture map;
    public Texture planetsBackground;

    private static MicroMacroAssets instance;

    private MicroMacroAssets() {
       atlas = new TextureAtlas("images/atlas/MicroMacroAssets.atlas");
       map = new Texture("images/map.jpg");
       planetsBackground = new Texture("images/planetsBackground.png");
    }

    public static MicroMacroAssets getInstance() {
        if (instance == null) {
            instance = new MicroMacroAssets();
        }

        return instance;
    }
}
