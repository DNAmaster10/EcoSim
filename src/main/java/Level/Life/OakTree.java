package Level.Life;

import Level.LifeLayer;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OakTree {
    public static class properties {
        private static final int spreadRate = 5;
        private static final int spreadRateMin = 0;
        private static final int spreadRateMax = 1000;
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 14, 15);
        public static Jaylib.Color color = new Jaylib.Color(49, 94, 4, 255);
    }
    public static void tickObject(int x, int y) {
        //This life
        if (!LifeLayer.getUpdateStatus(x, y)) {
            tickThisLife(x, y);
        }
    }
    public static void tickThisLife(int x, int y) {
        boolean end = false;
        switch(Terrain.getCell(x, y)) {
            case 0:
            case 3:
            case 4:
            case 6:
            case 7:
                //Remove if on cell that can't support this life
                LifeLayer.setLife(x, y, 0);
                end = true;
                break;
            case 9:
                LifeLayer.setLife(x, y, 8);
                end = true;
                break;
        }
        if (end) {
            return;
        }
        //Spread
        int chance = ThreadLocalRandom.current().nextInt(properties.spreadRateMin, properties.spreadRateMax + 1);
        if (chance <= properties.spreadRate) {
            //Spread
            List<int[]> availablePositions = new ArrayList<>();
            int amountPositions = 0;
            int[] topLeft = new int [2];
            topLeft[0] = x - 2;
            topLeft[1] = y - 2;
            for (int currentX = 0; currentX < (4) + 1; currentX++) {
                for (int currentY = 0; currentY < (4) + 1; currentY++) {
                    if (LifeLayer.checkLifeExists(topLeft[0] + currentX, topLeft[1] + currentY) && !LifeLayer.checkLife(topLeft[0] + currentX, topLeft[1] + currentY)) {
                        boolean isValid = false;
                        switch(Terrain.getCell(topLeft[0] + currentX, topLeft[1] + currentY)) {
                            case 1:
                            case 2:
                                isValid = true;
                                break;
                        }
                        if (!isValid) {
                            break;
                        }
                        availablePositions.add(new int[2]);
                        availablePositions.get(amountPositions)[0] = topLeft[0] + currentX;
                        availablePositions.get(amountPositions)[1] = topLeft[1] + currentY;
                        amountPositions++;
                    }
                }
            }
            if (amountPositions > 0) {
                chance = ThreadLocalRandom.current().nextInt(0, amountPositions);
                LifeLayer.setLife(availablePositions.get(chance)[0], availablePositions.get(chance)[1], 1);
            }
        }
    }
}
