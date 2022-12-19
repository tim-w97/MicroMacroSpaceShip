package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import micromacrocrimedetectives.micromacrospaceship.model.objects.*;

import java.util.ArrayList;

public class SpaceshipGameModel {
    public PlanetsBackground planetsBackground;
    public Ufo ufo;
    public ArrayList<OpponentUfo> opponentUfos;
    public long lastOpponentUfoSpawn;
    public int opponentUfoSpawnDelay;
    public final ArrayList<FriendlyBullet> friendlyBullets;
    public long lastShootTime;
    public final int shootDelay;
    public final int asteroidRows;

    public Music spaceMusic;

    public GlyphLayout elapsedTimeLayout;
    public long elapsedTime;

    public SpaceshipGameModel() {
        planetsBackground = new PlanetsBackground();

        ufo = new Ufo();

        opponentUfos = new ArrayList<>();
        opponentUfoSpawnDelay = 3000;

        friendlyBullets = new ArrayList<>();
        shootDelay = 400;

        asteroidRows = 6;

        spaceMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/space music.mp3"));
        spaceMusic.setVolume(0.1f);

        elapsedTimeLayout = new GlyphLayout();
        elapsedTime = 1000 * 61;
    }

    public void dispose() {
        planetsBackground.dispose();
        ufo.dispose();
        spaceMusic.dispose();

        for (FriendlyBullet friendlyBullet : friendlyBullets) {
            friendlyBullet.dispose();
        }

        for (OpponentUfo opponentUfo : opponentUfos) {
            opponentUfo.dispose();
        }
    }
}
