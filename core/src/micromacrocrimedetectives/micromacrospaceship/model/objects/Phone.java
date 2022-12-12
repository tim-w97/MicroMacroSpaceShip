package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Phone {
    public TextureRegion texture;
    public Vector2 position;
    public float margin;

    public Phone(TextureRegion texture) {
        margin = 10;

        this.texture = texture;

        position = new Vector2(
                Gdx.graphics.getWidth() - texture.getRegionWidth() - margin,
                margin
        );
    }

    public void dispose() {

    }
}
