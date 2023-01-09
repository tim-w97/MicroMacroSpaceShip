package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

import java.util.List;

public class Case implements Disposable {
    public List<Step> steps;
    public Step currentStep;
    public Texture cover;
    public boolean beginningSpeechPlayed;
    public Music beginningSpeech;
    public boolean caseIsSolved;
    public Music finalSpeech;

    public Case(List<Step> steps, Texture cover, Music beginningSpeech, Music finalSpeech) {
        this.steps = steps;
        this.cover = cover;

        currentStep = steps.get(0);
        beginningSpeechPlayed = false;
        this.beginningSpeech = beginningSpeech;
        this.finalSpeech = finalSpeech;
        caseIsSolved = false;
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
