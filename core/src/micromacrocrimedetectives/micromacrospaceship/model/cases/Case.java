package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Case {
    public List<Step> steps;
    public Step currentStep;
    public Texture cover;

    public Case(List<Step> steps, Texture cover) {
        this.steps = steps;
        this.cover = cover;

        currentStep = steps.get(0);
    }
}
