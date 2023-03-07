package controls;

import Level.Level;
import Level.Player;
import Level.UI.Ui;
import Level.Paint;
import com.raylib.Raylib;
import Level.LifeLayer;
import Level.Terrain;

import static com.raylib.Raylib.*;

public class HandleInputs {
    public static boolean wasPressed = false;
    public static void mainInputCheck() {
        //Mouse button
        if (!Player.lifeMode) {
            //Cell mode
            if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
                if (!(GetMouseX() > Level.windowGridWidth)) {
                    Raylib.Vector2 screenToWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
                    int[] coords = Level.getGridPos(Math.round(screenToWorldPos.x()), Math.round(screenToWorldPos.y()));
                    Paint.paint(coords[0], coords[1], Player.placementRectSize, Player.placementCellType);
                }
            } else if (IsMouseButtonDown(MOUSE_BUTTON_RIGHT)) {
                Raylib.Vector2 screenToWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
                int[] coords = Level.getGridPos(Math.round(screenToWorldPos.x()), Math.round(screenToWorldPos.y()));
                Paint.paint(coords[0], coords[1], Player.placementRectSize, 4);
            }
            //Change type check
            if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT) && GetMouseX() > Level.windowGridWidth) {
                for (int i = 0; i < Ui.properties.cellSelectButtons.length; i++) {
                    if (CheckCollisionPointRec(GetMousePosition(), Ui.properties.cellSelectButtons[i].rectangle)) {
                        Player.setPlacementCellType(Ui.properties.cellSelectButtons[i].cellType);
                    }
                }
            }
        }
        else {
            //Life mode
            if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                //Draw life
                if (!(GetMouseX() > Level.windowGridWidth)) {
                    Raylib.Vector2 screenToWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
                    int[] coords = Level.getGridPos(Math.round(screenToWorldPos.x()), Math.round(screenToWorldPos.y()));
                    if (LifeLayer.checkLifeExists(coords[0], coords[1])) {
                        LifeLayer.setLife(coords[0], coords[1], Player.placementLifeType);
                    }
                }
                else {
                    //Select life
                    for (int i = 0; i < Ui.properties.lifeSelectButtons.length; i++) {
                        if (CheckCollisionPointRec(GetMousePosition(), Ui.properties.lifeSelectButtons[i].rectangle)) {
                            Player.setPlacementLifeType(Ui.properties.lifeSelectButtons[i].lifeType);
                        }
                    }
                }
            }
        }
        //Scroll wheel
        if (!IsKeyDown(KEY_LEFT_SHIFT)) {
            //Chance placement rect size if shift key is not pressed
            if (GetMouseWheelMove() > 0 && GetMouseX() < Level.uiXStart) {
                //Increase
                Player.placementRectSize = Player.placementRectSize + Math.round(GetMouseWheelMove());
            }
            else if (GetMouseWheelMove() < 0 && GetMouseX() < Level.uiXStart) {
                //Decrease
                Player.placementRectSize = Player.placementRectSize + Math.round(GetMouseWheelMove());
                if (Player.placementRectSize < 0) {
                    Player.placementRectSize = 0;
                }
            }
        }
        else {
            //Else, change zoom
            if (GetMouseWheelMove() != 0 && GetMouseX() < Level.uiXStart) {
                Player.changeZoom(GetMouseWheelMove());
            }
        }
        //Toggle life mode
        if (IsKeyPressed(KEY_L)) {
            Player.lifeMode = !Player.lifeMode;
        }
        //reset camera
        if (IsKeyPressed(KEY_R)) {
            Player.resetCamera();
        }
        //regen world
        if (IsKeyPressed(KEY_G)) {
            Terrain.regenerate(10, Player.roughness, 0, 100);
        }

        if (IsKeyDown(KEY_N)) {
            Player.roughness = Player.roughness - 100;
            if (Player.roughness <= 0) {
                Player.roughness = 1;
            }
            wasPressed = true;
        }
        else if (IsKeyDown(KEY_M)) {
            Player.roughness = Player.roughness + 100;
            wasPressed = true;
        }
        else if (wasPressed) {
            wasPressed = false;
            Terrain.regenerate(9, Player.roughness, 0, 100);
        }
        if (IsKeyDown(KEY_J)) {
            Player.variation = Player.variation - Player.roughness / 100;
            if (Player.variation < 10) {
                Player.variation = 10;
            }
            Terrain.reGenerateVariation();
        }
        if (IsKeyDown(KEY_K)) {
            Player.variation = Player.variation + Player.roughness / 100;
            Terrain.reGenerateVariation();
        }
    }
}
