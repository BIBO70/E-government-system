package com.egs.egs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Register.fxml")));

            // Set up the stage
            primaryStage.setTitle("Login Page");
            primaryStage.setScene(new Scene(root)); // Set the scenewith the FXML
            primaryStage.show(); // Display the stage
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading Login Page.");
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
