package Level.Cells;

import Level.Terrain;
import com.raylib.Jaylib;

public class Dirt {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(125, 96, 62, 255);
        public static int erosionResistance = 500;
        public static int erosionResistanceMin = 0;
        public static int erosionResistanceMax = 1000;
    }
}


