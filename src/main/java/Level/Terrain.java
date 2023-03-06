package Level;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    public static List<List<Integer>> cells = new ArrayList<>();
    public static List<List<Boolean>> cellUpdateStatus = new ArrayList<>();
    public static int[][] heightMap;

    public static int getCell(int x, int y) {
        //Returns an integer indicating the type of cell present
        return (cells.get(x).get(y));
    }
    public static boolean checkCell(int x, int y) {
        //returns a boolean indicating whether or not a cell exists (i.e not outside the grid)
        return(y > 0 && (y < Level.gridHeight - 1) && x > 0 && x < Level.gridWidth - 1);
    }
    public static boolean getUpdateStatus(int x, int y) {
        //Returns a boolean indicating whether the given cell has already been updated in the current tick
        return (cellUpdateStatus.get(x).get(y));
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

    public static void generate(int windowGridWidth, int windowGridHeight, int cellWidth, int cellHeight) {

        Level.gridWidth = windowGridWidth / cellWidth;
        Level.gridHeight = windowGridHeight / cellHeight;
        //Generate height map
        //Formula to convert scale into grid size is 2^n + 1
        heightMap = HeightMap.generate(9, 500, 0, 100);
        //Generate terrain and life layer
        for (int i = 0; i < Level.gridWidth; i++) {
            cells.add(new ArrayList<>());
            cellUpdateStatus.add(new ArrayList<>());
            LifeLayer.life.add(new ArrayList<>());
            LifeLayer.lifeUpdateStatus.add(new ArrayList<>());
            for (int j = 0; j < Level.gridHeight; j++) {
                //Ocean
                //Ocean
                if (heightMap[i][j] < 20) {
                    cells.get(i).add(0);
                }
                else if(heightMap[i][i] < 30) {
                    cells.get(i).add(6);
                }
                else if(heightMap[i][j] < 60) {
                    cells.get(i).add(2);
                }
                else if(heightMap[i][j] < 80) {
                    cells.get(i).add(12);
                }
                else if(heightMap[i][i] < 200){
                    cells.get(i).add(7);
                }
                else {
                    cells.get(i).add(8);
                    System.out.println(heightMap[i][j]);
                }
                cellUpdateStatus.get(i).add(false);
                LifeLayer.life.get(i).add(0);
                LifeLayer.lifeUpdateStatus.get(i).add(false);
            }
        }
    }
    public static void regenerate(int scale, int roughness, int minHeight, int maxHeight) {
        heightMap = HeightMap.generate(scale, roughness, minHeight, maxHeight);
        int heightMapNum;
        for (int j = 0; j < Level.gridWidth; j++) {
            for (int i = 0; i < Level.gridHeight; i++) {
                heightMapNum = heightMap[i][j];
                if (heightMapNum < 20) {
                    cells.get(i).set(j, 0);
                } else if (heightMapNum < 30) {
                    cells.get(i).set(j, 6);
                } else if (heightMapNum < 60) {
                    cells.get(i).set(j, 2);
                } else if (heightMapNum < 80) {
                    cells.get(i).set(j, 12);
                } else if (heightMapNum < 200) {
                    cells.get(i).set(j, 7);
                } else {
                    cells.get(i).set(j, 7);
                }
                cellUpdateStatus.get(i).set(j, false);
                LifeLayer.life.get(i).set(j, 0);
                LifeLayer.lifeUpdateStatus.get(i).set(j, false);
            }
        }
    }
}