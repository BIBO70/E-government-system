package com.egs.egs;

import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter; 
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yoka2
 */
public class FileHandler {
    static String adminPath1 = "files/users/admin.txt";
    public static String citizenPath2 = "citizen.txt";
    static String electricityPath3 = "files/electricity.txt";
    static String financePath4 = "files/finance.txt";
    static String formPath5 = "form.txt";
    static String healthPath6 = "health.txt";
    static String eduPath7 = "files/pastPapers.txt";
    static String tourismPath8 = "tourism.txt";
    static String transportationPath9 = "files/transportation.txt";
    static String employeepath10 = "files/employee.txt";
    static String ministrypath11 = "files/ministry.txt";
    static String departmentpath12 = "department.txt";
    
    
    private static String getFilePath(int choice) {
        switch (choice) {
            case 1: return adminPath1;
            case 2: return citizenPath2;
            case 3: return electricityPath3;
            case 4: return financePath4;
            case 5: return formPath5;
            case 6: return healthPath6;
            case 7: return eduPath7;
            case 8: return tourismPath8;
            case 9: return transportationPath9;
            case 10: return employeepath10;
            case 11: return ministrypath11;
            case 12: return departmentpath12;
            default: return null;
        }
    }
    
    
     // Write content to a file
    public static void writeToFile(int choice, String content) {
        String path = getFilePath(choice);
        if (path == null) {
            System.out.println("Invalid file choice.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + path);
        }
    }
    
      public static List<String> readFromFile(int choice) {
        String path = getFilePath(choice);
        if (path == null) {
            System.out.println("Invalid file choice.");
            return Collections.emptyList();
        }

        List<String> fileContents = new ArrayList<>();
        try (Scanner myReader = new Scanner(new File(path))) {
            while (myReader.hasNextLine()) {
                fileContents.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + path);
        }

        return fileContents;
    }
}
    
