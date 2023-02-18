package controls;

import Level.Level;
import Level.Terrain;

import static com.raylib.Raylib.*;

public class HandleInputs {
    public static void mainInputCheck() {
        //Mouse button
        if (IsMouseButtonDown(MOUSE_BUTTON_LEFT)) {
            int[] coords = Level.getGridPos(GetMouseX(), GetMouseY());
            Terrain.drawRectangleTerrain(coords[0], coords[1], 1, 3);
        }
        else if (IsMouseButtonDown(MOUSE_BUTTON_RIGHT)) {
            int [] coords = Level.getGridPos(GetMouseX(), GetMouseY());
            Terrain.drawRectangleTerrain(coords[0], coords[1], 2, 3);
        }
    }
}
