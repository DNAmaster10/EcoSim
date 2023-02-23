package Level;

import Level.Life.*;

import java.util.ArrayList;
import java.util.List;

public class LifeLayer {
    //0 is no life
    //1 is OakSapling

    public static List<List<Integer>> life = new ArrayList<>();
    public static List<List<Boolean>> lifeUpdateStatus = new ArrayList<>();

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
    public static boolean checkLife(int x, int y) {
        //Returns true if life is present
        return (life.get(x).get(y) != 0);
    }

    public static void doLifeTick() {
        for (int x = 0; x < Level.gridWidth; x++) {
            for (int y = 0; y < Level.gridHeight; y++) {
                switch (getLifeType(x, y)) {
                    case 1:
                        if (!(getUpdateStatus(x, y))) {
                            OakSapling.tickObject(x, y);
                        }
                        break;
                    case 2:
                        if (!(getUpdateStatus(x, y))) {
                            YoungOakTree.tickObject(x, y);
                        }
                        break;
                    case 3:
                        if (!(getUpdateStatus(x, y))) {
                            OakTree.tickObject(x, y);
                        }
                        break;
                    case 4:
                        if (!(getUpdateStatus(x, y))) {
                            OakSaplingFire.tickObject(x, y);
                        }
                        break;
                    case 5:
                        if (!(getUpdateStatus(x, y))) {
                            BurntOakSapling.tickObject(x, y);
                        }
                        break;
                    case 6:
                        if (!(getUpdateStatus(x, y))) {
                            YoungOakTreeFire.tickObject(x, y);
                        }
                        break;
                    case 7:
                        if (!(getUpdateStatus(x, y))) {
                            BurntYoungOakTree.tickObject(x, y);
                        }
                        break;
                    case 8:
                        if (!(getUpdateStatus(x, y))) {
                            OakTreeFire.tickObject(x, y);
                        }
                        break;
                    case 9:
                        if (!(getUpdateStatus(x, y))) {
                            BurntOakTree.tickObject(x, y);
                        }
                        break;
                }
            }
        }
        resetUpdateStatus();
    }
}