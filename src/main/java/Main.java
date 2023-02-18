import Level.Level;
import Level.UI.Ui;
import draw.Draw;

import static Level.Level.*;
import static Level.RegisterCells.registerCells;
import static Level.Terrain.generate;
import static com.raylib.Raylib.*;
import controls.HandleInputs;

public class Main {

    public static void main(String[] args) {
        InitWindow(windowWidth, windowHeight, "Game");
        SetTargetFPS(30);
        registerCells();
        generate(windowGridWidth, windowGridHeight, cellWidth, cellHeight);
        Ui.generateUi();

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