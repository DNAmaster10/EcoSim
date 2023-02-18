package Level;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    public static List<List<Integer>> cells = new ArrayList<>();
    public static List<List<Boolean>> cellUpdateStatus = new ArrayList<>();

    public static void generate(int windowGridWidth, int windowGridHeight, int cellWidth, int cellHeight) {
        // 0 is water
        // 1 is land
        // 2 is grass
        // 3 is sand
        // 4 is empty

        //Calculate grid size
        Level.gridWidth = windowGridWidth / cellWidth;
        Level.gridHeight = windowGridHeight / cellHeight;

        //Generate terrain
        for (int i = 0; i < Level.gridWidth; i++) {
            cells.add(new ArrayList<>());
            cellUpdateStatus.add(new ArrayList<>());
            for (int j = 0; j < Level.gridHeight; j++) {
                cells.get(i).add(4);
                cellUpdateStatus.get(i).add(false);
            }
        }
    }
    public static int getCell(int x, int y) {
        //Returns an integer indicating the type of cell present
        return (cells.get(x).get(y));
    }
    public static boolean getUpdateStatus(int x, int y) {
        //Returns a boolean indicating whether the given cell has already been updated in the current tick
        return (cellUpdateStatus.get(x).get(y));
    }
    public static boolean checkCellExists(int x, int y) {
        //Returns a boolean indicating whether the given cell exists (For example, if x is below 0, then it's outside the grid and doesn't exist)
        return (!(x < 0) && !(x > Level.gridWidth - 1) && !(y < 0) && !(y > Level.gridHeight - 1));
    }
    public static void setCell(int x, int y, int cellType) {
        //Sets a cell at a given grid location
        cells.get(x).set(y, cellType);
        cellUpdateStatus.get(x).set(y, true);
    }
    public static void resetUpdateStatus() {
        //Sets all update statuses to false
        for (int i = 0; i < Level.gridWidth; i++) {
            for (int j = 0; j < Level.gridHeight; j++) {
                cellUpdateStatus.get(i).set(j, false);
            }
        }
    }
}
