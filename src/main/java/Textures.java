import Level.Cells.*;
import Level.Life.OakSapling;
import Level.Life.YoungOakTree;
import com.raylib.Jaylib;

public class Textures {
    public static void loadTextures() {
        System.out.println(System.getProperty(("user.dir")));
        //DirtGrass
        DirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/DirtGrass.png");

        //Ocean
        Ocean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/Ocean.png");

        //BeachSand
        BeachSand.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/BeachSand.png");

        //CloseOcean
        CloseOcean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/CloseOcean.png");

        //Dirt
        Dirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/Dirt.png");

        //Hill
        Hill.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/Hill.png");

        //Scorched dirt
        ScorchedDirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/ScorchedDirt.png");

        //DirtGrassFire
        DirtGrassFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/DirtGrassFire.png");

        //OakSapling
        OakSapling.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/OakSapling.png");

        //Young oak tree
        YoungOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/YoungOakTree.png");
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

        //DirtGrassFire
        if (DirtGrassFire.properties.frameIncrement == DirtGrassFire.properties.animationSpeed) {
            DirtGrassFire.tickFrame();
        }

        //Increments animated textures frame count
        Ocean.properties.frameIncrement++;
        CloseOcean.properties.frameIncrement++;
        DirtGrassFire.properties.frameIncrement++;
    }
}