package ru.spbu.arts.java.test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class examTaskJavaFX extends Application {

    private final Button button = new Button("Выбрать каталог");
    private final Label dir = new Label();
    private final ListView<Path> allFiles = new ListView<>();

    private final DirectoryChooser dirChooser = new DirectoryChooser();

    public void start (Stage stage) {
        stage.setTitle("Просмотр файлов");
        VBox root = initInterface();
        stage.setScene(new Scene(root));
        initInteraction();
        stage.show();
    }

    private VBox initInterface() {
        return new VBox(button, dir, allFiles);
    }

    private void initInteraction() {
        button.addEventHandler(ActionEvent.ACTION, event -> {
            File dirToOpen= dirChooser.showDialog(null);
            if (dirToOpen != null) {
                Path path = dirToOpen.toPath();
                dir.setText(path.toString());
                FilesCollector fc = new FilesCollector();
                try {
                    Files.walkFileTree(path, fc);
                    List<Path> files = fc.getAllFiles();
                    ObservableList<Path> ff = FXCollections.observableArrayList();
                    ff.addAll(files);
                    allFiles.setItems(ff);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
