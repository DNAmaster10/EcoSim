package Level.Cells;

import com.raylib.Jaylib;
import com.raylib.Raylib;

public class RiverSource {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(10, 10, 255, 255);
        public static int spreadRate = 10;
        public static int spreadRateMin = 0;
        public static int spreadRateMax = 1000;

        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 10, 10);
    }
    public static void tickCell(int x, int y) {

    }
    public static void tickThisCell(int x, int y) {

    }
}
