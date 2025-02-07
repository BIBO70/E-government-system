/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.egovsystem;

import static com.mycompany.egovsystem.Citizen.*;
import static com.mycompany.egovsystem.FileHandler.readFromFile;
import static com.mycompany.egovsystem.Menu.UserTypeSelector.selectUserType;
import static com.mycompany.egovsystem.Ministryofelectricity.getelectrictybill;
import static com.mycompany.egovsystem.Ministryofhealth.searchbloodbags;
import static com.mycompany.egovsystem.Ministryofinterior.renewcard;
import static com.mycompany.egovsystem.Owner.addMinistry;
import static com.mycompany.egovsystem.Owner.removeMinistry;
import static com.mycompany.egovsystem.Owner.editMinistry;
import static com.mycompany.egovsystem.Owner.addDepartment;
import static com.mycompany.egovsystem.Owner.removeDepartment;
import static com.mycompany.egovsystem.Owner.addEmployee;
import static com.mycompany.egovsystem.Owner.countMinistries;
import static com.mycompany.egovsystem.Owner.countUsers;
import static com.mycompany.egovsystem.Owner.removeEmployee;
import static java.lang.System.exit;

import java.io.IOException;


import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yoka2
 */

public class Menu {



    public void viewAdminOption() {
        char countinue;
         Scanner input=new Scanner(System.in);
do {
    System.out.println("please choose your option:");
    Scanner myobj2 = new Scanner(System.in);
    System.out.println("1- add a ministry");
    System.out.println("2- remove a ministry");
    System.out.println("3- edit a ministry");
    System.out.println("4- add a department");
    System.out.println("5- remove a department");
    System.out.println("6- add an employee");
    System.out.println("7- remove an employee");
    System.out.println("8- get count of citizen registered");
    System.out.println("9- get count of ministries");
    System.out.println("0- exit");

    int option = myobj2.nextInt();

    switch (option) {

        case 1:
            // add ministery function is wrong
            addMinistry();
            break;
        case 2:
            System.out.println("Please enter the ministry name to remove");
            new Scanner(System.in);
            String ministryToRemove = myobj2.nextLine();
            removeMinistry();
            break;
        case 3:
            editMinistry();
            break;
        case 4:
            addDepartment();
            break;
        case 5:
            removeDepartment();
            break;
        case 6:
            addEmployee();
            break;
        case 7:
            removeEmployee();
            break;
        case 8:
            countUsers();
            break;
        case 9:
            countMinistries();
            break;
        default:
            viewAdminOption();
    }
    System.out.println("do you want to continue? y/n");
    countinue=input.next().charAt(0);

}while(countinue=='y'||countinue=='Y');


    }


   public void selectService(){

       char countinue;
       Scanner input=new Scanner(System.in);
       do {
           System.out.println("please choose your service:");
           Scanner myobj2 = new Scanner(System.in);
           System.out.println("1- check last year/’s exams question papers");
           System.out.println("2- check today’s currency prices");
           System.out.println("3- check the trains schedule");
           System.out.println("4- view list of the Tourist places and their location");
           System.out.println("5- check electricity bill");
           System.out.println("6- search for a specific type and quantity of blood bags");
           System.out.println("7- renew social security number card");

           int service = myobj2.nextInt();

           switch (service) {

               case 1:
                   readFromFile(7);
                   break;
               case 2:
                   readFromFile(4);
                   break;
               case 3:
                   readFromFile(9);
                   break;
               case 4:
                   readFromFile(8);
                   break;
               case 5:
                   electrictybill();
                   break;
               case 6:
                   searchblood();
                   break;
               case 7:
                   renewcard();
                   break;
           }
           System.out.println("do you want to continue? y/n");
           countinue=input.next().charAt(0);
       }while(countinue=='y'||countinue=='Y');

}

    public class UserTypeSelector {

        public static int selectUserType() {
            Scanner myobj1 = new Scanner(System.in);
            int userType = 0;

            // Loop until a valid input (1 or 2) is entered
            while (true) {
                System.out.println("Please select user type from the options:");
                System.out.println("1 - for Admin");
                System.out.println("2 - for Citizen");

                if (myobj1.hasNextInt()) { // Check if input is an integer
                    userType = myobj1.nextInt();

                    if (userType == 1 || userType == 2) { // Valid input
                        break;
                    } else {
                        System.out.println("Invalid choice! Please enter 1 for Admin or 2 for Citizen.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number (1 or 2).");
                    myobj1.next(); // Consume invalid input
                }
            }

            return userType;
        }

        public static void main(String[] args) {
            int selectedUserType = selectUserType();
            System.out.println("You selected: " + (selectedUserType == 1 ? "Admin" : "Citizen"));
        }
    }
    public void searchblood()
    { Ministry healthministry = new Ministryofhealth("Ministry of HEALTH", " AHMED RAGI");
        Ministryofhealth.searchbloodbags();
        healthministry.displayministryname();
    }
    public void electrictybill(){
        Ministry electricityMinistry = new Ministryofelectricity("Ministry of Electricity", "John Doe");
        Ministryofelectricity.getelectrictybill();
    }
    public void startMenu() throws IOException{


        System.out.println("Hello, this is the E government system, choose one option from the following:");
       // int var to determine if it is admin or citizen
        int type = selectUserType();
        System.out.println("1. register(can only register as citizen)");
        System.out.println("2. Sign in");
        System.out.println("3. close");

        Scanner myobj = new Scanner(System.in);

        int choice = myobj.nextInt();

        switch(choice){
            case 1:
                Register();
                //can only register new citizen
             choice=2;
            case 2:
                // if type is citizen -- > 2 --> then we will call select services function \
                // if type is admin --> 1 --> then we will call admin option function



                if (type == 1) {
                    if(signIn(1)){
    viewAdminOption();
}
                }
                else if (type == 2)  {
                    if(signIn(2)){
                        selectService();}
                     }
                break;
            case 3:
                break;
            default:
                System.out.println("Please Pick one of the options");
                startMenu();
        }
        }
    }













