package micromacrocrimedetectives.micromacrospaceship.model.cutscenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.screens.SpaceshipGameScreen;

public class UfoDestroyedCutsceneModel extends CutsceneModel {
    public TextButton quitButton;

    public UfoDestroyedCutsceneModel(MicroMacroGame game) {
        super(
                game,
                2,
                "ufo-destroyed",
                "Nochmal probieren",
                new SpaceshipGameScreen(game)
        );

        quitButton = new TextButton("Beenden", game.skin);

        quitButton.setSize(200, 60);

        quitButton.setPosition(
                (Gdx.graphics.getWidth() - button.getWidth()) / 2,
                10
        );

        stage.addActor(quitButton);
    }
}
