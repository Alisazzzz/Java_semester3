package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class GrayscalePalette implements Palette{

    @Override
    public Color paintWithColor(double x) {
        return Color.gray(x);
    }
}
