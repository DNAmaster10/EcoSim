package Level;

import Level.Cells.*;
import com.raylib.Jaylib;

public class RegisterCells {
    public static void registerCells() {
        //Ocean
        Level.cellNames[0] = "Ocean";
        Level.cellColours[0] = Ocean.properties.color;
        Level.placeableCells[0] = true;

        //Dirt
        Level.cellNames[1] = "Dirt";
        Level.cellColours[1] = Dirt.properties.color;
        Level.placeableCells[1] = true;

        //DirtGrass
        Level.cellNames[2] = "Dirt Grass";
        Level.cellColours[2] = DirtGrass.properties.color;
        Level.placeableCells[2] = false;

        //Beach sand
        Level.cellNames[3] = "Beach Sand";
        Level.cellColours[3] = BeachSand.properties.color;
        Level.placeableCells[3] = true;

        //Empty
        Level.cellNames[4] = "Empty";
        Level.cellColours[4] = Empty.properties.color;
        Level.placeableCells[4] = false;

        //Grass
        Level.cellNames[5] = "Grass";
        Level.cellColours[5] = new Jaylib.Color(17, 145, 52, 255);
        Level.placeableCells[5] = true;

        //CloseOcean
        Level.cellNames[6] = "Close Ocean";
        Level.cellColours[6] = CloseOcean.properties.color;
        Level.placeableCells[6] = true;

        //Hill
        Level.cellNames[7] = "Hill";
        Level.cellColours[7] = Hill.properties.color;
        Level.placeableCells[7] = true;
    }
}
