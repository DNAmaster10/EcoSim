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
        Camera2D camera = new Camera2D(0);
        Jaylib.Vector2 cameraTarget = new Jaylib.Vector2();
        cameraTarget.x(0.0f).y(0.0f);
        camera.target(cameraTarget);
        camera.offset().y(0.1f).x(0.1f);
        camera.zoom(1.0f);
        camera.rotation(0.0f);

        while (!WindowShouldClose()) {
            float playerZoom = Player.playerZoom;
            camera.zoom(playerZoom);
            cameraTarget.x(Player.playerX).y(Player.playerY);
            BeginDrawing();

            BeginMode2D(camera);
                Level.doMainTick();
                HandleInputs.mainInputCheck();
                Draw.drawTerrain();
                Draw.drawGridUi();
            EndMode2D();
            Draw.drawOverlayUi();
            EndDrawing();
        }
    }
}