package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public class FriendlyBullet implements Disposable {
    public Rectangle frame;
    public Texture texture;
    public float velocity;

    public FriendlyBullet() {
        texture = new Texture("images/spaceship-game/bullet/friendly.png");

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
