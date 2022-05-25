package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class HSBNewPalette implements Palette{

    @Override
    public Color paintWithColor(double x) {
        return Color.hsb( x * 10 * 360.0 % 360, 1, 1);
    }
}
