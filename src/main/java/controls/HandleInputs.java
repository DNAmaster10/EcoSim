package controls;

import Level.Level;
import Level.Terrain;
import Level.Player;

import static com.raylib.Raylib.*;

public class HandleInputs {
    public static void mainInputCheck() {
        //Mouse button
        if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
            int[] coords = Level.getGridPos(GetMouseX(), GetMouseY());
            Terrain.drawRectangleTerrain(coords[0], coords[1], 1, Player.placementRectSize);
        }
        else if (IsMouseButtonDown(MOUSE_BUTTON_RIGHT)) {
            int [] coords = Level.getGridPos(GetMouseX(), GetMouseY());
            Terrain.drawRectangleTerrain(coords[0], coords[1], 0, Player.placementRectSize);
        }
        //Scroll wheel
        if (GetMouseWheelMove() > 0) {
            Player.placementRectSize = Player.placementRectSize + Math.round(GetMouseWheelMove());
        }
        else if (GetMouseWheelMove() < 0) {
            Player.placementRectSize = Player.placementRectSize + Math.round(GetMouseWheelMove());
            if (Player.placementRectSize < 0) {
                Player.placementRectSize = 0;
            }
        }
    }
}
