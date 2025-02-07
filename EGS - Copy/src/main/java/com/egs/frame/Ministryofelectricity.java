package com.egs.frame;

import com.egs.frame.Ministry;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.Random;

public class Ministryofelectricity extends Ministry {

    private static float electricybill;
    private static String paymenttype;

    public Ministryofelectricity(String ministry_name, String minister_name) {
        super(ministry_name, minister_name);
    }

    public static void getelectrictybill() {
        Random random = new Random();
        electricybill = random.nextInt(2000); // Generate a random bill amount

        // Show bill amount in an alert dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Electricity Bill");
        alert.setHeaderText("Your Electricity Bill");
        alert.setContentText("Your electricity bill is: " + electricybill + "\nDo you want to pay now?");
        Optional<String> result = showPaymentTypeDialog();

        if (result.isPresent()) {
            paymenttype = result.get();
            if (paymenttype.equalsIgnoreCase("fawry")) {
                long fawrycode = random.nextLong(100000000L, 10000000000L); // Generate 9-digit Fawry code
                showAlert("Fawry Code", "Here is your Fawry code: " + fawrycode);
            } else if (paymenttype.equalsIgnoreCase("credit card")) {
                showAlert("Payment Successful", "Your payment was successful using Credit Card.");
            } else {
                showAlert("Invalid Payment Type", "You selected an invalid payment type.");
            }
        } else {
            showAlert("Payment Cancelled", "You chose not to pay at this time.");
        }
    }

    private static Optional<String> showPaymentTypeDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Payment Type");
        dialog.setHeaderText("Choose Payment Type");
        dialog.setContentText("Enter 'fawry' or 'credit card':");
        return dialog.showAndWait();
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
