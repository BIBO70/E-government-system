package com.egs.egs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label messageLabel;

    // Method to handle login
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (validateLogin(username, password)) {
            messageLabel.setText("Login Successful!");
            messageLabel.setStyle("-fx-text-fill: green;");
            System.out.println("Login Success!");
            // Proceed to next page or functionality here
        } else {
            messageLabel.setText("Invalid username or password.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Method to validate login credentials by reading from a file
    private boolean validateLogin(String username, String password) {
        // File path to store login credentials
        String credentialsFile = "src/Files/users/LoginInfo.txt";
        File file = new File(credentialsFile);

        if (!file.exists()) {
            messageLabel.setText("Credentials file not found!");
            messageLabel.setStyle("-fx-text-fill: red;");
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2) {
                    String storedUsername = credentials[0].trim();
                    String storedPassword = credentials[1].trim();

                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        switchToMainPage();
                        return true; // Credentials matched
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error reading credentials file.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
        return false;
    }
    @FXML
    private void switchToMainPage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Main Menu");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Main Page.");
        }
    }
}
