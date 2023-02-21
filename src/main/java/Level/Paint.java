package Level;

public class Paint {
    public static void paint(int x, int y, int size, int cellType) {
        //Check if specified cell needs to be layered or painted
        switch(cellType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                drawRectangleTerrain(x, y, size, cellType);
                break;
            case 5: {
                //Grass layering
                int[] from = new int[1];
                from[0] = 1;
                int[] to = new int[1];
                to[0] = 2;
                layerFromTo(x, y, size, from, to);
                break;
            }
            case 10: {
                //Fire layering
                int[] from = new int[1];
                from[0] = 2;
                int[] to = new int[1];
                to[0] = 9;
                layerFromTo(x, y, size, from, to);
                break;
            }
        }
    }

    public static void drawRectangleTerrain(int x, int y, int size, int cellType) {
        //First calculate the top left corner of the rectangle
        int[] topLeft = new int[2];
        topLeft[0] = x - size;
        topLeft[1] = y - size;
        for (int currentX = 0; currentX < (size * 2) + 1; currentX++) {
            for (int currentY = 0; currentY < (size * 2) + 1; currentY++) {
                if (Terrain.checkCellExists(topLeft[0] + currentX, topLeft[1] + currentY)) {
                    Terrain.setCell(topLeft[0] + currentX, topLeft[1] + currentY, cellType);
                }
            }
        }
    }

    public static void layerRectangleTerrain(int x, int y, int size, int fromCell, int toCell) {
        int[] topLeft = new int[2];
        topLeft[0] = x - size;
        topLeft[1] = y - size;
        for (int currentX = 0; currentX < (size * 2) + 1; currentX++) {
            for (int currentY = 0; currentY < (size * 2) + 1; currentY++) {
                if (Terrain.checkCellExists(topLeft[0] + currentX, topLeft[1] + currentY) && Terrain.getCell(topLeft[0] + currentX, topLeft[1] + currentY) == fromCell) {
                    Terrain.setCell(topLeft[0] + currentX, topLeft[1] + currentY, toCell);
                }
            }
        }
    }

    public static void layerFromTo(int x, int y, int size, int[] from, int[] to) {
        for (int i = 0; i < from.length; i++) {
            layerRectangleTerrain(x, y, size, from[i], to[i]);
        }
    }
}
