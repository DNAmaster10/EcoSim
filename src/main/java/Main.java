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
import Level.LifeLayer;

import java.util.Random;

public class Main {
    //An integer indicating the amount of frames passed in this cycle.
    //Resets to 0 when it reaches the frame rate.
    public static int frames = 0;

    public static void main(String[] args) {
        InitWindow(windowWidth, windowHeight, "Game");
        SetTargetFPS(60);
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
            if (frames > simulationSpeed) {
                Level.doMainTick();
                frames = 0;
            }
            LifeLayer.doLifeTick();
            Textures.doTextureTick();
            BeginDrawing();
            HandleInputs.mainInputCheck();
            BeginMode2D(Player.camera);
                Draw.drawTerrain();
                Draw.drawGridUi();
            EndMode2D();
            Draw.drawOverlayUi();
            EndDrawing();
            frames++;
        }
    }
}