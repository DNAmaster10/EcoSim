package Level.Cells;

import Level.Level;
import Level.Terrain;
import com.raylib.Jaylib;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.exit;

public class Ocean {
    public static class properties {
        private static int erosionRate = 10;
        private static int erosionRateMax = 1000;
        private static int erosionRateMin = 0;
        private static int floodRate = 100;
        private static int floodRateMin = 0;
        private static int floodRateMax = 1000;
        public static Jaylib.Color color = new Jaylib.Color(15, 78, 150, 255);
    }
    public static void tickCell(int x, int y) {
        //Check above
        if (Terrain.checkCellExists(x, y - 1) && !(Terrain.getUpdateStatus(x, y - 1))) {
            tickBorderCell(x, y - 1);
        }
        //Check to right
        if (Terrain.checkCellExists(x + 1, y) && !(Terrain.getUpdateStatus(x + 1, y))) {
            tickBorderCell(x + 1, y);
        }
        //Check below
        if (Terrain.checkCellExists(x, y + 1) && !(Terrain.getUpdateStatus(x, y + 1))) {
            tickBorderCell(x, y + 1);
        }
        //Check to left
        if (Terrain.checkCellExists(x - 1, y) && !(Terrain.getUpdateStatus(x - 1, y))) {
            tickBorderCell(x - 1, y);
        }
    }
    private static void tickBorderCell(int x, int y) {
            switch(Terrain.getCell(x, y)) {
                case 1:
                    //Calculate erosion for dirt
                    if (properties.erosionRate != properties.erosionRateMin && Dirt.properties.erosionResistance != Dirt.properties.erosionResistanceMax) {
                        int chance = ThreadLocalRandom.current().nextInt(properties.erosionRateMin, properties.erosionRateMax + 1);
                        if (chance <= properties.erosionRate) {
                            chance = ThreadLocalRandom.current().nextInt(Dirt.properties.erosionResistanceMin, Dirt.properties.erosionResistanceMax + 1);
                            if (chance >= Dirt.properties.erosionResistance) {
                                Terrain.setCell(x, y, 3);
                            }
                        }
                    }
                    break;
                case 2:

                    break;
                case 4:
                    if (properties.floodRate != properties.floodRateMin) {
                        int chance = ThreadLocalRandom.current().nextInt(properties.floodRateMin, properties.floodRateMax + 1);
                        if (chance <= properties.floodRate) {
                            Terrain.setCell(x, y, 0);
                        }
                    }
                    break;
            }
    }
}
