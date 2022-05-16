package com.example.myxat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApp.class.getResource("AppClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("MyXat");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.fullScreenProperty();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

