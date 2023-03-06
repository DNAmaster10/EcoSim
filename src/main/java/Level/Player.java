package Level;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class Player {
    public static boolean lifeMode = false;
    //The brush size
    public static int placementRectSize = 2;
    //The drawn brush size
    public static float drawnPlacementRectSize = 2f;
    //Whether the brush should be drawn or not
    public static boolean drawPlacementRect = true;
    //The current selected cell type
    public static int placementCellType = 0;
    public static int placementLifeType = 3;
    //A string indicating the selected cell type
    public static String placementText = "Ocean";

    //Camera
    public static Raylib.Camera2D camera = new Raylib.Camera2D(0);

    //An integer indicating the x of the camera
    public static float playerX = 10f;
    public static float playerY = 10f;
    public static Raylib.Vector2 cameraOffset = new Jaylib.Vector2().y(0f).y(0f);
    public static float playerZoom = 1f;

    public static int roughness = 50;
    public static int variation = 100;

    public static void resetCamera() {
        cameraOffset.y(0f).x(0f);
        playerZoom = 1f;
        Player.camera.rotation(0f);
    }

    public static void setPlacementCellType(int cellType) {
        //Changes the selected cell type
        placementCellType = cellType;

        //Get the string for the cell type
        placementText = Level.getCellNameById(cellType);
    }

    public static void setPlacementLifeType(int lifeType) {
        placementLifeType = lifeType;
    }

    //Camera methods
    public static void changeZoom(float zoomChange) {
        int roundedZoomChange = Math.round(zoomChange);
        //Zoom in and out
        if (!(Player.playerZoom + roundedZoomChange <= 1)) {
            //Reset camera
            Player.playerZoom += roundedZoomChange;
            Raylib.Vector2 mouseWorldPos = Raylib.GetScreenToWorld2D(Raylib.GetMousePosition(), Player.camera);
            Player.cameraOffset = Raylib.GetMousePosition();
            Player.camera.offset(Raylib.GetMousePosition());
            Player.camera.target(mouseWorldPos);
        }
        else {
            Player.playerZoom = 1f;
            Player.cameraOffset.x(0f).y(0f);
            Player.camera.offset(Player.cameraOffset);
            Player.camera.target().x(0f).y(0f);
        }
        //Relocate camera to where player zoomed
        Player.camera.zoom(Player.playerZoom);
    }
}