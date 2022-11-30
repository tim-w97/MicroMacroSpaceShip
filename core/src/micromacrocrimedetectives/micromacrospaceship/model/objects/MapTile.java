package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;

public class MapTile {
    public float x, y;

    public int verticalTileIndex, horizontalTileIndex;
    public int width, height;
    public Texture texture;

    public MapTile(int verticalTileIndex, int horizontalTileIndex) {
        this.verticalTileIndex = verticalTileIndex;
        this.horizontalTileIndex = horizontalTileIndex;

        texture = new Texture("mapTiles/x" + horizontalTileIndex + "y" + verticalTileIndex + ".png");

        width = texture.getWidth();
        height = texture.getHeight();

        x = horizontalTileIndex * width;
        y = verticalTileIndex * height * -1;
    }
}
