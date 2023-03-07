package Level.Cells;

import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.concurrent.ThreadLocalRandom;

public class DirtGrassFire {
    public static class properties {
        private static final int extinguishRate = 10;
        private static final int extinguishRateMin = 0;
        private static final int extinguishRateMax = 1000;
        private static final int spreadRate = 200;
        private static final int spreadRateMin = 0;
        private static final int spreadRateMax = 1000;
        public static Jaylib.Color color = new Jaylib.Color(255, 81, 0, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
        public static int frameIncrement = 0;
        public static int currentAnimationFrame = 0;
        public static int maxFrames = 2;
        public static int animationSpeed = 10;
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
        //This cell
        if (!Terrain.getUpdateStatus(x, y)) {
            tickThisCell(x, y);
        }
        //Check above
        if (Terrain.checkCell(x, y - 1) && !(Terrain.getUpdateStatus(x, y - 1))) {
            tickBorderCell(x, y - 1);
        }
        if (Terrain.checkCell(x + 1, y) && !(Terrain.getUpdateStatus(x + 1, y))) {
            tickBorderCell(x + 1, y);
        }
        if (Terrain.checkCell(x, y + 1) && !(Terrain.getUpdateStatus(x, y + 1))) {
            tickBorderCell(x, y + 1);
        }
        if (Terrain.checkCell(x - 1, y) && !(Terrain.getUpdateStatus(x - 1, y))) {
            tickBorderCell(x - 1, y);
        }
    }
    public static void tickThisCell(int x, int y) {
        int chance = ThreadLocalRandom.current().nextInt(properties.extinguishRateMin, properties.extinguishRateMax + 1);
        if (chance <= properties.extinguishRate) {
            Terrain.setCell(x, y, 8);
        }
    }
    public static void tickBorderCell(int x, int y) {
        switch (Terrain.getCell(x, y)) {
            case 2:
                int chance = ThreadLocalRandom.current().nextInt(properties.spreadRateMin, properties.spreadRateMax + 1);
                if (chance <= properties.spreadRate) {
                    Terrain.setCell(x, y, 9);
                }
        }
    }
}















