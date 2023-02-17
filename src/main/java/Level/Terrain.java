package Level;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    public static List<List<Integer>> cells = new ArrayList<List<Integer>>();
    public static List<List<Boolean>> cellUpdateStatus = new ArrayList<List<Boolean>>();

    public static void generate(int windowWidth, int windowHeight, int cellWidth, int cellHeight) {
        // 0 is water
        // 1 is land
        // 2 is grass
        // 3 is sand

        //Calculate grid size
        Level.gridWidth = windowWidth / cellWidth;
        Level.gridHeight = windowHeight / cellHeight;

        //Generate terrain
        for (int i = 0; i < Level.gridWidth; i++) {
            cells.add(new ArrayList<Integer>());
            cellUpdateStatus.add(new ArrayList<Boolean>());
            for (int j = 0; j < Level.gridHeight; j++) {
                cells.get(i).add(0);
                cellUpdateStatus.get(i).add(false);
            }
        }
        setCell(9, 9, 1);
    }
    public static int getCell(int x, int y) {
        //Returns an integer indicating the type of cell present
        return (cells.get(y).get(x));
    }
    public static boolean getUpdateStatus(int x, int y) {
        //Returns a boolean indicating whether the given cell has already been updated in the current tick
        return (cellUpdateStatus.get(y).get(x));
    }
    public static void setCell(int x, int y, int cellType) {
        //Sets a cell at a given grid location
        cells.get(y).set(x, cellType);
        cellUpdateStatus.get(y).set(x, true);
    }
    public static void resetUpdateStatus() {
        //Sets all update statuses to false
        for (int i = 0; i < Level.gridWidth; i++) {
            for (int j = 0; j < Level.gridHeight; j++) {
                cellUpdateStatus.get(i).set(j, false);
            }
        }
    }

    public static void drawRectangleTerrain(int x, int y, int cellType, int size) {
        int[] topLeft = new int[2];
        topLeft[0] = x - size;
        topLeft[1] = y - size;
        if (size > 0) {
            for (int currentY = topLeft[1]; currentY < y + (size * 2); currentY++) {
                if (!(currentY < 0) && !(currentY > Level.gridHeight)) {
                    for (int currentX = topLeft[0]; currentX < x + (size * 2); currentX++) {
                        if (!(currentX < 0) && !(currentX > Level.gridWidth)) {
                            setCell(currentX, currentY, cellType);
                        }
                    }
                }
            }
        }
        else {
            setCell(x, y, cellType);
        }
    }
}
