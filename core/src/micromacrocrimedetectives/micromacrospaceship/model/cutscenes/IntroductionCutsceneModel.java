package micromacrocrimedetectives.micromacrospaceship.model.cutscenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

import java.util.ArrayList;
import java.util.List;

public class IntroductionCutsceneModel implements Disposable {
    public MicroMacroGame game;
    public Texture currentSlide;
    public Music currentSpeech;

    public int index;
    public List<Texture> slides;
    public List<Music> speeches;

    public Stage stage;
    public TextButton startButton;

    public IntroductionCutsceneModel(MicroMacroGame game) {
        this.game = game;

        index = 0;

        slides = new ArrayList<>();
        speeches = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            slides.add(new Texture("images/cutscenes/introduction/slide_" + i + ".png"));

            speeches.add(Gdx.audio.newMusic(
                    Gdx.files.internal("sounds/speech/cutscenes/introduction/speech_" + i + ".mp3"))
            );
        }

        currentSlide = slides.get(index);
        currentSpeech = speeches.get(index);

        startButton = new TextButton("Start", game.skin);
        startButton.setSize(200, 60);

        startButton.setPosition(
                (Gdx.graphics.getWidth() - startButton.getWidth()) / 2,
                50
        );

        stage = new Stage();
        stage.addActor(startButton);
        Gdx.input.setInputProcessor(stage);
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
