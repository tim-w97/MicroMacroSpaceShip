package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Case {
    private final List<Step> steps;
    public Step currentStep;
    public Texture cover;

    public Case(List<Step> steps, Texture cover) {
        this.steps = steps;
        this.cover = cover;

        currentStep = steps.get(0);
    }

    // TODO: Move logic like this to the controller!
    public boolean moveToNextStep() {
        int index = steps.indexOf(currentStep);

        index++;

        if (index == steps.size()) {
            return true;
        }

        currentStep = steps.get(index);
        return false;
    }
}
