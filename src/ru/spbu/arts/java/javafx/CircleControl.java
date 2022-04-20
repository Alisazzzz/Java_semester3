package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleControl extends Application {

    Slider radius = new Slider();
    ColorPicker circleColor = new ColorPicker();
    ColorPicker fieldColor = new ColorPicker();

    Circle circle = new Circle(100);
    Pane rightPanel = new Pane();

    double width;
    double height;

    @Override
    public void start(Stage stage) throws Exception {

        Parent parent = initInterface();
        initInteraction();

        stage.setScene(new Scene(parent));

        stage.setTitle("Circle-circle!");
        stage.show();

    }

    private Parent initInterface() {
        GridPane allPanes = new GridPane();

        Label forRadius = new Label("Радиус круга");
        Label forCircleColor = new Label("Цвет круга");
        Label forFieldColor = new Label("Цвет поля");

        radius.setValue(50);
        fieldColor.setValue(Color.BLUE);
        rightPanel.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

        VBox leftPanel = new VBox(radius, forRadius,
                circleColor, forCircleColor,
                fieldColor, forFieldColor);
        leftPanel.setAlignment(Pos.TOP_CENTER);
        leftPanel.setSpacing(5);
        leftPanel.setPadding(new Insets(10));

        VBox.setMargin(radius, new Insets(10, 0, 0, 0));
        VBox.setMargin(forRadius, new Insets(0, 0, 15, 0));
        VBox.setMargin(forCircleColor, new Insets(0, 0, 15, 0));
        VBox.setMargin(forFieldColor, new Insets(0, 0, 15, 0));

        rightPanel.getChildren().add(circle);

        allPanes.add(leftPanel, 0, 0);
        allPanes.add(rightPanel, 1, 0);

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        c1.setPrefWidth(200);
        c2.setHgrow(Priority.ALWAYS);
        c2.setMinWidth(300);

        RowConstraints r1 = new RowConstraints();
        r1.setVgrow(Priority.ALWAYS);

        allPanes.getColumnConstraints().addAll(c1, c2);
        allPanes.getRowConstraints().add(r1);

        return allPanes;
    }

    private void initInteraction() {

        circle.radiusProperty().bind( radius.valueProperty() );

        rightPanel.widthProperty().addListener( (obs, oldWidth, newWidth) -> {
            circle.setCenterX((Double) newWidth / 2);
            width = (Double) newWidth / 2;
            radius.setMax(Math.min(width, height));
            });

        rightPanel.heightProperty().addListener( (obs, oldHeight, newHeight) -> {
            circle.setCenterY((Double) newHeight / 2);
            height = (Double) newHeight / 2;
            radius.setMax(Math.min(width, height));
        });

        circle.fillProperty().bind( circleColor.valueProperty() );

        fieldColor.valueProperty().addListener( (obs, oldColor, newColor) -> {
            rightPanel.setBackground(new Background(new BackgroundFill(newColor, null, null)));
        });


    }
}
