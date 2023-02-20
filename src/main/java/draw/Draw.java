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
    private static int frames = 0;
    private static float frameOffset = 0;

    public static void drawTerrain() {
        Raylib.Rectangle oceanSourceRect = Ocean.properties.rectangle;
        ClearBackground(BLUE);
        Raylib.Rectangle grassSourceRect = new Jaylib.Rectangle(0, 0, 10, 10);
        Raylib.Rectangle destRect = new Jaylib.Rectangle();
        Raylib.Vector2 textureVector = new Jaylib.Vector2().x(0f).y(0f);
        if (frames / 5 > 1) {
            frameOffset += 1;
            Ocean.properties.rectangle.y(frameOffset * 10);
            if (frameOffset > 4) {
                frameOffset = 0;
                Ocean.properties.rectangle.y(0);
            }
            frames = 0;
        }

        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch (Terrain.getCell(x, y)) {
                    case 0:
                        //Ocean
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);

                        Jaylib.DrawTexturePro(Ocean.properties.texture, oceanSourceRect, destRect, textureVector, 0f, WHITE);
                        break;
                    case 1:
                        //Dirt
                        DrawRectangle(Level.cellWidth * x, Level.cellHeight * y, Level.cellWidth, Level.cellHeight, Dirt.properties.color);
                        break;
                    case 2:
                        //DirtGrass
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);

                        Jaylib.DrawTexturePro(DirtGrass.properties.texture, grassSourceRect, destRect, textureVector, 0f, WHITE);
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
        frames++;
        //Unload texture rectangles
        grassSourceRect = null;
        oceanSourceRect = null;
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
        DrawText("WindowPos: " + GetMouseX() + "," + GetMouseY() +
                "\n   Zoom: " + Player.playerZoom +
                "\n   CameraOffset: " + Player.cameraOffset +
                "\n   CameraTarget: " + Player.camera.target() +
                "\n   ScreenToWorld: " + screenToWorld.x() + "," + screenToWorld.y(), 30, 0, 10, WHITE);
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
