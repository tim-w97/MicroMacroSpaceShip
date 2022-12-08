package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MiniMap {
    public TextureRegion texture;

    public Vector2 position;

    public float margin;

    public MiniMap(TextureRegion texture) {
        margin = 10;

        this.texture = texture;

        position = new Vector2(
                margin,
                Gdx.graphics.getHeight() - texture.getRegionHeight() - margin
        );
    }
}
