package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroAssets;

public class PlanetsBackground {
    public Texture texture;
    public float x, y;
    public float velocity;

    public PlanetsBackground(MicroMacroAssets assets) {
        texture = assets.planetsBackground;
        x = 0;
        y = 0;
        velocity = 50;
    }

    public void dispose() {
        texture.dispose();
    }
}
