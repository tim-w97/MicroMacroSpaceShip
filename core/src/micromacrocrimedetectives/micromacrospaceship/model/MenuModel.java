package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuModel {
    public Stage stage;
    public Skin skin;

    public Button startGameButton;

    public final float buttonWidth;
    public final float buttonHeight;

    public Texture ufoTexture;
    public float ufoX, ufoY;

    public MenuModel() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));

        buttonWidth = 300;
        buttonHeight = 80;

        startGameButton = new TextButton("Spiel starten", skin);
        startGameButton.setSize(buttonWidth, buttonHeight);

        startGameButton.setPosition(
                (Gdx.graphics.getWidth() - buttonWidth) / 2,
                (Gdx.graphics.getHeight() - buttonHeight) / 2
        );

        ufoTexture = new Texture("ufo.png");
        ufoX = (Gdx.graphics.getWidth() - ufoTexture.getWidth()) / 2f;
        ufoY = Gdx.graphics.getHeight() - ufoTexture.getHeight() - 20;
    }
}
