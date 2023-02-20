package Level.Cells;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class Dirt {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(125, 96, 62, 255);
        public static int erosionResistance = 500;
        public static int erosionResistanceMin = 0;
        public static int erosionResistanceMax = 1000;
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
    }
}


