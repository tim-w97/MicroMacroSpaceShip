package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Disposable;

public class OpenedPhone implements Disposable {
    public Texture texture;
    public Rectangle frame;
    public float margin;

    public OpenedPhone() {
        margin = 10;

        texture = new Texture("images/micro-macro-game/phone/opened.png");

        frame = new Rectangle(
                Gdx.graphics.getWidth() - texture.getWidth() - margin,
                margin,
                texture.getWidth(),
                texture.getHeight()
        );
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
