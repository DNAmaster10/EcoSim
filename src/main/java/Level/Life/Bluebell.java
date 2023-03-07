package Level.Life;

import Level.LifeLayer;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class Bluebell {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(23, 87, 191, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
        private static final int growthRate = 10;
        private static final int growthRateMin = 0;
        private static final int growthRateMax = 1000;
    }
    public static void tickObject(int x, int y) {
        //This life
        tickThisLife(x, y);

        if (!LifeLayer.checkLife(x, y - 1) && !(LifeLayer.getUpdateStatus(x, y - 1))) {
            tickBorderLife(x, y - 1);
        }
        if (!LifeLayer.checkLife(x + 1, y) && !LifeLayer.getUpdateStatus(x + 1, y)) {
            tickBorderLife(x + 1, y);
        }
        if (!LifeLayer.checkLife(x, y + 1) && !LifeLayer.getUpdateStatus(x, y + 1)) {
            tickBorderLife(x, y + 1);
        }
        if (!LifeLayer.checkLife(x - 1, y) && !LifeLayer.getUpdateStatus(x - 1, y)) {
            tickBorderLife(x - 1, y);
        }
    }
    public static void tickThisLife(int x, int y) {
        //Check cells beneath
        boolean end = false;
        switch(Terrain.getCell(x, y)) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
                LifeLayer.setLife(x, y, 0);
                end = true;
                break;
        }
        if (end) {
            return;
        }
    }
    public static void tickBorderLife(int x, int y) {
        switch(Terrain.getCell(x, y)) {
            case 12: {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    LifeLayer.setLife(x, y, 10);
                }
            }
        }
    }
}
