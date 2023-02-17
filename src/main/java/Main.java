import Level.Level;
import draw.Draw;

import java.util.concurrent.ThreadLocalRandom;

import static Level.Level.*;
import static Level.Terrain.generate;
import static com.raylib.Raylib.*;
import controls.HandleInputs;

public class Main {

    public static void main(String args[]) {
        InitWindow(windowWidth, Level.windowHeight, "Game");
        SetTargetFPS(30);
        generate(windowWidth, windowHeight, cellWidth, cellHeight);

        while (!WindowShouldClose()) {
            BeginDrawing();
            Level.doMainTick();
            HandleInputs.mainInputCheck();
            Draw.drawTerrain();
            Draw.drawUi();
            EndDrawing();
        }
    }
}