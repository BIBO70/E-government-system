package com.mycompany.egovsystem;

import static com.mycompany.egovsystem.FileHandler.writeToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Owner extends User {
    public static String citizenPath2 = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\citizen.txt";
    private static ArrayList<Ministry> ministries = new ArrayList<>();
    private static ArrayList<String> departments = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public Owner(String userName, int password, int userId) {
        super(userName, password, userId);
    }

    public static void addMinistry() {

        List<String> ministries = FileHandler.readFromFile(11);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the new ministry:");
        String ministryName = scanner.nextLine();
        System.out.println("Please enter the name of the minister:");
        String ministerName = scanner.nextLine();


        String newMinistry = ministryName + "," + ministerName;


        ministries.add(newMinistry);


        String content = String.join("\n", ministries);
        FileHandler.writeToFile(11, content);

        System.out.println("New ministry added: " + newMinistry);
    }


    public static void editMinistry() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the ministry name to edit:");
        String ministryToEdit = scanner.nextLine();

        System.out.println("Please enter new ministry name:");
        String newMinistryName = scanner.nextLine();

        System.out.println("Please enter new minister name:");
        String newMinisterName = scanner.nextLine();

        for (Ministry ministry : ministries) {
            if (ministry.getMinistryName().equalsIgnoreCase(ministryToEdit)) {
                ministry.setMinistryName(newMinistryName);
                ministry.setMinisterName(newMinisterName);
                System.out.println("Ministry updated: " + newMinistryName);


                String content = "";
                for (Ministry m : ministries) {
                    content += m.getMinistryName() + "," + m.getMinisterName() + "\n";
                }
                writeToFile(11, content);
                return;
            }
        }
        System.out.println("Ministry not found: " + ministryToEdit);
    }


    public static void removeMinistry() {

        List<String> ministries = FileHandler.readFromFile(11);

        if (ministries.isEmpty()) {
            System.out.println("No ministries found to remove.");
            return;
        }


        System.out.println("List of Ministries:");
        for (int i = 0; i < ministries.size(); i++) {
            System.out.println((i + 1) + ". " + ministries.get(i).split(",")[0]);
        }


        System.out.println("Please enter the number corresponding to the ministry you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int ministryIndex = scanner.nextInt() - 1;


        if (ministryIndex >= 0 && ministryIndex < ministries.size()) {

            String ministryToRemove = ministries.get(ministryIndex);
            ministries.remove(ministryIndex);
            System.out.println("Ministry removed: " + ministryToRemove.split(",")[0]);



            FileHandler.writeToFile(11, String.join("\n", ministries));
        } else {
            System.out.println("Invalid ministry selection.");
        }
    }


    public static void addDepartment() {

        List<String> departments = FileHandler.readFromFile(12);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the new department:");
        String newDepartment = scanner.nextLine();


        departments.add(newDepartment);


        String content = String.join("\n", departments);
        FileHandler.writeToFile(12, content);

        System.out.println("New department added: " + newDepartment);
    }


    public static void removeDepartment() {

        List<String> departments = FileHandler.readFromFile(12); //


        if (departments.isEmpty()) {
            System.out.println("No departments available to remove.");
            return;
        }


        System.out.println("List of Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i));
        }


        System.out.println("Please enter the number corresponding to the department you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int departIndex = scanner.nextInt() - 1;


        if (departIndex >= 0 && departIndex < departments.size()) {
            String departToRemove = departments.get(departIndex);
            departments.remove(departIndex);
            System.out.println("Department removed: " + departToRemove);


            String content = String.join("\n", departments);
            FileHandler.writeToFile(12, content);
        } else {
            System.out.println("Invalid department selection.");
        }
    }


    public static void addEmployee() {

        List<String> employees = FileHandler.readFromFile(10);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the new employee:");
        String employeeName = scanner.nextLine();
        System.out.println("Please enter the ID of the new employee:");
        String employeeId = scanner.nextLine();
        System.out.println("Please enter the department of the new employee:");
        String employeeDepartment = scanner.nextLine();


        String newEmployee = employeeName + "," + employeeId + "," + employeeDepartment;


        employees.add(newEmployee);


        String content = String.join("\n", employees);
        FileHandler.writeToFile(10, content);

        System.out.println("New employee added: " + employeeName);
    }



    public static void removeEmployee() {

        List<String> employees = FileHandler.readFromFile(10);


        if (employees.isEmpty()) {
            System.out.println("No employees available to remove.");
            return;
        }


        System.out.println("List of Employees:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }


        System.out.println("Please enter the number corresponding to the employee you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int employeeIndex = scanner.nextInt() - 1;


        if (employeeIndex >= 0 && employeeIndex < employees.size()) {
            String employeeToRemove = employees.get(employeeIndex);
            employees.remove(employeeIndex);
            System.out.println("Employee removed: " + employeeToRemove);


            String content = String.join("\n", employees);
            FileHandler.writeToFile(10, content);
        } else {
            System.out.println("Invalid employee selection.");
        }
    }


//these classes are not implemented

    public static void displayMinistries() {
        System.out.println("List of Ministries:");
        for (Ministry ministry : ministries) {
            System.out.println("- " + ministry.getMinistryName() + " (Minister: " + ministry.getMinisterName() + ")");
        }
    }


    public static void displayDepartments() {
        System.out.println("List of Departments:");
        for (String department : departments) {
            System.out.println("- " + department);
        }
    }


    public static void displayEmployees() {
        System.out.println("List of Employees:");
        for (Employee employee : employees) {
            System.out.println("- " + employee.getEmployeeName() + " (ID: " + employee.getEmployeeId() + ")");
        }
    }


    public static void countUsers() {
        String fileName = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\citizen.txt";

        try {
            long userCount = Files.lines(Paths.get(fileName)).count();
            System.out.println("Total number of users: " + userCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }


    public static void countMinistries() {
        String fileName = "C:\\Egovsystem\\Egovsystem\\Egovsystem\\files\\ministry.txt";

        try {
            long ministriesCount = Files.lines(Paths.get(fileName)).count();
            System.out.println("Total number of ministries: " + ministriesCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}