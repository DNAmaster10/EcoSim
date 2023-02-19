package draw;

import Level.Cells.*;
import Level.Level;
import Level.Terrain;
import Level.UI.Ui;
import com.raylib.Jaylib;
import Level.Player;
import com.raylib.Jaylib.Color;
import static com.raylib.Jaylib.WHITE;
import com.raylib.Raylib;


import java.util.concurrent.ThreadLocalRandom;

import static com.raylib.Jaylib.*;

public class Draw {

    public static void drawTerrain() {
        ClearBackground(BLUE);
        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch (Terrain.getCell(x, y)) {
                    case 0:
                        //Ocean
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Ocean.properties.color);
                        break;
                    case 1:
                        //Dirt
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Dirt.properties.color);
                        break;
                    case 2:
                        //DirtGrass
                        Raylib.Rectangle sourceRect = new Jaylib.Rectangle(0, 0, 10, 10);
                        Raylib.Rectangle destRect = new Jaylib.Rectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight);
                        Raylib.Vector2 vector = new Jaylib.Vector2();
                        vector.x(0);
                        vector.y(0);

                        Jaylib.DrawTexturePro(DirtGrass.properties.texture, sourceRect, destRect, vector, 0f, WHITE);
                        break;
                    case 3:
                        //BeachSand
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, BeachSand.properties.color);
                        break;
                    case 4:
                        //Empty
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Empty.properties.color);
                        break;
                }
            }
        }
    }
    public static void drawGridUi() {
        //Draw placement rectangle below mouse. This is drawn inline with the grid.
        if (Player.drawPlacementRect && GetMouseX() < Level.uiXStart) {
            int[] gridPos = Level.getGridPos(GetMouseX(), GetMouseY());
            Jaylib.Rectangle placementRect = new Jaylib.Rectangle((Level.cellWidth * gridPos[0]) - (Player.placementRectSize * Level.cellWidth), (Level.cellHeight * gridPos[1]) - (Player.placementRectSize * Level.cellHeight), ((Player.placementRectSize * 2) + 1) * Level.cellWidth, ((Player.placementRectSize * 2) + 1) * Level.cellHeight);
            DrawRectangleLinesEx(placementRect, 1.0f, LIGHTGRAY);
        }
    }
    public static void drawOverlayUi() {
        DrawFPS(10, 10);
        DrawText(GetMouseX() + "," + GetMouseY() + "   " + Player.playerZoom, 30, 0, 10, WHITE);
        //Draw placement menu
        //Draw scroll

        //Draw buttons
        int xButtonOffset = Ui.properties.scrollWheelWidth;
        int yButtonOffset = Ui.properties.uiMenuScrollOffset;
        int buttonWidth = Ui.properties.selectBoxWidth;
        for (int i = 0; i < Ui.properties.cellSelectButtons.length; i++) {
            DrawRectangleRec(Ui.properties.cellSelectButtons[i].rectangle, WHITE);
            DrawText(Ui.properties.cellSelectButtons[i].cellName,(int) Ui.properties.cellSelectButtons[i].rectangle.x(), (int) Ui.properties.cellSelectButtons[i].rectangle.y(), 10, BLACK);
        }
    }
}
