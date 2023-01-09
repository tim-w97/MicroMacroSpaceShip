package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public class AngryBullet implements Disposable {
    public final Texture texture = new Texture("images/spaceship-game/bullet/angry.png");

    public Rectangle frame;
    public float velocity;

    public AngryBullet() {
        frame = new Rectangle();

        frame.setWidth(texture.getWidth());
        frame.setHeight(texture.getHeight());

        velocity = 200;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
