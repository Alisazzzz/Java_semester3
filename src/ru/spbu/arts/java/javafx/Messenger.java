package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Messenger extends Application {

    ObservableList<String> surnamesInContacts = FXCollections.observableArrayList();
    TextArea messages = new TextArea();
    TextField newMessage = new TextField();
    Button send = new Button("Отправить");

    @Override
    public void start(Stage stage) {

        stage.setTitle("Messenger");

        HBox interFace = initInterface();
        stage.setScene(new Scene(interFace));
        stage.show();

        addContacts();

        send.addEventHandler(ActionEvent.ACTION, event -> {
            messages.appendText(newMessage.getText());
            if (newMessage.getText() != "")
                messages.appendText("\n");
            newMessage.clear();
        });
    }

    private HBox initInterface() {
        Label name = new Label("Контакты");
        ListView<String> contacts = new ListView<>(surnamesInContacts);

        messages.setEditable(false);
        send.setPrefWidth(100);
        send.setPrefHeight(Double.POSITIVE_INFINITY);
        newMessage.setPrefHeight(Double.POSITIVE_INFINITY);
        name.setPrefHeight(30);
        name.setMinHeight(30);

        HBox lowerPanel = new HBox(newMessage, send);
        lowerPanel.setPrefHeight(50);
        lowerPanel.setMinHeight(50);
        HBox.setHgrow(newMessage, Priority.ALWAYS);

        VBox leftPanel = new VBox(messages, lowerPanel);
        HBox.setHgrow(leftPanel, Priority.ALWAYS);
        VBox.setVgrow(messages, Priority.ALWAYS);

        VBox rightPanel = new VBox(name, contacts);
        rightPanel.setPrefWidth(200);
        rightPanel.setMinWidth(200);
        VBox.setVgrow(contacts, Priority.ALWAYS);

        return new HBox(leftPanel, rightPanel);
    }

    private void addContacts() {
        surnamesInContacts.add("Репка");
        surnamesInContacts.add("Дед");
        surnamesInContacts.add("Внучка");
        surnamesInContacts.add("Жучка");
        surnamesInContacts.add("Кошка");
        surnamesInContacts.add("Мышка");
    }


}
