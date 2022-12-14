package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class ClosedPhone {
    public TextureRegion texture;
    public Rectangle frame;
    public float margin;

    public ClosedPhone(TextureRegion texture) {
        margin = 10;

        this.texture = texture;

        frame = new Rectangle(
                Gdx.graphics.getWidth() - texture.getRegionWidth() - margin,
                margin,
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );
    }

    public void dispose() {
    }
}
