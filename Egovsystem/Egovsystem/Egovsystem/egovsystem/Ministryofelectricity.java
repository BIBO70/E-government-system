package com.mycompany.egovsystem;


import java.util.Random;
import java.util.Scanner;

public class Ministryofelectricity extends Ministry{
    private static float electricybill;
    private static String paymenttype;
    public Ministryofelectricity(String ministry_name,String minister_name){
        super(ministry_name, minister_name);
    }

    public static void getelectrictybill() {
        Random random = new Random();
        electricybill = random.nextInt(2000); // Generate a random bill amount
        char answer;
        long fawrycode;
        long creditcardnum;
        Scanner input = new Scanner(System.in);

        System.out.println("Your electricity bill is: " + electricybill);
        System.out.println("Do you wish to pay now? Y/N");
        answer = input.next().charAt(0);

        if (answer == 'N' || answer == 'n') {
            System.out.println("Farewell");
        } else if (answer == 'Y' || answer == 'y') {
            System.out.println("Please choose payment type:");
            System.out.println("- fawry");
            System.out.println("- credit card");
            input.nextLine();
            paymenttype = input.nextLine();

            if (paymenttype.equalsIgnoreCase("fawry")) {
                fawrycode = random.nextLong(100000000L, 10000000000L); //generates random 9 digits fawry code
                System.out.println("Here is your Fawry code: " + fawrycode);
            } else if (paymenttype.equalsIgnoreCase("credit card")) {
                do {
                    System.out.println("Please provide your credit card number:");
                    if (input.hasNextLong()) {
                        creditcardnum = input.nextLong();
                        if (creditcardnum < 10000000000000000L) {
                            System.out.println("Invalid credit card number.");
                            System.out.println("Do you wish to try again? Y/N");
                            input.nextLine(); // Clear the buffer
                            answer = input.next().charAt(0);
                        } else {
                            System.out.println("Payment is successful.");
                            answer = 'N';
                        }
                    } else {
                        System.out.println("Invalid input. Please enter numbers only.");
                        input.nextLine(); // Clear invalid input
                        System.out.println("Do you wish to try again? Y/N");
                        answer = input.next().charAt(0);
                    }
                } while (answer == 'Y' || answer == 'y');
                System.out.println("Farewell");
            } else {
                System.out.println("Invalid payment type.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}


  
