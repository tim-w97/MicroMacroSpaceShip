package micromacrocrimedetectives.micromacrospaceship.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DummyTest {
    @BeforeAll
    public static void init() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("MicroMacroSpaceShip");
        config.setWindowedMode(720, 480);
        config.setResizable(false);
        new Lwjgl3Application(new MicroMacroGame(), config);
    }

    @Test
    public void textureTest() {
        Texture dummyTexture = new Texture(Gdx.files.internal("ufo.png"));
        assertNotNull(dummyTexture);
    }

    @Test
    public void soundTest() {
        Sound dummySound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
        assertNotNull(dummySound);
    }
}
