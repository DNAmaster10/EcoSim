package Level.Life;

import Level.LifeLayer;
import Level.Terrain;
import com.raylib.Jaylib;
import com.raylib.Raylib;

public class OakTreeFire {
    public static class properties {
        public static Jaylib.Color color = new Jaylib.Color(166, 37, 2, 255);
        public static Raylib.Texture texture;
        public static Raylib.Rectangle textureRectangle = new Jaylib.Rectangle(0, 0, 14, 15);

        //Animation
        public static int frameIncrement = 0;
        public static int currentAnimationFrame = 0;
        public static int maxFrames = 2;
        public static int animationSpeed = 10;
    }
    public static void tickFrame() {
        properties.currentAnimationFrame += 1;
        if (properties.currentAnimationFrame > properties.maxFrames) {
            properties.currentAnimationFrame = 0;
        }
        properties.textureRectangle.y(properties.currentAnimationFrame * 15);
        properties.frameIncrement = 0;
    }
    public static void tickObject(int x, int y) {
        //This life
        if (!LifeLayer.getUpdateStatus(x, y)) {
            tickThisLife(x, y);
        }
    }
    public static void tickThisLife(int x, int y) {
        //Check cells beneath
        boolean end = false;
        switch(Terrain.getCell(x, y)) {
            case 1:
            case 2:
            case 8:
                LifeLayer.setLife(x, y, 9);
                end = true;
                break;
            case 0:
            case 3:
            case 4:
            case 6:
            case 7:
                LifeLayer.setLife(x, y, 0);
                end = true;
                break;
        }
        if (end) {
            return;
        }
    }
}
