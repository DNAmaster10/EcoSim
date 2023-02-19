package Level;

import Level.Cells.DirtGrass;
import Level.Cells.Ocean;
import com.raylib.Jaylib;

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
    //The size of the Ui
    public static int uiWidth = 100;
    public static int uiHeight = 800;

    //An array containing the names of cells with their index corresponding to their cell id.
    public static String[] cellNames = new String[6];
    //An array of colours where the index of the colour matches the cells id
    public static Jaylib.Color[] cellColours = new Jaylib.Color[6];
    //An array of boolean values indicating the cell can be placed by the player. For example, dirt grass can only be created by placing grass on top of dirt.
    public static boolean[] placeableCells = new boolean[6];
    //An integer indicating the amount of cells which are placeable
    public static int totalPlaceableCells;
    //A 2D array indicating the total amount of

    //An integer indicating the window x where the Ui starts.
    public static int uiXStart = windowWidth - uiWidth;

    public static String getCellNameById(int id) {
        return(cellNames[id]);
    }

    public static void doMainTick() {
        Terrain.resetUpdateStatus();
        doUpdateTick();
    }
    public static int[] getGridPos(int x, int y) {
        //Calculates the grid pos of a given x and y taking into account zoom
        int[] returnArray = new int[2];
        returnArray[0] = (x / Level.cellWidth) / Math.round(Player.playerZoom);
        returnArray[1] = (y / Level.cellHeight) / Math.round(Player.playerZoom);
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
