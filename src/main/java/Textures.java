import Level.Cells.*;
import Level.Life.*;
import com.raylib.Jaylib;

public class Textures {
    public static void loadTextures() {
        System.out.println(System.getProperty(("user.dir")));
        //DirtGrass
        DirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/DirtGrass.png");

        //Ocean
        Ocean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/Ocean.png");

        //BeachSand
        BeachSand.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/BeachSand.png");

        //CloseOcean
        CloseOcean.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/CloseOcean.png");

        //Dirt
        Dirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/Dirt.png");

        //Hill
        Hill.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/Hill.png");

        //Scorched dirt
        ScorchedDirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/ScorchedDirt.png");

        //DirtGrassFire
        DirtGrassFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/DirtGrassFire.png");

        //FertileDirt
        FertileDirt.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/FertileDirt.png");

        //FertileDirtGrass
        FertileDirtGrass.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/FertileDirtGrass.png");

        //Snow peaks
        SnowyPeaks.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/SnowyPeaks.png");

        //River Source
        RiverSource.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/cells/RiverSource.png");

        //River Middle
        RiverMiddle.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/RiverMiddle.png");

        ////////////LIFE/////////////////

        //OakSapling
        OakSapling.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/OakSapling.png");

        //Young oak tree
        YoungOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/YoungOakTree.png");

        //Oak tree
        OakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/OakTree.png");

        //Oak Sapling Fire
        OakSaplingFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/OakSaplingFire.png");

        //Burnt Oak Sapling
        BurntOakSapling.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/BurntOakSapling.png");

        //Young Oak Tree Fire
        YoungOakTreeFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/YoungOakTreeFire.png");

        //Burnt Young Oak Tree
        BurntYoungOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/BurntYoungOakTree.png");

        //Oak Tree Fire
        OakTreeFire.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/OakTreeFire.png");

        //Burnt Oak Tree
        BurntOakTree.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/BurntOakTree.png");

        //Bluebell
        System.out.println("Loading bluebell");
        Bluebell.properties.texture = Jaylib.LoadTexture(System.getProperty("user.dir") + "/resources/life/Bluebell.png");
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