package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MapUfo {
    public Texture texture;
    public Rectangle frame;

    public MapUfo() {
        texture = new Texture("images/spaceship-game/ufo/three-lives.png");

        frame = new Rectangle(
                1325,
                6737,
                texture.getWidth(),
                texture.getHeight()
        );
    }
}
