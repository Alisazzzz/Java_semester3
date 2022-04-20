package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EvilButton extends Application {

    String[] answers = new String[]{"Не нажимайте эту кнопку!",
            "Пожалуйста, не нажимайте больше эту кнопку",
            "Больше. Не. Нажимайте. Эту. Кнопку.",
            "Я же просила не нажимать кнопку!!!"};
    int count;

    Button button = new Button("");

    Image image = new Image("https://www.meme-arsenal.com/memes/23e6aed9931b053b2f86efc6e7edfe66.jpg");
    ImageView cat = new ImageView(image);

    @Override
    public void start(Stage stage) throws Exception {

        VBox root = initInterface();
        stage.setScene(new Scene(root));

        stage.setTitle("Осторожно, кнопка!");
        stage.show();

        button.addEventHandler(ActionEvent.ACTION, event -> {
            if (count < 3) {
                count += 1;
                button.setText(answers[count]);
            } else {
                cat.setVisible(true);
                button.setVisible(false);
            }
        });
    }

    private VBox initInterface() {
        count = 0;

        button.setText(answers[count]);

        cat.setFitHeight(500);
        cat.setFitWidth(500);
        cat.setVisible(false);

        VBox root = new VBox(button, cat);
        root.setAlignment(Pos.CENTER);

        return root;
    }
}
