package Level;

import Level.Cells.DirtGrass;
import Level.Cells.Ocean;
import com.raylib.Jaylib;

import java.util.List;

public class Level {
    public static int windowHeight = 800;
    public static int windowWidth = 800;
    //The size of the grid on the window in regular pixels
    public static int windowGridWidth = 700;
    public static int windowGridHeight = 800;
    //The size of cells on the grid
    public static int cellWidth = 8;
    public static int cellHeight = 8;
    //The size of the grid where cells can be placed
    public static int gridWidth;
    public static int gridHeight;
    //The size of the UI
    public static int uiWidth = 100;
    public static int uiHeight = 800;
    //An array containing the names of cells with their index corresponding to their cell id.
    public static String[] cellNames = new String[5];
    //An array of colours where the index of the colour matches the cells id
    public static Jaylib.Color[] cellColours = new Jaylib.Color[5];
    //An array of boolean values indicating whether or not the cell can be placed by the player. For example, dirt grass can only be created by placing grass on top of dirt.
    public static boolean[] placeableCells = new boolean[5];
    //An integer indicating the window x where the UI starts.
    public static int uiXStart = windowWidth - uiWidth;


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
