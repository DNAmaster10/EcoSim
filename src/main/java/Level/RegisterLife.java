package Level;

import Level.Life.*;
import com.raylib.Jaylib;

public class RegisterLife {
    public static int totalLife = 10;
    public static String[] lifeNames = new String[totalLife];
    public static Jaylib.Color[] lifeColours = new Jaylib.Color[totalLife];
    public static boolean[] placeableLife = new boolean[totalLife];
    public static int totalPlaceableLife;
    public static void registerLife() {
        //Nothing
        lifeNames[0] = "Nothing";
        lifeColours[0] = new Jaylib.Color(0, 0, 0, 255);
        placeableLife[0] = false;

        //OakSapling
        lifeNames[1] = "Oak Sapling";
        lifeColours[1] = OakSapling.properties.color;
        placeableLife[1] = true;

        //YoungOakTree
        lifeNames[2] = "Young Oak Tree";
        lifeColours[2] = YoungOakTree.properties.color;
        placeableLife[2] = false;

        //OakTree
        lifeNames[3] = "Oak Tree";
        lifeColours[3] = OakTree.properties.color;
        placeableLife[3] = true;

        //OakSaplingFire
        lifeNames[4] = "Oak Sapling Fire";
        lifeColours[4] = OakSaplingFire.properties.color;
        placeableLife[4] = false;

        //BurntOakSapling
        lifeNames[5] = "Burnt Oak Sapling";
        lifeColours[5] = BurntOakSapling.properties.color;
        placeableLife[5] = false;

        //YoungOakTreeFire
        lifeNames[6] = "Young Oak Tree Fire";
        lifeColours[6] = YoungOakTreeFire.properties.color;
        placeableLife[6] = false;

        //BurntYoungOakTree
        lifeNames[7] = "Burnt Young Oak Tree";
        lifeColours[7] = BurntYoungOakTree.properties.color;
        placeableLife[7] = false;

        //OakTreeFire
        lifeNames[8] = "Oak Tree Fire";
        lifeColours[8] = OakTreeFire.properties.color;
        placeableLife[8] = false;

        //BurntOakTree
        lifeNames[9] = "Burnt Oak Tree";
        lifeColours[9] = BurntOakTree.properties.color;
        placeableLife[9] = false;
    }
}