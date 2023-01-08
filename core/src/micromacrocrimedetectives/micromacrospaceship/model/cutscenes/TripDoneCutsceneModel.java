package micromacrocrimedetectives.micromacrospaceship.model.cutscenes;

import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;
import micromacrocrimedetectives.micromacrospaceship.screens.MicroMacroGameScreen;

public class TripDoneCutsceneModel extends CutsceneModel {
    public TripDoneCutsceneModel(MicroMacroGame game) {
        super(
                game,
                7,
                "trip-done",
                "Start",
                new MicroMacroGameScreen(game)
        );
    }
}
