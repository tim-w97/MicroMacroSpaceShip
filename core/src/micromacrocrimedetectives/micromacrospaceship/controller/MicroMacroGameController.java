package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

    // 2 * PI = 360 Degrees
    public void goDiagonalLeft(float delta) {
        model.bongoBob.direction = Direction.LEFT;

        model.cameraPosition.x -= delta * model.bongoBob.velocity;
        model.cameraPosition.y -= model.mapWalkFactor * delta * model.bongoBob.velocity;
    }

    public void goDiagonalRight(float delta) {
        model.bongoBob.direction = Direction.RIGHT;

        model.cameraPosition.x += delta * model.bongoBob.velocity;
        model.cameraPosition.y += model.mapWalkFactor * delta * model.bongoBob.velocity;
    }

    public void goDiagonalUp(float delta) {
        model.bongoBob.direction = Direction.UP;

        model.cameraPosition.x -= delta * model.bongoBob.velocity;
        model.cameraPosition.y += model.mapWalkFactor * delta * model.bongoBob.velocity;
    }

    public void goDiagonalDown(float delta) {
        model.bongoBob.direction = Direction.DOWN;

        model.cameraPosition.x += delta * model.bongoBob.velocity;
        model.cameraPosition.y -= model.mapWalkFactor * delta * model.bongoBob.velocity;
    }

    public void drawBongoBob(SpriteBatch batch) {
        TextureRegion ring = model.bongoBob.ringAnimation.getKeyFrame(model.bongoBob.ringStateTime);

        batch.draw(
                ring,
                model.bongoBob.frame.x,
                model.bongoBob.frame.y
        );

        batch.draw(
                model.bongoBob.bodyTextures.get(model.bongoBob.direction),
                model.bongoBob.frame.x,
                model.bongoBob.frame.y
        );

        // only draw face if BongoBob walks down
        if (model.bongoBob.direction == Direction.DOWN) {
            batch.draw(
                    model.bongoBob.face,
                    model.bongoBob.frame.x,
                    model.bongoBob.frame.y
            );
        }
    }

    public void playerMoves(float delta) {
        model.bongoBob.frame.x = model.cameraPosition.x - model.bongoBob.frame.width / 2f;
        model.bongoBob.frame.y = model.cameraPosition.y - model.bongoBob.frame.height / 2f;

        model.bongoBob.ringStateTime += delta;
    }

    public void drawPhone(SpriteBatch batch) {
        batch.draw(
                model.phone.texture,
                model.phone.position.x,
                model.phone.position.y
        );
    }
}
