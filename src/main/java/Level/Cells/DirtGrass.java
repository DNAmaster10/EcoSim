package Level.Cells;

import Level.Level;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

import java.util.concurrent.ThreadLocalRandom;
public class DirtGrass {
    public static class properties {
        private static final int growthRate = 20;
        private static final int growthRateMax = 1000;
        private static final int growthRateMin = 0;
        public static int erosionResistance = 900;
        public static int erosionResistanceMin = 0;
        public static int erosionResistanceMax = 1000;
        public static Jaylib.Color color = new Jaylib.Color(33, 120, 22, 255);
        public static Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
    }
    public static void tickCell(int x, int y) {
        //Grow
        if (properties.growthRate != 0) {
            //Check cell above
            if (Terrain.checkCell(x, y - 1) && !(Terrain.getUpdateStatus(x, y - 1))) {
                tickBorderCell(x, y - 1);
            }
            //Check cell to right
            if (Terrain.checkCell(x + 1, y) && !(Terrain.getUpdateStatus(x + 1, y))) {
                tickBorderCell(x + 1, y);
            }
            //Check cell below
            if (Terrain.checkCell(x, y + 1) && !(Terrain.getUpdateStatus(x, y + 1))) {
                tickBorderCell(x, y + 1);
            }
            //Check cell to left
            if (Terrain.checkCell(x - 1, y) && !(Terrain.getUpdateStatus(x - 1, y))) {
                tickBorderCell(x - 1, y);
            }
        }
    }
    public static void tickBorderCell (int x, int y) {
        switch(Terrain.getCell(x, y)) {
            case 1: {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x, y , 2);
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