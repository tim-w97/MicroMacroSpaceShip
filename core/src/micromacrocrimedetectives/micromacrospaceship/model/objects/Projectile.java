package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.math.Circle;

public class Projectile {
    public Circle frame;
    public float velocity;

    public Projectile(float x, float y) {
        frame = new Circle(x, y, 16);
        velocity = 600;
    }
}
