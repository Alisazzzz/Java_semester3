package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class Mandelbrot implements Fractal{

    @Override
    public double paint(double x, double y) {

        double zx = 0;
        double zy = 0;

        for (int step = 1; step < 100; step++) {
            zx = zx * zx - zy * zy + x;
            zy = 2 * zx * zy + y;
            if ( Math.sqrt(zx * zx + zy * zy) > 1000000000)
                return ( 1.0 -  step / 100.0 );
        }
        return 0.0;
    }
}
