package controls;

import Level.Level;
import Level.Terrain;
import Level.Player;
import Level.UI.Ui;
import Level.Paint;

import static com.raylib.Raylib.*;

public class HandleInputs {
    public static void mainInputCheck() {
        //Mouse button
        if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
            if (!(GetMouseX() > Level.windowGridWidth)) {
                int[] coords = Level.getGridPos(GetMouseX(), GetMouseY());
                Paint.paint(coords[0], coords[1], Player.placementRectSize, Player.placementCellType);
            }
        }
        else if (IsMouseButtonDown(MOUSE_BUTTON_RIGHT)) {
            int [] coords = Level.getGridPos(GetMouseX(), GetMouseY());
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
        if (GetMouseWheelMove() > 0 && GetMouseX() < Level.uiXStart) {
            Player.placementRectSize = Player.placementRectSize + Math.round(GetMouseWheelMove());
        }
        else if (GetMouseWheelMove() < 0 && GetMouseX() < Level.uiXStart) {
            Player.placementRectSize = Player.placementRectSize + Math.round(GetMouseWheelMove());
            if (Player.placementRectSize < 0) {
                Player.placementRectSize = 0;
            }
        }
    }
}
