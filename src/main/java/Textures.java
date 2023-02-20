import Level.Cells.DirtGrass;
import Level.Cells.Ocean;
import com.raylib.Jaylib;

public class Textures {
    public static void loadTextures() {
        //DirtGrass
        DirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/DirtGrass.png");

        Ocean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/Ocean.png");
    }
}
