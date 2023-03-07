import Level.Cells.*;
import Level.Life.*;
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

        //FertileDirt
        FertileDirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/FertileDirt.png");

        //FertileDirtGrass
        FertileDirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/FertileDirtGrass.png");

        //Snow peaks
        SnowyPeaks.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/SnowyPeaks.png");

        //River Source
        RiverSource.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/RiverSource.png");

        //River Middle
        RiverMiddle.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/RiverMiddle.png");

        //OakSapling
        OakSapling.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/OakSapling.png");

        //Young oak tree
        YoungOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/YoungOakTree.png");

        //Oak tree
        OakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/OakTree.png");

        //Oak Sapling Fire
        OakSaplingFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/OakSaplingFire.png");

        //Burnt Oak Sapling
        BurntOakSapling.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/BurntOakSapling.png");

        //Young Oak Tree Fire
        YoungOakTreeFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/YoungOakTreeFire.png");

        //Burnt Young Oak Tree
        BurntYoungOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/BurntYoungOakTree.png");

        //Oak Tree Fire
        OakTreeFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/OakTreeFire.png");

        //Burnt Oak Tree
        BurntOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/BurntOakTree.png");

        //Bluebell
        System.out.println("Loading bluebell");
        Bluebell.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/Bluebell.png");
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

        //OakSaplingFire
        if (OakSaplingFire.properties.frameIncrement == OakSaplingFire.properties.animationSpeed) {
            OakSaplingFire.tickFrame();
        }

        //YoungOakTreeFire
        if (YoungOakTreeFire.properties.frameIncrement == YoungOakTreeFire.properties.animationSpeed) {
            YoungOakTreeFire.tickFrame();
        }

        //OakTreeFire
        if (OakTreeFire.properties.frameIncrement == OakTreeFire.properties.animationSpeed) {
            OakTreeFire.tickFrame();
        }

        //Increments animated textures frame count
        Ocean.properties.frameIncrement++;
        CloseOcean.properties.frameIncrement++;
        DirtGrassFire.properties.frameIncrement++;
        OakSaplingFire.properties.frameIncrement++;
        YoungOakTreeFire.properties.frameIncrement++;
        OakTreeFire.properties.frameIncrement++;
    }
}