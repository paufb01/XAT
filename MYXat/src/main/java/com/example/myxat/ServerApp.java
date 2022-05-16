package com.example.myxat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServerApp.class.getResource("AppServer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("MyXat");
        stage.setScene(scene);
        stage.setWidth(900);
        stage.setHeight(900);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
