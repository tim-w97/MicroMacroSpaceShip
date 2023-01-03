package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public class MicroMacroAssets implements Disposable {
    public Sound welcomeSound;
    public Sound foundHintSound;
    public Sound caseSolvedSound;

    public TextureAtlas atlas;
    public Texture map;
    public Texture planetsBackground;
    public Skin skin;

    public MicroMacroAssets() {
        welcomeSound = Gdx.audio.newSound(Gdx.files.internal("sounds/speech/welcome.mp3"));
        foundHintSound = Gdx.audio.newSound(Gdx.files.internal("sounds/speech/found-hint.mp3"));
        caseSolvedSound = Gdx.audio.newSound(Gdx.files.internal("sounds/speech/case-solved.mp3"));

        atlas = new TextureAtlas("images/atlas/MicroMacroAssets.atlas");
        map = new Texture("images/map.jpg");
        planetsBackground = new Texture("images/planetsBackground.png");
        skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
    }

    @Override
    public void dispose() {
        welcomeSound.dispose();
        foundHintSound.dispose();
        caseSolvedSound.dispose();

        skin.dispose();
        planetsBackground.dispose();
        map.dispose();
        atlas.dispose();
    }
}
