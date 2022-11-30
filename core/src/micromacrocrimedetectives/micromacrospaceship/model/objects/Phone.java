package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Phone {
    public TextureRegion texture;
    public Vector2 position;
    public float margin = 10;

    public Phone(TextureRegion texture) {
        this.texture = texture;

        position = new Vector2(
                Gdx.graphics.getWidth() - texture.getRegionWidth() - margin,
                margin
        );
    }
}
