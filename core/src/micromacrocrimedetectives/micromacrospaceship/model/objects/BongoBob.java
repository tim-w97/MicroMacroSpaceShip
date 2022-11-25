package micromacrocrimedetectives.micromacrospaceship.model.objects;

import com.badlogic.gdx.graphics.Texture;
import micromacrocrimedetectives.micromacrospaceship.Direction;

import java.util.HashMap;
import java.util.Map;

public class BongoBob {
    public Texture texture;
    public Map<Direction, Texture> textures;
    public Direction direction;
    public float velocity;

    public BongoBob() {
        textures = new HashMap<>();

        textures.put(Direction.LEFT, new Texture("bongoBob/left.png"));
        textures.put(Direction.RIGHT, new Texture("bongoBob/right.png"));
        textures.put(Direction.UP, new Texture("bongoBob/back.png"));
        textures.put(Direction.DOWN, new Texture("bongoBob/front.png"));

        velocity = 300;
        direction = Direction.DOWN;

        texture = textures.get(direction);
    }
}
