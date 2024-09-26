package Level.UI;

import Level.Level;
import com.raylib.Jaylib;
import Level.UI.CellSelectButton;
import Level.RegisterCells;
import Level.RegisterLife;

import java.util.Arrays;

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
        public static LifeSelectButton[] lifeSelectButtons;
    }
    public static void generateUi() {
        //Calculate button width
        properties.selectBoxWidth = Level.uiWidth - properties.scrollWheelWidth;
        int totalPlaceableCells = 0;
        for (int i = 0; i < RegisterCells.placeableCells.length; i++) {
            if (RegisterCells.placeableCells[i]) {
                totalPlaceableCells++;
            }
        }
        RegisterCells.totalPlaceableCells = totalPlaceableCells;
        properties.cellSelectButtons = new CellSelectButton[totalPlaceableCells];
        //Generate buttons
        int totalAddedButtons = 0;
        for (int i = 0; i < RegisterCells.placeableCells.length; i++) {
            if (RegisterCells.placeableCells[i]) {
                CellSelectButton currentButton = new CellSelectButton();
                currentButton.color = RegisterCells.cellColours[i];
                currentButton.cellType = i;
                currentButton.cellName = RegisterCells.cellNames[i];
                currentButton.rectangle = new Jaylib.Rectangle();
                currentButton.rectangle.x(Level.windowGridWidth + properties.scrollWheelWidth);
                currentButton.rectangle.y(totalAddedButtons * properties.selectBoxHeight + totalAddedButtons);
                currentButton.rectangle.width(properties.selectBoxWidth);
                currentButton.rectangle.height(properties.selectBoxHeight);
                properties.cellSelectButtons[totalAddedButtons] = currentButton;
                totalAddedButtons++;
            }
        }
        //Life cells
        int totalPlaceableLife = 0;
        for (int i = 0; i < RegisterLife.placeableLife.length; i++) {
            if (RegisterLife.placeableLife[i]) {
                totalPlaceableLife++;
            }
        }
        RegisterLife.totalPlaceableLife = totalPlaceableLife;
        properties.lifeSelectButtons = new LifeSelectButton[totalPlaceableLife];
        //Generate buttons
        totalAddedButtons = 0;
        for (int i = 0; i < RegisterLife.placeableLife.length; i++) {
            if (RegisterLife.placeableLife[i]) {
                LifeSelectButton currentButton = new LifeSelectButton();
                currentButton.color = RegisterLife.lifeColours[i];
                currentButton.lifeType = i;
                currentButton.lifeName = RegisterLife.lifeNames[i];
                currentButton.rectangle = new Jaylib.Rectangle();
                currentButton.rectangle.x(Level.windowGridWidth + properties.scrollWheelWidth);
                currentButton.rectangle.y(totalAddedButtons * properties.selectBoxHeight + totalAddedButtons);
                currentButton.rectangle.width(properties.selectBoxWidth);
                currentButton.rectangle.height(properties.selectBoxHeight);
                properties.lifeSelectButtons[totalAddedButtons] = currentButton;
                totalAddedButtons++;
            }
        }
    }
}