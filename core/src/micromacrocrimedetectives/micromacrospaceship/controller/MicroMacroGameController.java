package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import micromacrocrimedetectives.micromacrospaceship.Direction;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroGameModel;

public class MicroMacroGameController {
    private final MicroMacroGameModel model;

    public MicroMacroGameController(MicroMacroGameModel model) {
        this.model = model;
    }

    public Vector3 getCameraPosition() {
        return model.cameraPosition;
    }

    public void drawMap(SpriteBatch batch) {
        batch.draw(model.map, 0, 0);
    }

    private void correctCameraPosition() {
        if (model.cameraPosition.x < 0) {
            model.cameraPosition.x = 0;
        }

        if (model.cameraPosition.y < 0) {
            model.cameraPosition.y = 0;
        }

        if (model.cameraPosition.x > model.map.getWidth()) {
            model.cameraPosition.x = model.map.getWidth();
        }

        if (model.cameraPosition.y > model.map.getHeight()) {
            model.cameraPosition.y = model.map.getHeight();
        }
    }

    public void goLeft(float delta) {
        model.bongoBob.direction = Direction.LEFT;
        model.cameraPosition.x -= delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    public void goRight(float delta) {
        model.bongoBob.direction = Direction.RIGHT;
        model.cameraPosition.x += delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    public void goUp(float delta) {
        model.bongoBob.direction = Direction.UP;
        model.cameraPosition.y += delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    public void goDown(float delta) {
        model.bongoBob.direction = Direction.DOWN;
        model.cameraPosition.y -= delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    // 2 * PI = 360 Degrees
    public void goDiagonalLeft(float delta) {
        model.bongoBob.direction = Direction.LEFT;

        model.cameraPosition.x -= delta * model.bongoBob.velocity;
        model.cameraPosition.y -= model.mapWalkFactor * delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    public void goDiagonalRight(float delta) {
        model.bongoBob.direction = Direction.RIGHT;

        model.cameraPosition.x += delta * model.bongoBob.velocity;
        model.cameraPosition.y += model.mapWalkFactor * delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    public void goDiagonalUp(float delta) {
        model.bongoBob.direction = Direction.UP;

        model.cameraPosition.x -= delta * model.bongoBob.velocity;
        model.cameraPosition.y += model.mapWalkFactor * delta * model.bongoBob.velocity;

        correctCameraPosition();
    }

    public void goDiagonalDown(float delta) {
        model.bongoBob.direction = Direction.DOWN;

        model.cameraPosition.x += delta * model.bongoBob.velocity;
        model.cameraPosition.y -= model.mapWalkFactor * delta * model.bongoBob.velocity;

        correctCameraPosition();
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
        model.bongoBob.ringStateTime += delta;

        refreshMiniMap();
    }

    private void refreshMiniMap() {
        model.miniMap.bongoBobPosition.x = model.miniMap.margin +
                model.cameraPosition.x / model.map.getWidth()
                        * (model.miniMap.background.getRegionWidth() - model.miniMap.bongoBob.getRegionWidth());


        model.miniMap.bongoBobPosition.y = Gdx.graphics.getHeight() - model.miniMap.margin
                - model.miniMap.background.getRegionHeight() +
                model.cameraPosition.y
                        / model.map.getHeight() * (model.miniMap.background.getRegionHeight()
                        - model.miniMap.bongoBob.getRegionHeight());
    }

    public void drawPhone(SpriteBatch batch) {
        if (model.phoneIsClosed) {
            batch.draw(
                    model.closedPhone.texture,
                    model.closedPhone.frame.x,
                    model.closedPhone.frame.y
            );

            return;
        }

        batch.draw(
                model.openedPhone.texture,
                model.openedPhone.frame.x,
                model.openedPhone.frame.y
        );

        // draw the current case
        batch.draw(
                model.openedPhone.caseTexture,
                model.openedPhone.frame.x,
                model.openedPhone.frame.y
        );

    }

    public void drawMiniMap(SpriteBatch batch) {
        batch.draw(
                model.miniMap.background,
                model.miniMap.position.x,
                model.miniMap.position.y
        );

        batch.draw(
                model.miniMap.bongoBob,
                model.miniMap.bongoBobPosition.x,
                model.miniMap.bongoBobPosition.y
        );
    }

    public void playSpaceshipAmbienceMusic() {
        model.spaceshipAmbienceMusic.setLooping(true);
        model.spaceshipAmbienceMusic.play();
    }

    public void playRobotSound() {
        if (!model.bongoBob.robotMakesSound) {
            model.bongoBob.robotMakesSound = true;
            model.bongoBob.robotSound.resume();
        }
    }

    public void stopRobotSound() {
        model.bongoBob.robotMakesSound = false;
        model.bongoBob.robotSound.pause();
    }

    private Vector2 getUnprojectedCursorPosition(OrthographicCamera camera) {
        Vector3 cursorPosition = new Vector3(
                Gdx.input.getX(),
                Gdx.input.getY(),
                0
        );

        Vector3 unprojectedCursorPosition = camera.unproject(cursorPosition);

        return new Vector2(unprojectedCursorPosition.x, unprojectedCursorPosition.y);
    }

    public void setCursor(OrthographicCamera camera) {
        Vector2 cursorPosition = getUnprojectedCursorPosition(camera);

        if (model.phoneIsClosed && model.closedPhone.frame.contains(cursorPosition) ||
                !model.phoneIsClosed && model.openedPhone.frame.contains(cursorPosition)) {
            Gdx.graphics.setSystemCursor(SystemCursor.Hand);
        } else {
            Gdx.graphics.setSystemCursor(SystemCursor.Arrow);
        }
    }

    public void handleUserClick(OrthographicCamera camera) {
        Vector2 cursorPosition = getUnprojectedCursorPosition(camera);

        if (model.phoneIsClosed && model.closedPhone.frame.contains(cursorPosition)) {
            model.phoneIsClosed = false;
        } else if (!model.phoneIsClosed && model.openedPhone.frame.contains(cursorPosition)) {
            model.phoneIsClosed = true;
        }
    }
}
