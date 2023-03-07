package Level.Cells;
import Level.Level;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import Level.Terrain;

import java.util.concurrent.ThreadLocalRandom;

public class FertileDirtGrass {
    public static class properties {
        public static final Jaylib.Color color = new Jaylib.Color(29, 138, 38, 255);
        public static final int growthRate = 10;
        public static final int growthRateMax = 1000;
        public static final int growthRateMin = 0;
        public static final int erosionResistance = 900;
        public static final int erosionResistanceMin = 0;
        public static final int erosionResistanceMax = 1000;
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectanlge = new Jaylib.Rectangle(0, 0, 10, 10);
    }
    public static void tickCell(int x, int y) {
        //Grow
        if (properties.growthRate != 0) {
            //Check cell above
            if (Terrain.checkCell(x, y - 1) && !(Terrain.getUpdateStatus(x, y - 1))) {
                tickBorderCell(x, y - 1);
            }
            //Check to right
            if (Terrain.checkCell(x + 1, y) && !(Terrain.getUpdateStatus(x + 1, y))) {
                tickBorderCell(x + 1, y);
            }
            //Check below
            if (Terrain.checkCell(x, y + 1) && !(Terrain.getUpdateStatus(x, y + 1))) {
                tickBorderCell(x, y + 1);
            }
            //Check to left
            if (Terrain.checkCell(x - 1, y) && !(Terrain.getUpdateStatus(x - 1, y))) {
                tickBorderCell(x - 1, y);
            }
        }
    }
    public static void tickBorderCell(int x, int y) {
        switch(Terrain.getCell(x, y)) {
            case 1: {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x, y, 2);
                }
                break;
            }
            case 11: {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x, y, 12);
                }
                break;
            }
        }
    }
}
