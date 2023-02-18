package Level;

import com.raylib.Jaylib;

public class UI {
    public static class properties {
        //The width of the scroll wheel on the UI
        public static int scrollWheelWidth = 10;
        //The colour of the scroll wheel on the UI
        public static Jaylib.Color color = new Jaylib.Color(171, 170, 169, 255);

        //An integer indicating the height of the cell selection boxes
        public static int selectBoxHeight = 30;
        //An integer indicating the width of the cell select boxes
        public static int selectBoxWidth;
        //An integer indicating how far down the player has scrolled on the UI
        public static int uiMenuScrollOffset = 0;
        //An array of all CellSelectButtons
        public static cellSelectButton[] cellSelectButtons;
    }
    //buttons must contain a colour.
    public class cellSelectButton {
        public Jaylib.Color color;
        public int cellType;
        public String cellName;
        public Jaylib.Rectangle rectangle;
    }
    public void generateUi() {
        //Calculate button width
        properties.selectBoxWidth = Level.uiWidth - properties.scrollWheelWidth;
        //Generate buttons
        properties.cellSelectButtons = new cellSelectButton[Level.placeableCells.length];
        for (int i = 0; i < Level.placeableCells.length; i++) {
            if (Level.placeableCells[i]) {
                cellSelectButton currentButton = new cellSelectButton();
                currentButton.color = Level.cellColours[i];
                currentButton.cellType = i;
                currentButton.cellName = Level.cellNames[i];
                currentButton.rectangle = new Jaylib.Rectangle();
                currentButton.rectangle.x(Level.windowGridWidth + properties.scrollWheelWidth);
                currentButton.rectangle.y(i * properties.selectBoxHeight);
                currentButton.rectangle.width(properties.selectBoxWidth);
                currentButton.rectangle.height(properties.selectBoxHeight);
                properties.cellSelectButtons[i] = currentButton;
            }
        }
    }
}
