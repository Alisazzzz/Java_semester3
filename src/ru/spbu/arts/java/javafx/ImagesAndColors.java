package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImagesAndColors extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent main = initInterface();

        stage.setScene(new Scene(main));
        stage.setTitle("Images");
        stage.show();

    }

    private Parent initInterface() {

        WritableImage picture1 = new WritableImage(100,100);
        PixelWriter pixelWriter1 = picture1.getPixelWriter();
        for (int x = 0; x < 100; x++)
            for (int y = 0; y < 100; y++)
                pixelWriter1.setColor(x, y, Color.hsb(246, 0.39, 0.96));
        ImageView view1 = new ImageView(picture1);
        Label first = new Label("Первая картинка");

        WritableImage picture2 = new WritableImage(256, 256);
        PixelWriter pixelWriter2 = picture2.getPixelWriter();
        for (int x = 0; x < 256; x++)
            for (int y = 0; y < 256; y++)
                pixelWriter2.setColor(x, y, Color.rgb(x, y, 123));
        ImageView view2 = new ImageView(picture2);
        Label second = new Label("Вторая картинка");

        WritableImage picture3 = new WritableImage(360, 100);
        PixelWriter pixelWriter3 = picture3.getPixelWriter();
        for (int x = 0; x < 360; x++)
            for (double y = 0; y < 100; y++)
                pixelWriter3.setColor(x, (int) y, Color.hsb(x, y/100, 0.8));
        ImageView view3 = new ImageView(picture3);
        Label third = new Label("Третья картинка");

        WritableImage picture4 = new WritableImage(100, 100);
        PixelWriter pixelWriter4 = picture4.getPixelWriter();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100;  y++) {
                if ((25 < x) && (x < 75) && (25 < y) && (y < 75))
                    pixelWriter4.setColor(x, y, Color.BLACK);
                else
                    pixelWriter4.setColor(x, y, Color.WHITE);
            }
        }
        ImageView view4 = new ImageView(picture4);
        Label fourth = new Label("Четвертая картинка");

        WritableImage picture5 = new WritableImage(100, 100);
        PixelWriter pixelWriter5 = picture5.getPixelWriter();
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                int r = (int) Math.sqrt(Math.pow((x - 50), 2) + Math.pow((y - 50), 2));
                if ( r < 50 )
                    pixelWriter5.setColor(x, y, Color.BLACK);
                else
                    pixelWriter5.setColor(x, y, Color.WHITE);
            }
        }
        ImageView view5 = new ImageView(picture5);
        Label fifth = new Label("Пятая картинка");

        WritableImage picture6 = new WritableImage(360, 100);
        PixelWriter pixelWriter6 = picture6.getPixelWriter();
        for (int x = 0; x < 360; x++)
            for (double y = 0; y < 100; y++)
                pixelWriter6.setColor(x, (int) y, LCH.colorFromLCH(y, 100, x));
        ImageView view6 = new ImageView(picture6);
        Label sixth = new Label("Шестая картинка");

        WritableImage picture7 = new WritableImage(371, 100);
        PixelWriter pixelWriter7 = picture7.getPixelWriter();
        for (int x = 380; x < 751; x++)
            for (int y = 0; y < 100; y++)
                pixelWriter7.setColor(x - 380, y, wavelengthToRGB( (float) x));
        ImageView view7 = new ImageView(picture7);
        Label seventh = new Label("Радуга");

        GridPane main = new GridPane();

        main.add(view1, 0, 0);
        main.add(first, 0, 1);

        main.add(view2, 1,0);
        main.add(second, 1, 1);

        main.add(view3, 0, 2);
        main.add(third, 0, 3);

        main.add(view4, 2, 0);
        main.add(fourth, 2, 1);

        main.add(view5, 3, 0);
        main.add(fifth, 3, 1);

        main.add(view6, 0, 4);
        main.add(sixth, 0, 5);

        main.add(view7, 0, 6);
        main.add(seventh, 0, 7);

        for (int i = 0; i < 14; i++)
            GridPane.setMargin(main.getChildren().get(i), new Insets(20));
        main.setStyle("-fx-background-color: #fdf3ea");
        return main;
    }

    private Color wavelengthToRGB(float  wavelength) {
        double gamma = 0.8;
        double R = 0;
        double G = 0;
        double B = 0;

        if (wavelength >= 380 & wavelength <= 440) {
            double attenuation = 0.3 + 0.7 * (wavelength - 380) / (440 - 380);
            R = Math.pow((-(wavelength - 440) / (440 - 380)) * attenuation, gamma);
            G = 0.0;
            B = Math.pow(attenuation, gamma);
        }
        if (wavelength >= 440 & wavelength <= 490) {
            R = 0.0;
            G = Math.pow((wavelength - 440) / (490 - 440), gamma);
            B = 1.0;
        }
        if (wavelength >= 490 & wavelength <= 510) {
            R = 0.0;
            G = 1.0;
            B = Math.pow(-(wavelength - 510) / (510 - 490), gamma);
        }
        if (wavelength >= 510 & wavelength <= 580) {
            R = Math.pow((wavelength - 510) / (580 - 510), gamma);
            G = 1.0;
            B = 0.0;
        }
        if (wavelength >= 580 & wavelength <= 645) {
            R = 1.0;
            G = Math.pow(-(wavelength - 645) / (645 - 580), gamma);
            B = 0.0;
        }
        if (wavelength >= 645 & wavelength <= 750) {
            double attenuation = 0.3 + 0.7 * (750 - wavelength) / (750 - 645);
            R = Math.pow(attenuation, gamma);
            G = 0.0;
            B = 0.0;
        }

        int intR = (int) (R * 255);
        int intG = (int) (G * 255);
        int intB = (int) (B * 255);

        return Color.rgb(intR, intG, intB);
    }
}
