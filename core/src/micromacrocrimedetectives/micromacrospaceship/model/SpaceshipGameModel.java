package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.model.objects.OpponentUfo;
import micromacrocrimedetectives.micromacrospaceship.model.objects.PlanetsBackground;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Ufo;

import java.util.ArrayList;

public class SpaceshipGameModel {
    public MicroMacroGame game;

    public PlanetsBackground planetsBackground;
    public Ufo ufo;
    public ArrayList<OpponentUfo> opponentUfos;
    public long lastOpponentUfoSpawn;
    public int opponentUfoSpawnDelay;

    public Music spaceMusic;
    public long elapsedTime;

    public Label elapsedTimeLabel;

    public SpaceshipGameModel(MicroMacroGame game) {
        this.game = game;

        planetsBackground = new PlanetsBackground(game.assets);

        ufo = new Ufo(game.assets);

        opponentUfos = new ArrayList<>();
        opponentUfoSpawnDelay = 3000;

        spaceMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/space music.mp3"));
        spaceMusic.setVolume(0.1f);

        elapsedTime = 1000 * 4;

        elapsedTimeLabel = new Label(null, game.assets.skin);
        elapsedTimeLabel.setWidth(Gdx.graphics.getWidth());
        elapsedTimeLabel.setAlignment(Align.center);
        elapsedTimeLabel.setY(Gdx.graphics.getHeight() - 20);
    }

    public void dispose() {
        planetsBackground.dispose();
        ufo.dispose();
        spaceMusic.dispose();

        for (OpponentUfo opponentUfo : opponentUfos) {
            opponentUfo.dispose();
        }
    }
}
