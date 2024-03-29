package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class MiniMap implements Disposable {
    public Texture background;
    public Texture bongoBob;

    public Vector2 position;
    public Vector2 bongoBobPosition;
    public Vector2 hintPosition;
    public Vector2 mapUfoPosition;

    public float margin;

    public Texture hint;
    public Texture mapUfo;

    public MiniMap() {
        margin = 10;

        background = new Texture("images/micro-macro-game/mini-map/background.png");
        bongoBob = new Texture("images/micro-macro-game/mini-map/bongo-bob.png");

        position = new Vector2(
                margin,
                Gdx.graphics.getHeight() - background.getHeight() - margin
        );

        bongoBobPosition = new Vector2();
        hintPosition = new Vector2();
        mapUfoPosition = new Vector2();

        hint = new Texture("images/micro-macro-game/mini-map/hint.png");
        mapUfo = new Texture("images/micro-macro-game/mini-map/map-ufo.png");
    }

    @Override
    public void dispose() {
        background.dispose();
        hint.dispose();
        bongoBob.dispose();
        mapUfo.dispose();
    }
}
