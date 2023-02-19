package Level.Cells;

import Level.Level;
import Level.Terrain;
import com.raylib.Jaylib;
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
    }
    public static void tickCell(int x, int y) {
        //Grow
        if (properties.growthRate != 0) {
            //Check cell above
            if (!(y - 1 < 0) && Terrain.getCell(x, y - 1) == 1 && !(Terrain.getUpdateStatus(x, y - 1))) {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x, y - 1, 2);
                }
            }
            //Check cell to right
            if (!(x + 1 > Level.gridWidth - 1) && Terrain.getCell(x + 1, y) == 1 && !(Terrain.getUpdateStatus(x + 1, y))) {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x + 1, y, 2);
                }
            }
            //Check cell below
            if (!(y + 1 > Level.gridHeight - 1) && Terrain.getCell(x, y + 1) == 1 && !(Terrain.getUpdateStatus(x, y + 1))) {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x, y + 1, 2);
                }
            }
            //Check cell to left
            if (!(x - 1 < 0) && Terrain.getCell(x - 1, y) == 1 && !(Terrain.getUpdateStatus(x - 1, y))) {
                int chance = ThreadLocalRandom.current().nextInt(properties.growthRateMin, properties.growthRateMax + 1);
                if (chance <= properties.growthRate) {
                    Terrain.setCell(x - 1, y, 2);
                }
            }
        }
    }
}