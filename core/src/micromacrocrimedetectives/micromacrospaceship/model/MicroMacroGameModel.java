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
import micromacrocrimedetectives.micromacrospaceship.model.objects.BongoBob;
import micromacrocrimedetectives.micromacrospaceship.model.objects.ClosedPhone;
import micromacrocrimedetectives.micromacrospaceship.model.objects.MiniMap;
import micromacrocrimedetectives.micromacrospaceship.model.objects.OpenedPhone;

import java.util.ArrayList;
import java.util.List;

public class MicroMacroGameModel implements Disposable {
    public MicroMacroGame game;

    public BongoBob bongoBob;

    public OpenedPhone openedPhone;
    public ClosedPhone closedPhone;

    public MiniMap miniMap;

    public Vector3 cameraPosition;

    public Texture map;

    public float mapWalkFactor;

    public Sound foundHintSound;
    public Sound welcomeSound;
    public Sound caseSolvedSound;
    public Music spaceshipAmbienceMusic;

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

        miniMap = new MiniMap();

        cameraPosition = new Vector3();

        mapWalkFactor = (float) (Math.PI / 180 * 33);

        map = new Texture("images/map.jpg");

        spaceshipAmbienceMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/spaceship ambience.mp3"));
        spaceshipAmbienceMusic.setVolume(0.3f);

        phoneIsClosed = true;

        initCases();
        currentCase = cases.get(0);

        foundHintLabel = new Label("Du hast den Ort gefunden!", game.skin);
        foundHintLabel.setFontScale(2f);
        foundHintLabel.setPosition(20, 20);
        foundHintLabelIsVisible = false;

        foundHintSound = Gdx.audio.newSound(Gdx.files.internal("sounds/speech/found-hint.mp3"));
        welcomeSound = Gdx.audio.newSound(Gdx.files.internal("sounds/speech/welcome.mp3"));
        caseSolvedSound = Gdx.audio.newSound(Gdx.files.internal("sounds/speech/case-solved.mp3"));
    }

    private void initCases() {
        cases = new ArrayList<>();

        Case cylinderCase = new Case(
                List.of(
                        new Step(
                                new Texture("images/micro-macro-game/cases/cylinder/step_1.png"),
                                new Vector2(10271, 6075)
                        ),
                        new Step(
                                new Texture("images/micro-macro-game/cases/cylinder/step_2.png"),
                                new Vector2(12004, 7245)
                        ),
                        new Step(
                                new Texture("images/micro-macro-game/cases/cylinder/step_3.png"),
                                new Vector2(11353, 6778)
                        ),
                        new Step(
                                new Texture("images/micro-macro-game/cases/cylinder/step_4.png"),
                                new Vector2(10389, 7303)
                        )
                ),
                new Texture("images/micro-macro-game/cases/cylinder/cover.png")
        );

        cases.add(cylinderCase);
    }

    @Override
    public void dispose() {
        bongoBob.dispose();
        openedPhone.dispose();
        closedPhone.dispose();
        miniMap.dispose();
        map.dispose();
        spaceshipAmbienceMusic.dispose();
        welcomeSound.dispose();
        foundHintSound.dispose();
        caseSolvedSound.dispose();

        // TODO: Dispose Cases!
    }
}
