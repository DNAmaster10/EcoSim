package Level.Life;

import Level.LifeLayer;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class OakSapling {
    public static class properties {
        private static final int growthRate = 2;
        private static final int growthRateMax = 10000;
        private static final int growthRateMin = 0;
        public static Jaylib.Color color = new Jaylib.Color(33, 120, 22, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 11);
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
                //Remove if on cell that can't support this life.
                LifeLayer.setLife(x, y, 0);
                end = true;
                break;
            case 9:
                //Set on fire if on a burning cell.
                LifeLayer.setLife(x, y, 4);
                end = true;
                break;
        }
        if (end) {
            return;
        }
        //Grow
        int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
        if (chance <= properties.growthRate) {
            LifeLayer.setLife(x, y, 2);
        }
    }
}
