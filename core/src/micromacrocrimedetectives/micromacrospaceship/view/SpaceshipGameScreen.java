package micromacrocrimedetectives.micromacrospaceship.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import micromacrocrimedetectives.micromacrospaceship.CustomColors;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.model.objects.FriendlyBullet;

public class SpaceshipGameScreen implements Screen {

    public final MicroMacroGame game;
    private final OrthographicCamera camera;

    public SpaceshipGameScreen(MicroMacroGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(CustomColors.darkPurple);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.font.setColor(CustomColors.pink);

        moveObjects(delta);
        drawObjects();

        game.spaceshipGameController.decreaseElapsedTime(delta, this);
    }

    private void moveObjects(float delta) {
        boolean playerGoesLeft = Gdx.input.isKeyPressed(Keys.LEFT);
        boolean playerGoesRight = Gdx.input.isKeyPressed(Keys.RIGHT);
        boolean playerShoots = Gdx.input.isKeyPressed(Keys.SPACE);

        if (playerGoesLeft) {
            game.spaceshipGameController.moveUfoLeft(delta);
        } else if (playerGoesRight) {
            game.spaceshipGameController.moveUfoRight(delta);
        }

        if (playerShoots) {
            game.spaceshipGameController.shootFriendlyBullet();
        }

        game.spaceshipGameController.moveFriendlyBullets(delta);

        game.spaceshipGameController.movePlanetsBackground(delta);

        game.spaceshipGameController.generateOpponentUfos();

        game.spaceshipGameController.moveOpponentUfos(delta);

        game.spaceshipGameController.checkForCollisions();
    }

    private void drawObjects() {
        game.batch.begin();

        game.batch.draw(
                game.spaceshipGameController.getPlanetsBackground().texture,
                game.spaceshipGameController.getPlanetsBackground().x,
                game.spaceshipGameController.getPlanetsBackground().y
        );

        game.batch.draw(
                game.spaceshipGameController.getUfo().texture,
                game.spaceshipGameController.getUfo().frame.x,
                game.spaceshipGameController.getUfo().frame.y
        );

        game.spaceshipGameController.drawOpponentUfo(game.batch);

        game.spaceshipGameController.drawBullets(game.batch);

        game.spaceshipGameController.drawElapsedTime(game.batch, game.font);

        game.batch.end();
    }

    @Override
    public void show() {
        game.spaceshipGameController.playSpaceMusic();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.spaceshipGameController.dispose();
    }
}
