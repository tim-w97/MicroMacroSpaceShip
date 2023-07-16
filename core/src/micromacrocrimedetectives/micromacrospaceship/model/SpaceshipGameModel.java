package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.model.objects.OpponentUfo;
import micromacrocrimedetectives.micromacrospaceship.model.objects.PlanetsBackground;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Ufo;

import java.util.ArrayList;

public class SpaceshipGameModel implements Disposable {
    public MicroMacroGame game;

    public PlanetsBackground planetsBackground;
    public Ufo ufo;
    public ArrayList<OpponentUfo> opponentUfos;
    public long lastOpponentUfoSpawn;
    public int opponentUfoSpawnDelay;

    public Music backgroundMusic;
    public long elapsedTime;

    public Label elapsedTimeLabel;

    public SpaceshipGameModel(MicroMacroGame game) {
        this.game = game;

        planetsBackground = new PlanetsBackground();

        ufo = new Ufo();

        opponentUfos = new ArrayList<>();
        opponentUfoSpawnDelay = 3000;

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/djenty_808.mp3"));
        backgroundMusic.setVolume(0.03f);

        elapsedTime = 1000 * 31;

        elapsedTimeLabel = new Label(null, game.skin);
        elapsedTimeLabel.setWidth(Gdx.graphics.getWidth());
        elapsedTimeLabel.setAlignment(Align.center);
        elapsedTimeLabel.setY(Gdx.graphics.getHeight() - 20);
    }

    @Override
    public void dispose() {
        planetsBackground.dispose();
        ufo.dispose();
        backgroundMusic.dispose();

        for (Disposable opponentUfo : opponentUfos) {
            opponentUfo.dispose();
        }
    }
}
