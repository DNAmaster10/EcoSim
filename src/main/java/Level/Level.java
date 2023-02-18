package Level;

import Level.Cells.DirtGrass;
import Level.Cells.Ocean;

public class Level {
    public static int windowHeight = 800;
    public static int windowWidth = 800;
    public static int cellWidth = 6;
    public static int cellHeight = 6;
    public static int gridWidth;
    public static int gridHeight;

    public static void doMainTick() {
        Terrain.resetUpdateStatus();
        doUpdateTick();
    }
    public static int[] getGridPos(int x, int y) {
        int[] returnArray = new int[2];
        returnArray[0] = x / Level.cellWidth;
        returnArray[1] = y / Level.cellHeight;
        return (returnArray);
    }
    public static void doUpdateTick() {
        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch (Terrain.getCell(x, y)) {
                    case 0:
                        if (!(Terrain.getUpdateStatus(x, y))) {
                            Ocean.tickCell(x, y);
                        }
                        break;
                    case 2:
                        if (!(Terrain.getUpdateStatus(x, y))) {
                            DirtGrass.tickCell(x, y);
                        }
                        break;
                }
            }
        }
    }
}
