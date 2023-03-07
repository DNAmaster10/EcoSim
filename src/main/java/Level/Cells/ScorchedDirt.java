package Level.Cells;

import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class ScorchedDirt {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(92, 40, 29, 255);
        public static int erosionResistance = 500;
        public static int erosionResistanceMin = 0;
        public static int erosionResistanceMax = 1000;
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
        public static int rejuvenationRate = 1;
        public static int rejuvenationRateMin = 0;
        public static int rejuvenationRateMax = 1000;
    }
    public static void tickCell(int x, int y) {
        if (!Terrain.getUpdateStatus(x, y)) {
            tickThisCell(x, y);
        }
    }
    public static void tickThisCell(int x, int y) {
        if (properties.rejuvenationRate != properties.rejuvenationRateMin) {
            int chance = ThreadLocalRandom.current().nextInt(properties.rejuvenationRateMin, properties.rejuvenationRateMax + 1);
            if (chance <= properties.rejuvenationRate) {
                Terrain.setCell(x, y, 1);
            }
        }
    }
}
