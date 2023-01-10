package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Disposable;
import micromacrocrimedetectives.micromacrospaceship.MicroMacroGame;

public class MenuModel implements Disposable {
    public MicroMacroGame game;

    public Stage stage;

    public Button startGameButton;

    public Texture ufoTexture;
    public Texture gearTexture;
    public float ufoX, ufoY;

    public float ufoLightX1, ufoLightY1, ufoLightX2, ufoLightY2, ufoLightX3, ufoLightY3;

    public Label caseDropdownLabel;
    public SelectBox<String> caseDropdown;

    public Button exitGameButton;

    public CheckBox skipTutorialCheckbox;

    public Label niklasLabel;

    public MenuModel(MicroMacroGame game) {
        this.game = game;

        stage = new Stage();

        startGameButton = new TextButton("Spiel starten", game.skin);
        startGameButton.setSize(200, 80);

        startGameButton.setPosition(
                (Gdx.graphics.getWidth() - startGameButton.getWidth()) / 2,
                150
        );

        exitGameButton = new TextButton("Spiel beenden", game.skin);
        exitGameButton.setSize(130, 50);

        exitGameButton.setPosition(
                10,
                10
        );

        caseDropdown = new SelectBox<>(game.skin);

        String[] caseDropdownItems = new String[AvailableCase.values().length];

        for (int i = 0; i < caseDropdownItems.length; i++) {
            caseDropdownItems[i] = AvailableCase.values()[i].description;
        }

        caseDropdown.setItems(caseDropdownItems);

        caseDropdown.setSize(200, 50);

        caseDropdown.setPosition(
                (Gdx.graphics.getWidth() - caseDropdown.getWidth()) / 2,
                270
        );

        caseDropdownLabel = new Label("Suche dir einen Fall aus und starte das Spiel!", game.skin);

        caseDropdownLabel.setPosition(
                (Gdx.graphics.getWidth() - caseDropdownLabel.getWidth()) / 2,
                320
        );

        niklasLabel = new Label("Musik produziert\nvon Niklas D. *-*", game.skin);
        niklasLabel.setPosition(
                Gdx.graphics.getWidth() - niklasLabel.getWidth() - 10,
                10
        );

        gearTexture = new Texture("images/menu/gear.png");
        ufoTexture = new Texture("images/spaceship-game/ufo/three-lives.png");

        ufoX = (Gdx.graphics.getWidth() - ufoTexture.getWidth()) / 2f;
        ufoY = Gdx.graphics.getHeight() - ufoTexture.getHeight() - 20;

        ufoLightX1 = Gdx.graphics.getWidth() / 2f;
        ufoLightY1 = Gdx.graphics.getHeight() - 65;
        ufoLightX2 = 100;
        ufoLightY2 = 100;
        ufoLightX3 = Gdx.graphics.getWidth() - 100;
        ufoLightY3 = 100;

        skipTutorialCheckbox = new CheckBox("Zwischensequenzen weglassen", game.skin);
        skipTutorialCheckbox.setSize(300, 50);

        skipTutorialCheckbox.setPosition(
                110,
                10
        );

        stage.addActor(startGameButton);
        stage.addActor(caseDropdown);
        stage.addActor(caseDropdownLabel);
        stage.addActor(exitGameButton);
        stage.addActor(skipTutorialCheckbox);
        stage.addActor(niklasLabel);
    }

    @Override
    public void dispose() {
        ufoTexture.dispose();
        gearTexture.dispose();
        stage.dispose();
    }
}
