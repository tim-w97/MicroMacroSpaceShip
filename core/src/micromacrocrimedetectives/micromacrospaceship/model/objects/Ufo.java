package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Ufo {
    public final Texture texture;
    public final Rectangle frame;
    public final float velocity;

    public static float bottomMargin = 20;

    public Ufo() {
        texture = new Texture("ufo.png");

        frame = new Rectangle(
                (Gdx.graphics.getWidth() - texture.getWidth()) / 2f,
                bottomMargin,
                texture.getWidth(),
                texture.getHeight()
        );

        velocity = 300;
    }

    public void dispose() {
        texture.dispose();
    }
}
