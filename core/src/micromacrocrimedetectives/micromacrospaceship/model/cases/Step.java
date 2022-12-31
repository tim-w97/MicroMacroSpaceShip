package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Step {
    public AtlasRegion mobileImage;
    public Circle area;
    public boolean solved;

    public Step(AtlasRegion mobileImage, Vector2 location) {
        this.mobileImage = mobileImage;
        area = new Circle(location, 128);
        solved = false;
    }
}
