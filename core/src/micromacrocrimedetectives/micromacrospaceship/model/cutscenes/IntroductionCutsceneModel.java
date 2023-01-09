package micromacrocrimedetectives.micromacrospaceship.model.cutscenes;

import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.screens.SpaceshipGameScreen;

public class IntroductionCutsceneModel extends CutsceneModel {
    public IntroductionCutsceneModel(MicroMacroGame game) {
        super(
                game,
                6,
                "introduction",
                "Start",
                new SpaceshipGameScreen(game)
        );
    }
}
