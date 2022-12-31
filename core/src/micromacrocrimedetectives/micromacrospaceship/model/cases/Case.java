package micromacrocrimedetectives.micromacrospaceship.model.cases;

import java.util.ArrayList;
import java.util.List;

public class Case {
    List<Step> steps;
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
}
