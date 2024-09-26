package Level.Life;

import Level.LifeLayer;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class YoungOakTree {
    public static class properties {
        private static final int growthRate = 5;
        private static final int growthRateMax = 10000;
        private static final int growthRateMin = 0;
        public static Jaylib.Color color = new Jaylib.Color(49, 94, 4, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 11, 12);
    }
    public static void tickObject(int x, int y) {
        //This life
        if (!LifeLayer.getUpdateStatus(x, y)) {
            tickThisLife(x, y);
        }
    }
    public static void tickThisLife(int x, int y) {
        //Check cells beneath
        boolean end = false;
        switch(Terrain.getCell(x, y)) {
            case 0:
            case 3:
            case 4:
            case 6:
            case 7:
                //Remove
                LifeLayer.setLife(x, y, 0);
                end = true;
                break;
            case 9:
                //Set on fire
                LifeLayer.setLife(x, y, 6);
                end = true;
                break;
        }
        if (end) {
            return;
        }
        int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
        if (chance <= properties.growthRate) {
            LifeLayer.setLife(x, y, 3);
        }
    }
}
