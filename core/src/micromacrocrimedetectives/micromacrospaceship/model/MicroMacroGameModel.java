package micromacrocrimedetectives.micromacrospaceship.model;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import micromacrocrimedetectives.micromacrospaceship.model.objects.BongoBob;
import micromacrocrimedetectives.micromacrospaceship.model.objects.MapTile;
import micromacrocrimedetectives.micromacrospaceship.model.objects.Phone;

public class MicroMacroGameModel {
    public BongoBob bongoBob;

    public Phone phone;

    public Vector3 cameraPosition;

    public int verticalMapTilesCount, horizontalMapTilesCount;

    public MapTile[][] mapTiles;

    public float mapWalkFactor;

    public MicroMacroGameModel() {
        TextureAtlas atlas = new TextureAtlas("MicroMacroGame/MicroMacroGame.atlas");

        phone = new Phone(atlas.findRegion("screen/phone"));

        bongoBob = new BongoBob(atlas);

        cameraPosition = new Vector3();

        verticalMapTilesCount = 18;
        horizontalMapTilesCount = 25;

        mapTiles = new MapTile[verticalMapTilesCount][horizontalMapTilesCount];

        for (int v = 0; v < verticalMapTilesCount; v++) {
            for (int h = 0; h < horizontalMapTilesCount; h++) {
                mapTiles[v][h] = new MapTile(v, h);
            }
        }

        mapWalkFactor = (float) (Math.PI / 180 * 33);
    }
}
