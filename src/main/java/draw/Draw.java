package draw;

import Level.Cells.*;
import Level.Level;
import Level.Life.*;
import Level.Terrain;
import Level.UI.Ui;
import com.raylib.Jaylib;
import Level.Player;
import static com.raylib.Jaylib.WHITE;
import com.raylib.Raylib;
import Level.LifeLayer;

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
                    case 8:
                        //Scorched Dirt
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(ScorchedDirt.properties.texture, ScorchedDirt.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 9:
                        //DirtGrassFire
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(DirtGrassFire.properties.texture, DirtGrassFire.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 11:
                        //FertileDirt
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(FertileDirt.properties.texture, FertileDirt.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                    case 12:
                        //FertileDirtGrass
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(FertileDirtGrass.properties.texture, FertileDirtGrass.properties.textureRectanlge, destRect, textureVector, 0f, WHITE);
                        break;
                }
            }
        }
        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch(LifeLayer.getLifeType(x, y)) {
                    case 1:
                        //Oak Sapling
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 1).width(Level.cellWidth).height(Level.cellHeight + 1);
                        Jaylib.DrawTexturePro(OakSapling.properties.texture, OakSapling.properties.textureRectangle, destRect, textureVector, 1f, WHITE);
                        break;
                    case 2:
                        //Young oak tree
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 1).width(Level.cellWidth + 1).height(Level.cellHeight + 2);
                        Jaylib.DrawTexturePro(YoungOakTree.properties.texture, YoungOakTree.properties.textureRectangle, destRect, textureVector, 1f, WHITE);
                        break;
                    case 3:
                        //Oak Tree
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 4).width(Level.cellWidth + 4).height(Level.cellHeight + 5);
                        Jaylib.DrawTexturePro(OakTree.properties.texture, OakTree.properties.textureRectangle, destRect, textureVector, -1f, WHITE);
                        break;
                    case 4:
                        //Burning Oak Sapling
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 1).width(Level.cellWidth).height(Level.cellHeight + 1);
                        Jaylib.DrawTexturePro(OakSaplingFire.properties.texture, OakSaplingFire.properties.textureRectangle, destRect, textureVector, 1f, WHITE);
                        break;
                    case 5:
                        //Burnt oak sapling
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 1).width(Level.cellWidth).height(Level.cellHeight + 1);
                        Jaylib.DrawTexturePro(BurntOakSapling.properties.texture, BurntOakSapling.properties.textureRectangle, destRect, textureVector, 1f, WHITE);
                        break;
                    case 6:
                        //Young Oak Tree Fire
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 1).width(Level.cellWidth + 1).height(Level.cellHeight + 2);
                        Jaylib.DrawTexturePro(YoungOakTreeFire.properties.texture, YoungOakTreeFire.properties.textureRectangle, destRect, textureVector, 1f, WHITE);
                        break;
                    case 7:
                        //Burnt Young Oak Tree
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 1).width(Level.cellWidth + 1).height(Level.cellHeight + 2);
                        Jaylib.DrawTexturePro(BurntYoungOakTree.properties.texture, BurntYoungOakTree.properties.textureRectangle, destRect, textureVector, 1f, WHITE);
                        break;
                    case 8:
                        //Oak Tree Fire
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 4).width(Level.cellWidth + 4).height(Level.cellHeight + 5);
                        Jaylib.DrawTexturePro(OakTreeFire.properties.texture, OakTreeFire.properties.textureRectangle, destRect, textureVector, -1f, WHITE);
                        break;
                    case 9:
                        //Burnt Oak Tree
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y - 4).width(Level.cellWidth + 4).height(Level.cellHeight + 5);
                        Jaylib.DrawTexturePro(BurntOakTree.properties.texture, BurntOakTree.properties.textureRectangle, destRect, textureVector, -1f, WHITE);
                        break;
                    case 10:
                        //Bluebell
                        destRect.x(Level.cellWidth * x).y(Level.cellHeight * y).width(Level.cellWidth).height(Level.cellHeight);
                        Jaylib.DrawTexturePro(Bluebell.properties.texture, Bluebell.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
                        break;
                }
            }
        }
        //destRect.x(100).y(100).width(100).height(100);
        //Jaylib.DrawTexturePro(Bluebell.properties.texture, Bluebell.properties.textureRectangle, destRect, textureVector, 0f, WHITE);
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
        Jaylib.DrawText("Roughness: " + Player.roughness, 30, 30, 30, WHITE);
        //Draw placement menu
        //Draw scroll

        //Draw buttons
        if (!Player.lifeMode) {
            int xButtonOffset = Ui.properties.scrollWheelWidth;
            int yButtonOffset = Ui.properties.uiMenuScrollOffset;
            int buttonWidth = Ui.properties.selectBoxWidth;
            for (int i = 0; i < Ui.properties.cellSelectButtons.length; i++) {
                DrawRectangleRec(Ui.properties.cellSelectButtons[i].rectangle, WHITE);
                DrawText(Ui.properties.cellSelectButtons[i].cellName, (int) Ui.properties.cellSelectButtons[i].rectangle.x(), (int) Ui.properties.cellSelectButtons[i].rectangle.y(), 10, BLACK);
            }
        }
        else {
            for (int i = 0; i < Ui.properties.lifeSelectButtons.length; i++) {
                DrawRectangleRec(Ui.properties.lifeSelectButtons[i].rectangle, WHITE);
                DrawText(Ui.properties.lifeSelectButtons[i].lifeName, (int) Ui.properties.lifeSelectButtons[i].rectangle.x(), (int) Ui.properties.lifeSelectButtons[i].rectangle.y(), 10, BLACK);
            }
        }
    }
}
