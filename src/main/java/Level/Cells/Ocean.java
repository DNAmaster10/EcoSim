package Level.Cells;

import com.raylib.Jaylib;

public class Ocean {
    public static class properties {
        private static int erosionRate = 1;
        private static int erosionRateMax = 1000;
        private static int erosionRateMin = 0;
        public static Jaylib.Color color = new Jaylib.Color(15, 78, 150, 255);
    }
}
