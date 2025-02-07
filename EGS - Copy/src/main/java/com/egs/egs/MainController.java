package com.egs.egs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import com.egs.frame.Ministry;
import com.egs.frame.Ministryofelectricity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ListView<String> optionList;

    @FXML
    private Button executeButton;

    @FXML
    private Label messageLabel;

    private final String[] options = {
            "1. Check last year's exams question papers",
            "2. Check today’s currency prices",
            "3. Check the trains schedule",
            "4. View list of tourist places and their location",
            "5. Check electricity bill",
            "6. Search for a specific type and quantity of blood bags",
            "7. Renew social security number card"
    };

    @FXML
    public void initialize() {
        // Populate the ListView with options
        optionList.getItems().addAll(options);
    }

    @FXML
    private void handleExecute() {
        String selectedOption = optionList.getSelectionModel().getSelectedItem();

        if (selectedOption == null) {
            messageLabel.setText("Please select an option.");
            messageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        switch (optionList.getSelectionModel().getSelectedIndex()) {
            case 0:
                displayPastPapers();
                break;
            case 1:
                displayCurrencyPrices();
                break;
            case 2:
                displayTrainSchedule();
                break;
            case 3:
                DisplayTouristLocations();
                break;
            case 4:
                checkElectricityBill();
                break;
            case 5:
                searchBloodBags();
                break;
            case 6:
                showRenewSocialSecurityWindow();
                break;
            default:
                messageLabel.setText("This option is not implemented yet.");
        }
    }
    private void searchBloodBags() {
        Stage searchStage = new Stage();
        searchStage.setTitle("Search Blood Bags");

        Label typeLabel = new Label("Blood Type:");
        TextField typeField = new TextField();
        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();
        Button searchButton = new Button("Search");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        searchButton.setOnAction(e -> {
            String bloodType = typeField.getText().toUpperCase();
            String quantityText = quantityField.getText();

            if (bloodType.isEmpty() || quantityText.isEmpty() || !quantityText.matches("\\d+")) {
                resultArea.setText("Invalid input. Please check your entries.");
            } else {
                int quantity = Integer.parseInt(quantityText);
                String filePath = "src/Files/health.txt";

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    StringBuilder result = new StringBuilder();
                    String line;
                    boolean found = false;

                    while ((line = reader.readLine()) != null) {
                        if (line.contains(bloodType) && line.contains("Quantity: " + quantity)) {
                            result.append(line).append("\n");
                            found = true;
                        }
                    }

                    if (found) {
                        resultArea.setText("Available Blood Bags:\n" + result);
                    } else {
                        resultArea.setText("No matching blood bags found.");
                    }

                } catch (IOException ex) {
                    resultArea.setText("Error: Could not read blood bags file.");
                    ex.printStackTrace();
                }
            }
        });

        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(typeLabel, typeField, quantityLabel, quantityField, searchButton, resultArea);

        typeLabel.setLayoutX(20);
        typeLabel.setLayoutY(20);
        typeField.setLayoutX(150);
        typeField.setLayoutY(20);

        quantityLabel.setLayoutX(20);
        quantityLabel.setLayoutY(60);
        quantityField.setLayoutX(150);
        quantityField.setLayoutY(60);

        searchButton.setLayoutX(20);
        searchButton.setLayoutY(100);

        resultArea.setLayoutX(20);
        resultArea.setLayoutY(140);
        resultArea.setPrefSize(360, 200);

        Scene searchScene = new Scene(pane, 400, 400);
        searchStage.setScene(searchScene);
        searchStage.show();
    }
    private void DisplayTouristLocations() {
        String filePath = "src/Files/tourism.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            Stage papersStage = new Stage();
            papersStage.setTitle("Tourism Destinations");
            TextArea papersTextArea = new TextArea(content.toString());
            papersTextArea.setEditable(false);

            Scene papersScene = new Scene(papersTextArea, 600, 400);
            papersStage.setScene(papersScene);
            papersStage.show();

        } catch (IOException e) {
            messageLabel.setText("Error: Could not read tourism file.");
            e.printStackTrace();
        }
    }
    private void displayPastPapers() {
        String filePath = "src/Files/pastPapers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            Stage papersStage = new Stage();
            papersStage.setTitle("Past Papers");
            TextArea papersTextArea = new TextArea(content.toString());
            papersTextArea.setEditable(false);

            Scene papersScene = new Scene(papersTextArea, 600, 400);
            papersStage.setScene(papersScene);
            papersStage.show();

        } catch (IOException e) {
            messageLabel.setText("Error: Could not read past papers file.");
            e.printStackTrace();
        }
    }

    private void displayCurrencyPrices() {
        String filePath = "src/Files/finance.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            Stage currencyStage = new Stage();
            currencyStage.setTitle("Currency Prices");
            TextArea currencyTextArea = new TextArea(content.toString());
            currencyTextArea.setEditable(false);

            Scene currencyScene = new Scene(currencyTextArea, 600, 400);
            currencyStage.setScene(currencyScene);
            currencyStage.show();

        } catch (IOException e) {
            messageLabel.setText("Error: Could not read currency prices file.");
            e.printStackTrace();
        }
    }

    private void displayTrainSchedule() {
        String filePath = "src/Files/trainSchedule.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder schedule = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                schedule.append(line).append("\n");
            }

            Stage scheduleStage = new Stage();
            scheduleStage.setTitle("Train Schedule");
            TextArea scheduleTextArea = new TextArea(schedule.toString());
            scheduleTextArea.setEditable(false);

            Scene scheduleScene = new Scene(scheduleTextArea, 600, 400);
            scheduleStage.setScene(scheduleScene);
            scheduleStage.show();

        } catch (IOException e) {
            messageLabel.setText("Error: Could not read train schedule.");
            e.printStackTrace();
        }
    }

    private void checkElectricityBill() {
        // Logic to handle electricity bill
        Ministry electricityMinistry = new Ministryofelectricity("Ministry of Electricity", "John Doe");
        Ministryofelectricity.getelectrictybill();
    }

    private void showRenewSocialSecurityWindow() {
        Stage renewStage = new Stage();
        renewStage.setTitle("Renew Social Security Card");

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label ssnLabel = new Label("Social Security Number:");
        TextField ssnField = new TextField();
        Button renewButton = new Button("Renew");
        Label resultLabel = new Label();

        renewButton.setOnAction(e -> {
            String name = nameField.getText();
            String ssn = ssnField.getText();

            if (name.isEmpty() || ssn.isEmpty() || ssn.length() < 16 || !ssn.matches("\\d+")) {
                resultLabel.setText("Invalid input. Please check your entries.");
                resultLabel.setStyle("-fx-text-fill: red;");
            } else {
                resultLabel.setText("Your Social Security card has been successfully renewed and will be shipped to your registered adress");
                resultLabel.setStyle("-fx-text-fill: green;");
            }
        });

        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(nameLabel, nameField, ssnLabel, ssnField, renewButton, resultLabel);

        nameLabel.setLayoutX(20);
        nameLabel.setLayoutY(20);
        nameField.setLayoutX(200);
        nameField.setLayoutY(20);

        ssnLabel.setLayoutX(20);
        ssnLabel.setLayoutY(60);
        ssnField.setLayoutX(200);
        ssnField.setLayoutY(60);

        renewButton.setLayoutX(20);
        renewButton.setLayoutY(100);

        resultLabel.setLayoutX(20);
        resultLabel.setLayoutY(140);

        Scene renewScene = new Scene(pane, 400, 200);
        renewStage.setScene(renewScene);
        renewStage.show();
    }

    @FXML
    private void logout() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage stage = (Stage) optionList.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error loading login page.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}

