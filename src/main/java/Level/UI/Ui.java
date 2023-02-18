package Level.UI;

import Level.Level;
import com.raylib.Jaylib;
import Level.UI.CellSelectButton;

public class Ui {
    public static class properties {
        //The width of the scroll wheel on the Ui
        public static int scrollWheelWidth = 10;
        //The colour of the scroll wheel on the Ui
        public static Jaylib.Color color = new Jaylib.Color(171, 170, 169, 255);

        //An integer indicating the height of the cell selection boxes
        public static int selectBoxHeight = 30;
        //An integer indicating the width of the cell select boxes
        public static int selectBoxWidth;
        //An integer indicating how far down the player has scrolled on the Ui
        public static int uiMenuScrollOffset = 0;
        //An array of all CellSelectButtons
        public static CellSelectButton[] cellSelectButtons;
    }
    public static void generateUi() {
        //Calculate button width
        properties.selectBoxWidth = Level.uiWidth - properties.scrollWheelWidth;
        int totalPlaceableCells = 0;
        for (int i = 0; i < Level.placeableCells.length; i++) {
            if (Level.placeableCells[i]) {
                totalPlaceableCells++;
            }
        }
        Level.totalPlaceableCells = totalPlaceableCells;
        properties.cellSelectButtons = new CellSelectButton[totalPlaceableCells];
        //Generate buttons
        int totalAddedButtons = 0;
        for (int i = 0; i < Level.placeableCells.length; i++) {
            if (Level.placeableCells[i]) {
                CellSelectButton currentButton = new CellSelectButton();
                currentButton.color = Level.cellColours[i];
                currentButton.cellType = i;
                currentButton.cellName = Level.cellNames[i];
                currentButton.rectangle = new Jaylib.Rectangle();
                currentButton.rectangle.x(Level.windowGridWidth + properties.scrollWheelWidth);
                currentButton.rectangle.y(totalAddedButtons * properties.selectBoxHeight + (1 * totalAddedButtons));
                currentButton.rectangle.width(properties.selectBoxWidth);
                currentButton.rectangle.height(properties.selectBoxHeight);
                properties.cellSelectButtons[totalAddedButtons] = currentButton;
                totalAddedButtons++;
            }
        }
    }
}
