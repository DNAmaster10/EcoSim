package draw;

import Level.Cells.*;
import Level.Level;
import Level.Terrain;
import Level.UI.Ui;
import com.raylib.Jaylib;
import Level.Player;
import static com.raylib.Jaylib.WHITE;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;

public class Draw {
    private static Raylib.Vector2 textureVector = new Jaylib.Vector2().x(0f).y(0f);
    private static Raylib.Rectangle destRect = new Jaylib.Rectangle();

    public static void drawTerrain() {
        ClearBackground(BLACK);
        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch (Terrain.getCell(x, y)) {
                    case 0:
                        //Ocean
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);

                        Jaylib.DrawTexturePro(Ocean.properties.texture, Ocean.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 1:
                        //Dirt
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(Dirt.properties.texture, Dirt.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 2:
                        //DirtGrass
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);

                        Jaylib.DrawTexturePro(DirtGrass.properties.texture, DirtGrass.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 3:
                        //BeachSand
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);

                        Jaylib.DrawTexturePro(BeachSand.properties.texture, BeachSand.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 4:
                        //Empty
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Empty.properties.color);
                        break;
                    case 6:
                        //CloseOcean
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(CloseOcean.properties.texture, CloseOcean.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 7:
                        //Hill
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(Hill.properties.texture, Hill.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                }
            }
        }
    }
    public static void drawGridUi() {
        //Draw placement rectangle below mouse. This is drawn inline with the grid.
        if (Player.drawPlacementRect && GetMouseX() < Level.uiXStart) {
            Raylib.Vector2 screenToWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
            int[] gridPos = Level.getGridPos(Math.round(screenToWorldPos.x()), Math.round(screenToWorldPos.y()));
            Jaylib.Rectangle placementRect = new Jaylib.Rectangle((Level.cellWidth * gridPos[0]) - (Player.placementRectSize * Level.cellWidth), (Level.cellHeight * gridPos[1]) - (Player.placementRectSize * Level.cellHeight), ((Player.placementRectSize * 2) + 1) * Level.cellWidth, ((Player.placementRectSize * 2) + 1) * Level.cellHeight);
            DrawRectangleLinesEx(placementRect, 1.0f, LIGHTGRAY);
        }
    }
    public static void drawOverlayUi() {
        DrawFPS(10, 10);
        Raylib.Vector2 screenToWorld = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
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
