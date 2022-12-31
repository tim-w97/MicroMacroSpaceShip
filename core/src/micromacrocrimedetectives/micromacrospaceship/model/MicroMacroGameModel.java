package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import micromacrocrimedetectives.micromacrospaceship.model.cases.Case;
import micromacrocrimedetectives.micromacrospaceship.model.cases.Step;
import micromacrocrimedetectives.micromacrospaceship.model.objects.BongoBob;
import micromacrocrimedetectives.micromacrospaceship.model.objects.MiniMap;
import micromacrocrimedetectives.micromacrospaceship.model.objects.ClosedPhone;
import micromacrocrimedetectives.micromacrospaceship.model.objects.OpenedPhone;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;

import java.util.ArrayList;
import java.util.List;

public class MicroMacroGameModel {
    public BongoBob bongoBob;

    public OpenedPhone openedPhone;
    public ClosedPhone closedPhone;

    public MiniMap miniMap;

    public Vector3 cameraPosition;

    public Texture map;

    public float mapWalkFactor;

    public Music spaceshipAmbienceMusic;

    public Sound welcomeMessage;
    public Sound fernandoCase;
    public boolean phoneIsClosed;

    // TODO: Dispose cases with sounds etc.
    public List<Case> cases;

    public MicroMacroGameModel() {
        openedPhone = new OpenedPhone(MicroMacroAssets.getInstance().atlas.findRegion("Phone/opened"));
        closedPhone = new ClosedPhone(MicroMacroAssets.getInstance().atlas.findRegion("Phone/closed"));

        bongoBob = new BongoBob();

        miniMap = new MiniMap();

        cameraPosition = new Vector3();

        mapWalkFactor = (float) (Math.PI / 180 * 33);

        map = MicroMacroAssets.getInstance().map;

        spaceshipAmbienceMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/spaceship ambience.mp3"));
        spaceshipAmbienceMusic.setVolume(0.3f);

        welcomeMessage = Gdx.audio.newSound(Gdx.files.internal("sounds/welcome.mp3"));
        fernandoCase = Gdx.audio.newSound(Gdx.files.internal("sounds/cases/fernando.mp3"));

        phoneIsClosed = true;

        initCases();
    }

    private void initCases() {
        cases = new ArrayList<>();

        Case fernandoCase = new Case();

        fernandoCase.addStep(new Step(
                MicroMacroAssets.getInstance().atlas.findRegion("Cases/fernando", 1),
                new Vector2(10271, 6075)
        ));

        fernandoCase.addStep(new Step(
                MicroMacroAssets.getInstance().atlas.findRegion("Cases/fernando", 2),
                new Vector2(12004, 7245)
        ));

        fernandoCase.addStep(new Step(
                MicroMacroAssets.getInstance().atlas.findRegion("Cases/fernando", 3),
                new Vector2(11353, 6778)
        ));

        fernandoCase.addStep(new Step(
                MicroMacroAssets.getInstance().atlas.findRegion("Cases/fernando", 4),
                new Vector2(10389, 7303)
        ));
    }

    public void dispose() {
        bongoBob.dispose();
        closedPhone.dispose();
        miniMap.dispose();
        map.dispose();
        spaceshipAmbienceMusic.dispose();
        welcomeMessage.dispose();
        fernandoCase.dispose();
    }
}
