package com.mycompany.egovsystem;

import java.util.Scanner;

public class Ministryofinterior extends Ministry{

    public Ministryofinterior(String ministry_name,String minister_name){
        super(ministry_name, minister_name);
    }

 public static void renewcard(){
 Scanner input=new Scanner(System.in);
 boolean invalid;
 Long mindigits=10000000000000000L; //to make sure social security number is at least 16 digits
 do {
 invalid=false;
System.out.println("Please enter your name:");
String name=input.next();
System.out.println("Please enter your social security number:");
Long social_security_num=input.nextLong();
if (social_security_num<mindigits){
System.out.println("invalid social security number,please try again");
invalid=true;}
 }while(invalid);
 System.out.println("your Social security card has been successfully renewed");
}
}
