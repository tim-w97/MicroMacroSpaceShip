package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Step implements Disposable {
    public Texture mobileImage;
    public Circle area;
    public Music speech;
    public boolean solved;

    public Step(Texture mobileImage, Vector2 location, Music speech) {
        this.mobileImage = mobileImage;
        area = new Circle(location, 128);
        this.speech = speech;

        solved = false;
    }

    @Override
    public void dispose() {
        mobileImage.dispose();
        speech.dispose();
    }
}
