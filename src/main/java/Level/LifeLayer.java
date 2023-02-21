package Level;

import Level.Life.OakSapling;

import java.util.ArrayList;
import java.util.List;

public class LifeLayer {
    //0 is no life
    //1 is OakSapling

    public static List<List<Integer>> life = new ArrayList<>();
    public static List<List<Boolean>> lifeUpdateStatus = new ArrayList<>();

    public static void doLifeTick() {
        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch (getLifeType(x, y)) {
                    case 1:
                        if (!(getUpdateStatus(x, y))) {
                            OakSapling.tickObject(x, y);
                        }
                        break;
                }
            }
        }
        resetUpdateStatus();
    }
    public static int getLifeType(int x, int y) {
        //Returns an integer indicating the type of life at the given position
        return (life.get(x).get(y));
    }
    public static boolean getUpdateStatus(int x, int y) {
        //Returns a boolean indicating whether the given life object has already been updated
        return (lifeUpdateStatus.get(x).get(y));
    }
    public static boolean checkLifeExists(int x, int y) {
        return (!(x < 0) && !(x > Level.gridWidth - 1) && !(y < 0) && !(y > Level.gridHeight - 1));
    }
    public static void setLife(int x, int y, int lifeType) {
        life.get(x).set(y, lifeType);
        lifeUpdateStatus.get(x).set(y, true);
    }
    public static void resetUpdateStatus() {
        for (int i = 0; i < Level.gridWidth; i++) {
            for (int j = 0; j < Level.gridHeight; j++) {
                lifeUpdateStatus.get(i).set(j, false);
            }
        }
    }
}