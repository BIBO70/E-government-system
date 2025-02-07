package com.mycompany.egovsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * FileHandler class manages file operations such as reading and writing data to files.
 *
 * @author yoka2
 */
public class FileHandler {
    static String adminPath1 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\users\\admin.txt";
    public static String citizenPath2 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\citizen.txt";
    static String electricityPath3 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\electricity.txt";
    static String financePath4 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\finance.txt";
    static String formPath5 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\form.txt";
    static String healthPath6 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\health.txt";
    static String eduPath7 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\pastPapers.txt";
    static String tourismPath8 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\tourism.txt";
    static String transportationPath9 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\transportation.txt";
    static String employeepath10 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\employee.txt";
    static String ministrypath11 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\ministry.txt";
    static String departmentpath12 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\department.txt";

    //= method to get the file path based on the user's choice
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


    public static void writeToFile(int choice, String content) {
        String path = getFilePath(choice);
        if (path == null) {
            System.out.println("Invalid file choice.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {  // 'false' to overwrite the file
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

        System.out.println("File Contents: " + fileContents);
        return fileContents;
    }





}