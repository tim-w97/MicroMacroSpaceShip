package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class MenuModel {
    public MicroMacroGame game;

    public Stage stage;

    public Button startGameButton;

    public final float buttonWidth;
    public final float buttonHeight;

    public AtlasRegion ufoTexture;
    public AtlasRegion gearTexture;
    public float ufoX, ufoY;

    public float ufoLightX1, ufoLightY1, ufoLightX2, ufoLightY2, ufoLightX3, ufoLightY3;

    public MenuModel(MicroMacroGame game) {
        this.game = game;

        stage = new Stage(new ScreenViewport());

        buttonWidth = 300;
        buttonHeight = 80;

        startGameButton = new TextButton("Spiel starten", game.assets.skin);
        startGameButton.setSize(buttonWidth, buttonHeight);

        startGameButton.setPosition(
                (Gdx.graphics.getWidth() - buttonWidth) / 2,
                (Gdx.graphics.getHeight() - buttonHeight) / 2
        );

        gearTexture = game.assets.atlas.findRegion("gear");
        ufoTexture = game.assets.atlas.findRegion("ufo");

        ufoX = (Gdx.graphics.getWidth() - ufoTexture.getRegionWidth()) / 2f;
        ufoY = Gdx.graphics.getHeight() - ufoTexture.getRegionHeight() - 20;

        ufoLightX1 = Gdx.graphics.getWidth() / 2f;
        ufoLightY1 = Gdx.graphics.getHeight() - 65;
        ufoLightX2 = 100;
        ufoLightY2 = 100;
        ufoLightX3 = Gdx.graphics.getWidth() - 100;
        ufoLightY3 = 100;
    }
}
