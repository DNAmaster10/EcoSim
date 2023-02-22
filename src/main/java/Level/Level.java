package Level;

import Level.Cells.*;
import com.raylib.Jaylib;
import com.raylib.Raylib;

public class Level {
    //Simulation speed. Lower is higher speed
    public static int simulationSpeed = 2;
    public static int windowHeight = 500;
    public static int windowWidth = 800;
    //The size of the grid on the window in regular pixels
    public static int windowGridWidth = 700;
    public static int windowGridHeight = 500;
    //The size of cells on the grid
    public static int cellWidth = 8;
    public static int cellHeight = 8;
    //The size of the grid where cells can be placed
    public static int gridWidth;
    public static int gridHeight;
    //The size of the Ui
    public static int uiWidth = 100;
    public static int uiHeight = 800;

    //An integer indicating the window x where the Ui starts.
    public static int uiXStart = windowWidth - uiWidth;

    public static String getCellNameById(int id) {
        return(RegisterCells.cellNames[id]);
    }

    public static void doMainTick() {
        Terrain.resetUpdateStatus();
        doUpdateTick();
    }
    public static int[] getGridPos(int x, int y) {
        //Calculates the grid pos of a given x and y taking into account zoom
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
                    case 6:
                        if (!(Terrain.getUpdateStatus(x, y))) {
                            CloseOcean.tickCell(x, y);
                        }
                        break;
                    case 8:
                        if (!(Terrain.getUpdateStatus(x, y))) {
                            ScorchedDirt.tickCell(x, y);
                        }
                        break;
                    case 9:
                        if (!(Terrain.getUpdateStatus(x, y))) {
                            DirtGrassFire.tickCell(x, y);
                        }
                        break;
                }
            }
        }
    }
}