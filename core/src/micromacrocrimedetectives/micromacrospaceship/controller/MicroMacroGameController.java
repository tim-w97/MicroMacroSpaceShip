package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.objects.MapTile;

public class MicroMacroGameController {
    private final MicroMacroGameModel model;

    public MicroMacroGameController(MicroMacroGameModel model) {
        this.model = model;
    }

    public Vector3 getCameraPosition() {
        return model.cameraPosition;
    }

    public void drawMap(SpriteBatch batch) {

        for (int h = 0; h < model.horizontalMapTilesCount; h++) {
            for (int v = 0; v < model.verticalMapTilesCount; v++) {
                MapTile tile = model.mapTiles[v][h];

                batch.draw(
                        tile.texture,
                        tile.x,
                        tile.y,
                        tile.width,
                        tile.height
                );
            }
        }
    }

    public void goLeft(float delta) {
        model.cameraPosition.x -= delta * model.bongoBob.velocity;
    }

    public void goRight(float delta) {
        model.cameraPosition.x += delta * model.bongoBob.velocity;
    }

    public void goUp(float delta) {
        model.cameraPosition.y += delta * model.bongoBob.velocity;
    }

    public void goDown(float delta) {
        model.cameraPosition.y -= delta * model.bongoBob.velocity;
    }
}