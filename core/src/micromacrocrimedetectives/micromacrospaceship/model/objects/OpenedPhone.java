package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class OpenedPhone {
    public TextureRegion texture;
    public Rectangle frame;
    public float margin;

    public Texture caseTexture;

    public OpenedPhone(TextureRegion texture) {
        margin = 10;

        this.texture = texture;

        frame = new Rectangle(
                Gdx.graphics.getWidth() - texture.getRegionWidth() - margin,
                margin,
                texture.getRegionWidth(),
                texture.getRegionHeight()
        );

        caseTexture = new Texture("MicroMacroGame/cases/kneipe.png");
    }

    public void dispose() {
    }
}
