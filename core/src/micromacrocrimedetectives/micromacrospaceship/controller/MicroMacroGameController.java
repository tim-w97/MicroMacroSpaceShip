package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import micromacrocrimedetectives.micromacrospaceship.Direction;
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
        model.bongoBob.direction = Direction.LEFT;
        model.cameraPosition.x -= delta * model.bongoBob.velocity;
    }

    public void goRight(float delta) {
        model.bongoBob.direction = Direction.RIGHT;
        model.cameraPosition.x += delta * model.bongoBob.velocity;
    }

    public void goUp(float delta) {
        model.bongoBob.direction = Direction.UP;
        model.cameraPosition.y += delta * model.bongoBob.velocity;
    }

    public void goDown(float delta) {
        model.bongoBob.direction = Direction.DOWN;
        model.cameraPosition.y -= delta * model.bongoBob.velocity;
    }

    public void drawBongoBob(SpriteBatch batch) {
        batch.draw(
                model.bongoBob.textures.get(model.bongoBob.direction),
                model.cameraPosition.x - model.bongoBob.texture.getWidth() / 2f,
                model.cameraPosition.y - model.bongoBob.texture.getHeight() / 2f
        );
    }
}
