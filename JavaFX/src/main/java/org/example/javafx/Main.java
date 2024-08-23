package org.example.javafx;

//put this in front of controller name: org.example.javafx.

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("webview.fxml"));
            Scene scene = new Scene(root); //the thing put on the stage, holds the root

            Image icon = new Image("nico.png"); //image must be placed in the resources folder
            stage.getIcons().add(icon);
            stage.setTitle("Le initial stage");

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                exit(stage);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're exiting the app");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Window closed");
            stage.close();
        }

    }
}