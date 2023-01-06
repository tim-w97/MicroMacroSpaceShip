package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.Direction;
import micromacrocrimedetectives.micromacrospaceship.model.MicroMacroGameModel;

public class MicroMacroGameController implements Disposable {
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
        Texture ring = model.bongoBob.ringAnimation.getKeyFrame(model.bongoBob.ringAnimationStateTime);

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
        model.bongoBob.ringAnimationStateTime += delta;

        setMiniMapBongoBobPosition();
    }

    private void setMiniMapBongoBobPosition() {
        model.miniMap.bongoBobPosition.x = model.miniMap.margin
                + model.cameraPosition.x
                / model.map.getWidth()
                * (model.miniMap.background.getWidth()
                - model.miniMap.bongoBob.getWidth());


        model.miniMap.bongoBobPosition.y = Gdx.graphics.getHeight()
                - model.miniMap.margin
                - model.miniMap.background.getHeight()
                + model.cameraPosition.y
                / model.map.getHeight()
                * (model.miniMap.background.getHeight()
                - model.miniMap.bongoBob.getHeight());
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
        Texture mobileImage;

        if (model.currentCase.beginningSpeechPlayed) {
            mobileImage = model.currentCase.currentStep.mobileImage;
        } else {
            mobileImage = model.currentCase.cover;
        }

        batch.draw(
                mobileImage,
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
                model.miniMap.hint,
                model.miniMap.hintPosition.x,
                model.miniMap.hintPosition.y
        );

        batch.draw(
                model.miniMap.bongoBob,
                model.miniMap.bongoBobPosition.x,
                model.miniMap.bongoBobPosition.y
        );
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

        // player opens phone
        if (model.phoneIsClosed && model.closedPhone.frame.contains(cursorPosition)) {
            model.foundHintLabelIsVisible = false;
            model.phoneIsClosed = false;

            if (model.currentCase.beginningSpeechPlayed) {
                model.currentCase.currentStep.speech.play();
            } else {
                model.currentCase.beginningSpeech.play();
                model.currentCase.beginningSpeech.setOnCompletionListener(music -> {
                    model.currentCase.beginningSpeechPlayed = true;
                    model.currentCase.currentStep.speech.play();
                });
            }


            // player closes phone
        } else if (!model.phoneIsClosed && model.openedPhone.frame.contains(cursorPosition)) {
            model.phoneIsClosed = true;
        }
    }

    public void checkForCaseStepAreaCollision() {
        if (model.currentCase.caseIsSolved) {
            return;
        }

        if (model.currentCase.currentStep.area.contains(
                model.cameraPosition.x,
                model.cameraPosition.y
        )) {
            boolean allStepsSolved = moveToNextStep();

            if (allStepsSolved) {
                model.caseSolvedSound.play();
                model.currentCase.caseIsSolved = true;
                //moveToNextCase();
            } else {
                model.foundHintLabelIsVisible = true;
                model.foundHintSound.play();
                setMiniMapHintPosition();
            }

            model.phoneIsClosed = true;
        }
    }

    public boolean moveToNextStep() {
        int index = model.currentCase.steps.indexOf(model.currentCase.currentStep);

        index++;

        if (index == model.currentCase.steps.size()) {
            return true;
        }

        model.currentCase.currentStep = model.currentCase.steps.get(index);
        return false;
    }

    private void moveToNextCase() {
        int index = model.cases.indexOf(model.currentCase);

        index++;

        if (index == model.cases.size()) {
            return;
        }

        model.currentCase = model.cases.get(index);
    }

    private void setMiniMapHintPosition() {
        model.miniMap.hintPosition.x = model.miniMap.margin
                + model.currentCase.currentStep.area.x
                / model.map.getWidth()
                * (model.miniMap.background.getWidth()
                - model.miniMap.hint.getWidth());


        model.miniMap.hintPosition.y = Gdx.graphics.getHeight()
                - model.miniMap.margin
                - model.miniMap.background.getHeight()
                + model.currentCase.currentStep.area.y
                / model.map.getHeight()
                * (model.miniMap.background.getHeight()
                - model.miniMap.hint.getWidth());
    }

    public void activateTurboDrive() {
        model.bongoBob.velocity = model.bongoBob.turboVelocity;
    }

    public void deactivateTurboDrive() {
        model.bongoBob.velocity = model.bongoBob.defaultVelocity;
    }

    public void initMicroMacroGame() {
        setMiniMapBongoBobPosition();
        setMiniMapHintPosition();

        model.spaceshipAmbienceMusic.setLooping(true);
        model.spaceshipAmbienceMusic.play();

        model.welcomeSound.play();
    }

    public void drawFoundHintLabel(SpriteBatch batch) {
        if (model.foundHintLabelIsVisible) {
            model.foundHintLabel.draw(batch, 1f);
        }
    }

    @Override
    public void dispose() {
        model.dispose();
    }
}
