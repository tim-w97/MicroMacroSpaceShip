
package micromacrocrimedetectives.micromacrospaceship.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.audio.Mp3;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.SpaceshipGameController;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.objects.FriendlyBullet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceshipGameControllerTest {

    float delta = 1.0f;
    SpaceshipGameModel model;
    SpaceshipGameController controller;

    @BeforeEach
    public void init() {
        MicroMacroGame game = new MicroMacroGame();

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("MicroMacroSpaceShip");
        config.setWindowedMode(720, 480);
        config.setResizable(false);
        new Lwjgl3Application(game, config);

        model = new SpaceshipGameModel(game);
        controller = new SpaceshipGameController(model);
    }

    @Test
    public void movePlanetsBackgroundTest() {
        assertEquals(model.planetsBackground.y, 0);
        controller.movePlanetsBackground(delta);
        assertEquals(model.planetsBackground.y, -50);
        model.planetsBackground.y = -10000;
        controller.movePlanetsBackground(delta);
        assertEquals(model.planetsBackground.y, 0);
    }

    @Test
    public void moveUfoLeftTest() {
        model.ufo.frame.x = 0;
        controller.moveUfoLeft(delta);
        assertNotEquals(model.ufo.frame.x, 0);
        model.ufo.frame.x = -100;
        controller.moveUfoLeft(delta);
        assertEquals(model.ufo.frame.x, Gdx.graphics.getWidth());
    }

    @Test
    public void moveUfoRightTest() {
        model.ufo.frame.x = 0;
        controller.moveUfoRight(delta);
        assertNotNull(model.ufo.frame.x);
        model.ufo.frame.x = 480;
        controller.moveUfoRight(delta);
        assertEquals(model.ufo.frame.x, -model.ufo.frame.width);
    }

    @Test
    public void shootFriendlyBulletTest() {
        //long shootTime = TimeUtils.timeSinceMillis(model.ufo.lastShootTime);
        long shootTime = 401L;
        System.out.println(shootTime);
        //controller.shootFriendlyBullet();
        System.out.println(model.ufo.lastShootTime);
    }

    @Test
    public void moveFriendlyBulletsTest() {
        System.out.println(model.ufo.bullets);
        controller.moveFriendlyBullets(delta);
        System.out.println(model.ufo.bullets);
        //assertNotEquals(projectileList, model.ufo.bullets);
    }

    /*@Test
    public void checkForCollisionsTest(Screen screen) {
        System.out.println("Bullets: " + model.ufo.bullets);
        System.out.println("OpponentUfos: " + model.opponentUfos);
        System.out.println("OpponentBullets: " + model.opponentUfos.get(0).bullets);
        controller.checkForCollisions(screen);
        System.out.println("Bullets: " + model.ufo.bullets);
        System.out.println("OpponentUfos: " + model.opponentUfos);
        System.out.println("OpponentBullets: " + model.opponentUfos.get(0).bullets);
    }

    @Test
    public void drawElapsedTimeTest(SpriteBatch spriteBatch) {
        Label timeLabelBefore = model.elapsedTimeLabel;
        controller.drawElapsedTime(spriteBatch);
        assertNotEquals(timeLabelBefore, model.elapsedTimeLabel);
    }*/
}
