package micromacrocrimedetectives.micromacrospaceship.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Ufo {
    private final Texture texture;
    private final Rectangle frame;

    private final float velocity = 500;

    public Ufo() {
        texture = new Texture("ufo.png");

        frame = new Rectangle();
        frame.setWidth(texture.getWidth());
        frame.setHeight(texture.getHeight());
        frame.x = (Gdx.graphics.getWidth() - frame.width) / 2;
        frame.y = 100;
    }

    public void moveWhenUserInput(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            frame.x -= delta * velocity;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            frame.x += delta * velocity;
        }

        if (frame.x < -frame.width) {
            frame.x = Gdx.graphics.getWidth();
        }

        if (frame.x > Gdx.graphics.getWidth()) {
            frame.x = -frame.width;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, frame.x, frame.y);
    }
}
