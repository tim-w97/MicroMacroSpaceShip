package micromacrocrimedetectives.micromacrospaceship.model.cases;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public class Case {
    public List<Step> steps;
    public Step currentStep;
    public Texture cover;
    public boolean beginningSpeechPlayed;
    public Music beginningSpeech;
    public boolean caseIsSolved;

    public Case(List<Step> steps, Texture cover, Music beginningSpeech) {
        this.steps = steps;
        this.cover = cover;

        currentStep = steps.get(0);
        beginningSpeechPlayed = false;
        this.beginningSpeech = beginningSpeech;
        caseIsSolved = false;
    }
}
