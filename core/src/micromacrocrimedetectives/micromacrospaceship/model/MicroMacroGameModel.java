package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.model.cases.Case;
import micromacrocrimedetectives.micromacrospaceship.model.cases.Step;
import micromacrocrimedetectives.micromacrospaceship.model.objects.*;

import java.util.ArrayList;
import java.util.List;

public class MicroMacroGameModel implements Disposable {
    public MicroMacroGame game;

    public BongoBob bongoBob;

    public OpenedPhone openedPhone;
    public ClosedPhone closedPhone;

    public MapUfo mapUfo;

    public MiniMap miniMap;

    public Vector3 cameraPosition;

    public Texture map;

    public float mapWalkFactor;

    public Music foundHintSound;
    public Music welcomeSound;
    public Sound caseSolvedSound;
    public Music backgroundMusic;

    public boolean phoneIsClosed;

    public List<Case> cases;
    public Case currentCase;

    public Label foundHintLabel;
    public boolean foundHintLabelIsVisible;

    public MicroMacroGameModel(MicroMacroGame game) {
        this.game = game;

        openedPhone = new OpenedPhone();
        closedPhone = new ClosedPhone();

        bongoBob = new BongoBob();

        mapUfo = new MapUfo();

        miniMap = new MiniMap();

        map = new Texture("images/map.jpg");

        cameraPosition = new Vector3(
                6712,
                4455,
                0
        );

        mapWalkFactor = (float) (Math.PI / 180 * 33);

        backgroundMusic = Gdx.audio.newMusic(
                Gdx.files.internal("audio/music/running_from_the_evil_doom2_m1_cover.mp3")
        );

        backgroundMusic.setVolume(0.01f);

        phoneIsClosed = true;

        initCases();

        foundHintLabel = new Label("Du hast den Ort gefunden!", game.skin);
        foundHintLabel.setFontScale(2f);
        foundHintLabel.setPosition(20, 20);
        foundHintLabelIsVisible = false;

        foundHintSound = Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/found-hint.mp3"));
        welcomeSound = Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/welcome.mp3"));
        caseSolvedSound = Gdx.audio.newSound(Gdx.files.internal("audio/sounds/speech/case-solved.mp3"));
    }

    private void initCases() {
        cases = new ArrayList<>();

        Case cylinderCase = new Case(
                new Texture("images/micro-macro-game/cases/cylinder/cover.png"),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/cylinder/beginning-speech.mp3")),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/cylinder/final-speech.mp3"))
        );

        cylinderCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/cylinder/step_1.png"),
                new Vector2(10271, 6075),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/cylinder/step_1.mp3"))
        ));

        cylinderCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/cylinder/step_2.png"),
                new Vector2(12004, 7245),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/cylinder/step_2.mp3"))
        ));

        cylinderCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/cylinder/step_3.png"),
                new Vector2(11353, 6778),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/cylinder/step_3.mp3"))
        ));

        cylinderCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/cylinder/step_4.png"),
                new Vector2(10389, 7303),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/cylinder/step_4.mp3"))
        ));

        Case carAccidentCase = new Case(
                new Texture("images/micro-macro-game/cases/car-accident/cover.png"),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/car-accident/beginning-speech.mp3")),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/car-accident/final-speech.mp3"))
        );

        carAccidentCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/car-accident/step_1.png"),
                new Vector2(10078, 3215),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/car-accident/step_1.mp3"))
        ));

        carAccidentCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/car-accident/step_2.png"),
                new Vector2(12740, 5575),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/car-accident/step_2.mp3"))
        ));

        carAccidentCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/car-accident/step_3.png"),
                new Vector2(12716, 6161),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/car-accident/step_3.mp3"))
        ));

        carAccidentCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/car-accident/step_4.png"),
                new Vector2(10528, 6271),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/car-accident/step_4.mp3"))
        ));

        Case bankRobberyCase = new Case(
                new Texture("images/micro-macro-game/cases/bank-robbery/cover.png"),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/bank-robbery/beginning-speech.mp3")),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/bank-robbery/final-speech.mp3"))
        );

        bankRobberyCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/bank-robbery/step_1.png"),
                new Vector2(2412, 6477),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/bank-robbery/step_1.mp3"))
        ));

        bankRobberyCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/bank-robbery/step_2.png"),
                new Vector2(928, 5271),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/bank-robbery/step_2.mp3"))
        ));

        bankRobberyCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/bank-robbery/step_3.png"),
                new Vector2(1460, 4593),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/bank-robbery/step_3.mp3"))
        ));

        bankRobberyCase.addStep(new Step(
                new Texture("images/micro-macro-game/cases/bank-robbery/step_4.png"),
                new Vector2(12748, 4453),
                Gdx.audio.newMusic(Gdx.files.internal("audio/sounds/speech/cases/bank-robbery/step_4.mp3"))
        ));

        cases.add(cylinderCase);
        cases.add(carAccidentCase);
        cases.add(bankRobberyCase);
    }

    @Override
    public void dispose() {
        bongoBob.dispose();
        openedPhone.dispose();
        closedPhone.dispose();
        miniMap.dispose();
        map.dispose();
        backgroundMusic.dispose();
        welcomeSound.dispose();
        foundHintSound.dispose();
        caseSolvedSound.dispose();

        for (Disposable disposableCase : cases) {
            disposableCase.dispose();
        }
    }
}
