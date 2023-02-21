package Level;

import Level.Cells.*;
import com.raylib.Jaylib;

public class RegisterCells {
    //An integer showing the total amount of cells
    public static int totalCells = 11;
    //An array containing the names of cells with their index corresponding to their cell id.
    public static String[] cellNames = new String[totalCells];
    //An array of colours where the index of the colour matches the cells id
    public static Jaylib.Color[] cellColours = new Jaylib.Color[totalCells];
    //An array of boolean values indicating the cell can be placed by the player. For example, dirt grass can only be created by placing grass on top of dirt.
    public static boolean[] placeableCells = new boolean[totalCells];
    //An integer indicating the amount of cells which are placeable
    public static int totalPlaceableCells;
    public static void registerCells() {
        //Ocean
        cellNames[0] = "Ocean";
        cellColours[0] = Ocean.properties.color;
        placeableCells[0] = true;

        //Dirt
        cellNames[1] = "Dirt";
        cellColours[1] = Dirt.properties.color;
        placeableCells[1] = true;

        //DirtGrass
        cellNames[2] = "Dirt Grass";
        cellColours[2] = DirtGrass.properties.color;
        placeableCells[2] = false;

        //Beach sand
        cellNames[3] = "Beach Sand";
        cellColours[3] = BeachSand.properties.color;
        placeableCells[3] = true;

        //Empty
        cellNames[4] = "Empty";
        cellColours[4] = Empty.properties.color;
        placeableCells[4] = false;

        //Grass
        cellNames[5] = "Grass";
        cellColours[5] = new Jaylib.Color(17, 145, 52, 255);
        placeableCells[5] = true;

        //CloseOcean
        cellNames[6] = "Close Ocean";
        cellColours[6] = CloseOcean.properties.color;
        placeableCells[6] = true;

        //Hill
        cellNames[7] = "Hill";
        cellColours[7] = Hill.properties.color;
        placeableCells[7] = true;

        //Scorched Dirt
        cellNames[8] = "Scorched Dirt";
        cellColours[8] = ScorchedDirt.properties.color;
        placeableCells[8] = true;

        //Dirt Grass Fire
        cellNames[9] = "Dirt Grass Fire";
        cellColours[9] = new Jaylib.Color(255, 136, 0, 255);
        placeableCells[9] = false;

        //Fire
        cellNames[10] = "Fire";
        cellColours[10] = DirtGrassFire.properties.color;
        placeableCells[10] = true;
    }
}
