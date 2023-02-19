package controls;

import Level.Level;
import Level.Player;
import Level.UI.Ui;
import Level.Paint;
import com.raylib.Raylib;

import static com.raylib.Raylib.*;

public class HandleInputs {
    public static void mainInputCheck() {
        //Mouse button
        if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
            if (!(GetMouseX() > Level.windowGridWidth)) {
                Raylib.Vector2 screenToWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
                int[] coords = Level.getGridPos(Math.round(screenToWorldPos.x()), Math.round(screenToWorldPos.y()));
                Paint.paint(coords[0], coords[1], Player.placementRectSize, Player.placementCellType);
            }
        }
        else if (IsMouseButtonDown(MOUSE_BUTTON_RIGHT)) {
            Raylib.Vector2 screenToWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
            int[] coords = Level.getGridPos(Math.round(screenToWorldPos.x()), Math.round(screenToWorldPos.y()));
            Paint.paint(coords[0], coords[1], Player.placementRectSize, 4);
        }
        //Change type check
        if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT) && GetMouseX() > Level.windowGridWidth) {
            for (int i = 0; i < Ui.properties.cellSelectButtons.length; i++) {
                if (CheckCollisionPointRec(GetMousePosition(), Ui.properties.cellSelectButtons[i].rectangle)) {
                    Player.setPlacementType(Ui.properties.cellSelectButtons[i].cellType);
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
    }
}
