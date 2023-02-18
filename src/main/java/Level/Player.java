package Level;

import com.raylib.Jaylib;

public class Player {
    //The brush size
    public static int placementRectSize = 2;
    //Whether the brush should be drawn or not
    public static boolean drawPlacementRect = true;
    //The current selected cell type
    public static int placementCellType = 0;
    //A string indicating the selected cell type
    public static String placementText = "Ocean";

    public static void setPlacementType(int cellType) {
        //Changes the selected cell type
        placementCellType = cellType;

        //Get the string for the cell type
        placementText = Level.getCellNameById(cellType);
    }
}
