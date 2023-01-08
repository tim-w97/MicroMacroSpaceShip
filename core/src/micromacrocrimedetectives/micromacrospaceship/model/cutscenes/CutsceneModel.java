package micromacrocrimedetectives.micromacrospaceship.model.cutscenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

import java.util.ArrayList;
import java.util.List;

abstract public class CutsceneModel implements Disposable {
    public MicroMacroGame game;
    public Texture currentSlide;
    public Music currentSpeech;

    public int index;
    public List<Texture> slides;
    public List<Music> speeches;

    public Stage stage;
    public TextButton button;

    public Screen newScreenToSwitch;

    public CutsceneModel(
            MicroMacroGame game,
            int numberOfSlides,
            String cutsceneKey,
            String buttonText,
            Screen newScreenToSwitch) {
        this.game = game;
        index = 0;

        slides = new ArrayList<>();
        speeches = new ArrayList<>();

        for (int i = 1; i <= numberOfSlides; i++) {
            slides.add(new Texture(
                    "images/cutscenes/" + cutsceneKey + "/slide_" + i + ".png"
            ));

            speeches.add(Gdx.audio.newMusic(Gdx.files.internal(
                    "sounds/speech/cutscenes/" + cutsceneKey + "/speech_" + i + ".mp3"
            )));
        }

        currentSlide = slides.get(index);
        currentSpeech = speeches.get(index);

        button = new TextButton(buttonText, game.skin);
        button.setSize(200, 60);

        button.setPosition(
                (Gdx.graphics.getWidth() - button.getWidth()) / 2,
                70
        );

        stage = new Stage();
        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);

        this.newScreenToSwitch = newScreenToSwitch;
    }

    @Override
    public void dispose() {
        stage.dispose();
        currentSlide.dispose();
        currentSpeech.dispose();
        slides.forEach(Texture::dispose);
        speeches.forEach(Music::dispose);
    }
}
