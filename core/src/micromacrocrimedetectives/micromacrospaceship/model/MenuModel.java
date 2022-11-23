package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuModel {
    public Stage stage;
    public Skin skin;

    public Button startGameButton;

    public MenuModel() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));

        startGameButton = new TextButton("Spiel starten", skin);
    }
}
