package micromacrocrimedetectives.micromacrospaceship.model.cases;

import java.util.ArrayList;
import java.util.List;

public class Case {
    private final List<Step> steps;
    public Step currentStep;

    public Case() {
        steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        if (currentStep == null) {
            currentStep = step;
        }

        steps.add(step);
    }

    public boolean moveToNextStep() {
        int index = steps.indexOf(currentStep);

        index++;

        if (index == steps.size()) {
            return false;
        }

        currentStep = steps.get(index);
        return true;
    }
}
