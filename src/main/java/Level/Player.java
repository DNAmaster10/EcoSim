package Level;

public class Player {
    //The brush size
    public static int placementRectSize = 2;
    //The drawn brush size
    public static float drawnPlacementRectSize = 2f;
    //Whether the brush should be drawn or not
    public static boolean drawPlacementRect = true;
    //The current selected cell type
    public static int placementCellType = 0;
    //A string indicating the selected cell type
    public static String placementText = "Ocean";

    //Camera
    //An integer indicating the x of the camera
    public static float playerX = 10f;
    public static float playerY = 10f;
    public static float playerZoom = 1f;


    public static void setPlacementType(int cellType) {
        //Changes the selected cell type
        placementCellType = cellType;

        //Get the string for the cell type
        placementText = Level.getCellNameById(cellType);
    }

    //Camera methods
    public static void changeZoom(float zoomChange) {
        int roundedZoomChange = Math.round(zoomChange);
        if (!(Player.playerZoom + roundedZoomChange < 1)) {
            Player.playerZoom += roundedZoomChange;
        }
        else {
            Player.playerZoom = 1f;
        }
    }
}