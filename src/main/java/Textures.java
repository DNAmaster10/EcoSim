import Level.Cells.*;
import com.raylib.Jaylib;

public class Textures {
    public static void loadTextures() {
        //DirtGrass
        DirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/DirtGrass.png");

        //Ocean
        Ocean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/Ocean.png");

        //BeachSand
        BeachSand.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/BeachSand.png");

        //CloseOcean
        CloseOcean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/CloseOcean.png");

        //Dirt
        Dirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/Dirt.png");

        //Hill
        Hill.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/target/classes/Hill.png");
    }
    public static void doTextureTick() {
        //Ticks frames over for textures which need to be animated
        //Ocean
        if (Ocean.properties.frameIncrement == Ocean.properties.animationSpeed) {
            Ocean.tickFrame();
        }

        //CloseOcean
        if (CloseOcean.properties.frameIncrement == CloseOcean.properties.animationSpeed) {
            CloseOcean.tickFrame();
        }

        //Increments animated textures frame count
        Ocean.properties.frameIncrement++;
        CloseOcean.properties.frameIncrement++;
    }
}