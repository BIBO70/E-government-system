package com.egs.frame;

import java.util.Scanner;

public class Ministryofinterior extends Ministry {

    public Ministryofinterior(String ministry_name, String minister_name) {
        super(ministry_name, minister_name);
    }

    public static void renewcard() {
        Scanner input = new Scanner(System.in);
        boolean invalid;
        Long minDigits = 10000000000000000L; // Minimum 16 digits for the social security number
        do {
            invalid = false;
            System.out.println("Please enter your name:");
            String name = input.next();
            System.out.println("Please enter your social security number:");
            Long socialSecurityNum = input.nextLong();
            if (socialSecurityNum < minDigits) {
                System.out.println("Invalid social security number, please try again.");
                invalid = true;
            }
        } while (invalid);
        System.out.println("Your Social Security card has been successfully renewed.");
    }
}
