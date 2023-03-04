package Level.Life;

import Level.LifeLayer;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class BurntOakTree {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(56, 43, 14, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 14, 15);
        public static final int despawnRate = 1;
        public static final int despawnRateMin = 0;
        public static final int despawnRateMax = 1000;

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
                LifeLayer.setLife(x, y, 0);
                end = true;
                break;
            case 8:
                end = true;
                break;
        }
        if (end) {
            return;
        }
        int chance = ThreadLocalRandom.current().nextInt(properties.despawnRateMin, properties.despawnRateMax + 1);
        if (chance <= properties.despawnRate) {
            switch (Terrain.getCell(x, y)) {
                case 1: {
                    //Despawn life
                    Terrain.setCell(x, y, 11);
                    LifeLayer.setLife(x, y, 0);
                    break;
                }
                case 2:
                    Terrain.setCell(x, y, 12);
                    LifeLayer.setLife(x, y, 0);
                    break;
                default: {
                    LifeLayer.setLife(x, y, 0);
                    break;
                }
            }
        }
    }
}
