package Level;

import Level.Cells.*;

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
    }
}
