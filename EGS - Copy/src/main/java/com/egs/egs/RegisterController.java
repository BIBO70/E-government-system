package com.egs.egs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button goToLoginButton;

    @FXML
    private Label messageLabel;

    private final String credentialsFile = "src/Files/users/LoginInfo.txt"; // File for credentials storage

    // Register the user and write to file
    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Username or Password cannot be empty.");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Append credentials to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(credentialsFile, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            messageLabel.setText("Registration Successful! Redirecting to login...");
            messageLabel.setStyle("-fx-text-fill: green;");
            System.out.println("User registered: " + username);

            // Delay and switch to Login Page
            Thread.sleep(1000); // Optional delay
            switchToLogin();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            messageLabel.setText("Error writing to file.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Switch to the Login Page
    @FXML
    private void switchToLogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage) goToLoginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error loading login page.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
