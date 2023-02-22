package Level.Life;

import Level.LifeLayer;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class YoungOakTree {
    public static class properties {
        private static final int growthRate = 20;
        private static final int growthRateMax = 1000;
        private static final int growthRateMin = 0;
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
        int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
        if (chance <= properties.growthRate) {
            LifeLayer.setLife(x, y, 3);
        }
    }
}
