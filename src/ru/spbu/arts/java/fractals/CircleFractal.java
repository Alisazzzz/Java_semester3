package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class CircleFractal implements Fractal{

    @Override
    public double paint(double x, double y) {
        if (x * x + y * y <= 1)
            return 1.0;
        else
            return 0.0;
    }
}
