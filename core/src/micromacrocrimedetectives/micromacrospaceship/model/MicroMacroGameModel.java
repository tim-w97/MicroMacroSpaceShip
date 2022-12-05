package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import micromacrocrimedetectives.micromacrospaceship.model.objects.BongoBob;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Phone;

public class MicroMacroGameModel {
    public BongoBob bongoBob;

    public Phone phone;

    public Vector3 cameraPosition;

    public Texture map;

    public float mapWalkFactor;

    public MicroMacroGameModel() {
        TextureAtlas atlas = new TextureAtlas("MicroMacroGame/MicroMacroGame.atlas");

        phone = new Phone(atlas.findRegion("screen/phone"));

        bongoBob = new BongoBob(atlas);

        cameraPosition = new Vector3();

        mapWalkFactor = (float) (Math.PI / 180 * 33);

        map = new Texture("MicroMacroGame/map.jpg");
    }
}
