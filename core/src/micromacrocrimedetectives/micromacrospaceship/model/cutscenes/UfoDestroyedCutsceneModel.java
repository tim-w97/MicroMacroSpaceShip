package micromacrocrimedetectives.micromacrospaceship.model.cutscenes;

import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.screens.SpaceshipGameScreen;

public class UfoDestroyedCutsceneModel extends CutsceneModel {
    public UfoDestroyedCutsceneModel(MicroMacroGame game) {
        super(
                game,
                2,
                "ufo-destroyed",
                "Nochmal probieren",
                new SpaceshipGameScreen(game)
        );
    }
}
