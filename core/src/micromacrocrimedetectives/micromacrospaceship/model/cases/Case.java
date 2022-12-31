package micromacrocrimedetectives.micromacrospaceship.model.cases;

import java.util.ArrayList;
import java.util.List;

public class Case {
    List<Step> steps;

    public Case() {
        steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        steps.add(step);
    }
}
