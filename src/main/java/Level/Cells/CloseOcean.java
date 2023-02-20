package Level.Cells;

import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class CloseOcean {
    public static class properties {
        private static final int erosionRate = 10;
        private static final int erosionRateMax = 1000;
        private static final int erosionRateMin = 0;
        private static final int floodRate = 100;
        private static final int floodRateMin = 0;
        private static final int floodRateMax = 1000;
        public static Jaylib.Color color = new Jaylib.Color(3, 227, 252, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
        public static int frameIncrement = 0;
        public static int currentAnimationFrame = 0;
        public static int maxFrames = 4;
        public static int animationSpeed = 15;
    }
    public static void tickFrame() {
        properties.currentAnimationFrame += 1;
        if (properties.currentAnimationFrame > properties.maxFrames) {
            properties.currentAnimationFrame = 0;
        }
        properties.textureRectangle.y(properties.currentAnimationFrame * 10);
        properties.frameIncrement = 0;
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
    public static void tickBorderCell(int x, int y) {
        switch (Terrain.getCell(x, y)) {
            case 1:
                //Dirt
                if (properties.erosionRate != properties.erosionRateMin && Dirt.properties.erosionResistance != Dirt.properties.erosionResistanceMin) {
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
                }
            case 2:
                if (properties.erosionRate != properties.erosionRateMin && DirtGrass.properties.erosionResistance != DirtGrass.properties.erosionResistanceMax) {
                    int chance = ThreadLocalRandom.current().nextInt(properties.erosionRateMin, properties.erosionRateMax + 1);
                    if (chance <= properties.erosionRate) {
                        chance = ThreadLocalRandom.current().nextInt(DirtGrass.properties.erosionResistanceMin, DirtGrass.properties.erosionResistanceMax + 1);
                        if (chance >= DirtGrass.properties.erosionResistance) {
                            Terrain.setCell(x, y, 3);
                        }
                    }
                }
                break;
            case 4:
                if (properties.floodRate != properties.floodRateMin) {
                    int chance = ThreadLocalRandom.current().nextInt(properties.floodRate, properties.floodRateMax + 1);
                    if (chance <= properties.floodRate) {
                        Terrain.setCell(x, y, 6);
                    }
                }
                break;
        }
    }
}
