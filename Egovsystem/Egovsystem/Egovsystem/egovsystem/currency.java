package com.mycompany.egovsystem;
import java.util.*;
public class currency 
{
    
   

    
     String currency;

    
    public static double getExchangeRate(String currency) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }

        switch (currency.toLowerCase()) {
            case "dollar":
                return 50.45;

            case "euro":
                return 53.12;

            case "riyal":
                return 13.42;

            default:
                throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }

                                                        
        
}


