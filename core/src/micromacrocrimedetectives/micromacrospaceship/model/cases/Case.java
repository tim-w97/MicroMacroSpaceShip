package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

public class Case implements Disposable {
    public List<Step> steps;
    public Step currentStep;
    public Texture cover;
    public boolean beginningSpeechPlayed;
    public Music beginningSpeech;
    public boolean caseIsSolved;
    public Music finalSpeech;

    public Case(Texture cover, Music beginningSpeech, Music finalSpeech) {
        this.steps = new ArrayList<>();
        this.cover = cover;

        beginningSpeechPlayed = false;
        this.beginningSpeech = beginningSpeech;
        this.finalSpeech = finalSpeech;
        caseIsSolved = false;
    }

    public void addStep(Step step) {
        if (currentStep == null) {
            currentStep = step;
        }

        steps.add(step);
    }

    @Override
    public void dispose() {
        cover.dispose();
        beginningSpeech.dispose();
        finalSpeech.dispose();
        currentStep.dispose();

        for (Disposable step : steps) {
            step.dispose();
        }
    }
}
