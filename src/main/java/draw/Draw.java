package draw;

import Level.Cells.Dirt;
import Level.Cells.DirtGrass;
import Level.Cells.Empty;
import Level.Level;
import Level.Terrain;
import com.raylib.Jaylib;
import Level.Player;

import java.awt.*;

import static com.raylib.Jaylib.*;

public class Draw {
    private static Jaylib.Rectangle placementRect;

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
                        //DirtGrass
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, DirtGrass.properties.color);
                        break;
                    case 3:
                        //BeachSand
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, YELLOW);
                        break;
                    case 4:
                        //Empty
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Empty.properties.color);
                        break;
                }
            }
        }
    }
    public static void drawUi() {
        DrawFPS(10, 10);
        //Draw placement rectangle below mouse. This is drawn inline with the grid.
        if (Player.drawPlacementRect) {
            int[] gridPos = Level.getGridPos(GetMouseX(), GetMouseY());
            placementRect = new Jaylib.Rectangle((Level.cellWidth * gridPos[0]) - (Player.placementRectSize * Level.cellWidth), (Level.cellHeight * gridPos[1]) - (Player.placementRectSize * Level.cellHeight), ((Player.placementRectSize * 2) + 1) * Level.cellWidth, ((Player.placementRectSize * 2) + 1) * Level.cellHeight);
            DrawRectangleLinesEx(placementRect, 1.0f, LIGHTGRAY);
        }
    }
}
