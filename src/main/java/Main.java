import Level.Level;
import Level.UI.Ui;
import com.raylib.Jaylib;
import draw.Draw;
import Level.Player;

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
        Textures.loadTextures();
        Jaylib.Vector2 cameraTarget = new Jaylib.Vector2();
        cameraTarget.x(0.0f).y(0.0f);
        Player.camera.target(cameraTarget);
        Player.camera.offset().y(0f).x(0f);
        Player.camera.zoom(1.0f);
        Player.camera.rotation(0.0f);

        while (!WindowShouldClose()) {
            Level.doMainTick();
            BeginDrawing();
            HandleInputs.mainInputCheck();
            BeginMode2D(Player.camera);
                Draw.drawTerrain();
                Draw.drawGridUi();
            EndMode2D();
            Draw.drawOverlayUi();
            EndDrawing();
        }
    }
}