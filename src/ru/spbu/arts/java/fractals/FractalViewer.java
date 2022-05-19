package ru.spbu.arts.java.fractals;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FractalViewer extends Application {

    public final int W = 600;
    public final int H = 400;

    @Override
    public void start (Stage primaryStage) throws Exception {

        primaryStage.setTitle("Просмотр фигур");

        VBox root = initInterface();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    private VBox initInterface() {

        WritableImage img = new WritableImage(W, H);
        Display display = new Display(-4, 3,8 / 600.0);
        Fractal f = new Mandelbrot();
        Palette p = new HSBPalette();
        display.paint(img, f, p);

        Button up = new Button("up");
        Button right = new Button("right");
        Button down = new Button ("down");
        Button left = new Button ("left");
        VBox upAndDown = new VBox(up, down);

        Button zoom = new Button("zoom");
        Button distance = new Button("dist");
        Button save = new Button("save position");
        Button load = new Button("load position");
        Button export = new Button("export");

        HBox mainPanel = new HBox(left, upAndDown, right,
                zoom, distance, save, load, export);

        ImageView imageView = new ImageView(img);
        return new VBox(imageView, mainPanel);
    }
}
