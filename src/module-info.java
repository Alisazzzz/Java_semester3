module ru.spbu.arts.java.javafx {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.swing;

    requires org.json;

    opens ru.spbu.arts.java.javafx;
    opens ru.spbu.arts.java.fractals;
    opens ru.spbu.arts.java.graphicApp;
    opens ru.spbu.arts.java.preparingToTest;
    opens ru.spbu.arts.java.test;
}