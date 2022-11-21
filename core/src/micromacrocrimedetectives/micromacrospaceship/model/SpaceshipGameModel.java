package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class SpaceshipGameModel {
    public final Texture ufoTexture;
    public final Texture asteroidTexture;
    public final Rectangle ufoFrame;

    public final float ufoVelocity;
    public final float asteroidVelocity;

    public final ArrayList<Rectangle> projectiles;
    public final ArrayList<Rectangle> asteroids;
    public final Rectangle projectileTemplate;
    public final float projectileVelocity;

    public long lastShootTime;
    public final int shootDelay;

    public long lastAsteroidSpawnTime;
    public final int asteroidSpawnDelay;
    public int lastAsteroidSpawnPosition;
    public final int asteroidRows;

    public SpaceshipGameModel() {
        float ufoWindowGap = 20;

        ufoTexture = new Texture("ufo.png");
        ufoFrame = new Rectangle();
        ufoFrame.setWidth(ufoTexture.getWidth());
        ufoFrame.setHeight(ufoTexture.getHeight());
        ufoFrame.setX((Gdx.graphics.getWidth() - ufoFrame.width) / 2);
        ufoFrame.setY(ufoWindowGap);
        ufoVelocity = 300;

        projectiles = new ArrayList<>();
        float projectileSize = 32;
        projectileTemplate = new Rectangle();
        projectileTemplate.setWidth(projectileSize);
        projectileTemplate.setHeight(projectileSize);
        // x position is set by the controller, depending on x position of the ufo
        projectileTemplate.setY(ufoFrame.height + ufoWindowGap);
        projectileVelocity = 600;
        shootDelay = 400;

        asteroidVelocity = 200;
        asteroidTexture = new Texture("asteroid.png");
        asteroids = new ArrayList<>();
        asteroidSpawnDelay = 1000;
        asteroidRows = 6;
    }
}
