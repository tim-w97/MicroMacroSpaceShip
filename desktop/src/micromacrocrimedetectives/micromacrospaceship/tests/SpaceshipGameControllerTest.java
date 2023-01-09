
package micromacrocrimedetectives.micromacrospaceship.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.SpaceshipGameController;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.objects.FriendlyBullet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceshipGameControllerTest {
    SpaceshipGameModel model;
    SpaceshipGameController controller;
    float delta;
    MicroMacroGame game;

    SpaceshipGameControllerTest() {
        game = new MicroMacroGame();
        model = new SpaceshipGameModel(game);
        controller = new SpaceshipGameController(model);
        delta = 1.0f;
    }

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
        long shootTime = TimeUtils.timeSinceMillis(model.ufo.lastShootTime);
        shootTime = 401L;
        System.out.println(shootTime);
        // TODO: controller.shootProjectile() kann nicht ausgeführt werden
        controller.shootFriendlyBullet();
        System.out.println(model.ufo.lastShootTime);
    }
    @Test
    public void moveFriendlyBulletsTest() {
        ArrayList<FriendlyBullet> projectileList = model.ufo.bullets;
        controller.moveFriendlyBullets(delta);
        assertEquals(projectileList, model.ufo.bullets);
    }
}
