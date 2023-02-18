package draw;

import Level.Cells.Dirt;
import Level.Cells.Grass;
import Level.Level;
import Level.Terrain;

import static com.raylib.Jaylib.*;

public class Draw {
    public static void drawTerrain() {
        ClearBackground(BLUE);
        for (int y = 0; y < Level.gridWidth; y++) {
            for (int x = 0; x < Level.gridHeight; x++) {
                switch (Terrain.getCell(x, y)) {
                    case 0:
                        //Ocean
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, BLUE);
                        break;
                    case 1:
                        //Dirt
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Dirt.properties.color);
                        break;
                    case 2:
                        //Grass
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Grass.properties.color);
                        break;
                    case 3:
                        //Sand
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, YELLOW);
                        break;
                }
            }
        }
    }
    public static void drawUi() {
        DrawFPS(10, 10);
    }
}
