package com.mycompany.egovsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ministryofhealth extends Ministry{
    static HashMap<String, String> typeAndLocationOfBloodBags = new HashMap<>();
    public Ministryofhealth(String ministry_name,String minister_name){
        super(ministry_name, minister_name);
    }

    // Add entries to the HashMap=
   
public static void searchbloodbags(){
    typeAndLocationOfBloodBags.put("A+", "10 , Egyptian blood bank");
    typeAndLocationOfBloodBags.put("B-", "20 , Greek hospital blood bank");
    typeAndLocationOfBloodBags.put("O+", "5 , Egyptian red crescent");
    typeAndLocationOfBloodBags.put("B+", "10 , Egyptian blood bank");
    typeAndLocationOfBloodBags.put("A-", "10 , Egyptian blood bank");
    String bloodbag;
    Scanner input=new Scanner(System.in);
    System.out.println(" please enter the blood type you need:");
    bloodbag=input.next();
        boolean found = false;
        for (Map.Entry<String, String> entry : typeAndLocationOfBloodBags.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(bloodbag)) {
                System.out.println("Found " + bloodbag + ": " + entry.getValue());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(bloodbag + " not found.");
        }
    }

    @Override
    public void displayministryname() {
        System.out.println("Ministry of health");
    }
}


