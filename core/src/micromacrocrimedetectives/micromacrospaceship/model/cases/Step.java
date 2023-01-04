package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Step {
    public Texture mobileImage;
    public Circle area;
    public boolean solved;

    public Step(Texture mobileImage, Vector2 location) {
        this.mobileImage = mobileImage;
        area = new Circle(location, 128);
        solved = false;
    }
}
