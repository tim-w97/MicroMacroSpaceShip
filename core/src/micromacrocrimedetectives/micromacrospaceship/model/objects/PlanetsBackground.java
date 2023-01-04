package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class PlanetsBackground implements Disposable {
    public final Texture texture = new Texture("images/planetsBackground.png");
    public float x, y;
    public float velocity;

    public PlanetsBackground() {
        x = 0;
        y = 0;
        velocity = 50;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
