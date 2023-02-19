import Level.Cells.DirtGrass;
import com.raylib.Jaylib;

import java.util.Objects;

public class Textures {
    public static void loadTextures() {
        //DirtGrass
        System.out.println(System.getProperty("user.dir"));
        DirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/DirtGrass.png");
    }
}
