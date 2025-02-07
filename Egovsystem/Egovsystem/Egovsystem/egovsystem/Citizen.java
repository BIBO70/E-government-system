package com.mycompany.egovsystem;
import static com.mycompany.egovsystem.FileHandler.readFromFile;
import static com.mycompany.egovsystem.FileHandler.writeToFile;
import java.util.Scanner;

import java.util.List;

class   Citizen extends User {
    private int socialSecNumCard;

    public Citizen(String userName, int password, int userId, int socialSecNumCard) {
        super(userName, password, userId);
        setSocialSecNumCard(socialSecNumCard);
    }

    // Input validation for social security number
    public void setSocialSecNumCard(int socialSecNumCard) {
        if (socialSecNumCard > 0) {
            this.socialSecNumCard = socialSecNumCard;
        } else {
            throw new IllegalArgumentException("Social Security Number must be a positive integer.");
        }
    }
    public int getSocialSecNumCard() {
        return socialSecNumCard;
    }
    
   
  
   public static boolean signIn(int num) {
       
    // if 0 then it is admin , if 1 then it is citizen    
       
    System.out.println("Please enter your data:");

    Scanner myobj = new Scanner(System.in);

    System.out.println("Username:");
    String userName = myobj.nextLine();

    System.out.println("Password:");
    String password = myobj.nextLine(); // Password as a String for better handling.

    System.out.println("User ID:");
    int userId = myobj.nextInt();

    // Read all admin data
    List<String> adminData = readFromFile(num); // Assuming "admin" is the key for the admin file

     boolean isAuthenticated = false;

    for (String line : adminData) {
        // Split each line by comma
        String[] parts = line.split(",");
        if (parts.length == 3) {
            String storedName = parts[0];
            String storedPassword = parts[1];
            int storedId;

            try {
                storedId = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format in the admin file.");
                continue;
            }

            // Check if the credentials match
            if (storedName.equals(userName) && storedPassword.equals(password) && storedId == userId) {
                isAuthenticated = true;
                break;
            }
        } else {
            System.out.println("wrong data entry: " + line);
        }

    }

    if (isAuthenticated) {
        System.out.println("Sign in successful! Welcome, " + userName + "!");
    } else {
        System.out.println("Sign in failed. Please check your credentials and try again.");

    }
return isAuthenticated;
}


            public static void Register() {
                System.out.println("Please enter your data:");

                System.out.println("username:");

                Scanner myobj = new Scanner(System.in);
                String userName = myobj.nextLine();

                System.out.println("password:");

                Scanner myobj1 = new Scanner(System.in);
                int password = myobj.nextInt();

                System.out.println("user id:");

                Scanner myobj2 = new Scanner(System.in);
                int userId = myobj.nextInt();

                String content = userName;
                content = content.concat(",");

                content = content.concat(Integer.toString(password));
                content = content.concat(",");

                content = content.concat(Integer.toString(userId));

                writeToFile(2, content);
            }

   
    public void signOut() {
        System.out.println("Citizen signed out.");
    }
}
