package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;

public class PlanetsBackground {
    public Texture texture;
    public float x, y;
    public float velocity;

    public PlanetsBackground() {
        texture = new Texture("planetsBackground.png");
        x = 0;
        y = 0;
        velocity = 50;
    }

    public void dispose() {
        texture.dispose();
    }
}
