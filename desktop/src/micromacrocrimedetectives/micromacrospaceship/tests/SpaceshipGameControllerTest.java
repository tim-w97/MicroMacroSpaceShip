/*
package micromacrocrimedetectives.micromacrospaceship.tests;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.controller.SpaceshipGameController;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpaceshipGameControllerTest {
    SpaceshipGameModel model;
    SpaceshipGameController controller;
    float delta;

    SpaceshipGameControllerTest() {
        model = new SpaceshipGameModel();
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
    public void getPlanetsBackgroundTest() {
        assertEquals(controller.getPlanetsBackground(), model.planetsBackground);
    }

    @Test
    public void movePlanetsBackgroundTest() {
        assertEquals(model.planetsBackground.y, 0);
        controller.movePlanetsBackground(delta);
        assertEquals(model.planetsBackground.y, -50);
    }
}
*/