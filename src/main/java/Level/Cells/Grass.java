package Level.Cells;

import Level.Level;
import Level.Terrain;
import com.raylib.Jaylib;

import java.util.concurrent.ThreadLocalRandom;
public class Grass {
    public static class properties {
        private static int growthRate = 5;
        private static int growthRateMax = 1000;
        private static int growthRateMin = 0;
        public static Jaylib.Color color = new Jaylib.Color(33, 120, 22, 255);
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