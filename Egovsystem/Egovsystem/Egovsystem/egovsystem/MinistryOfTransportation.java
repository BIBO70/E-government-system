package com.mycompany.egovsystem;
public class MinistryOfTransportation
{      
    String[][] trainData = {
        {"Train ID", "from", "to", "leaving time","arriving time"},
        {"T100", "cairo", "giza", "10 am","11:30 am"},
        {"T200", "cairo", "alexandria", "10 am","12:30 pm"},
        {"T300", "giza", "aswan", "10 am","8:30 pm"}
    };
    public void displayTrainSchedule()
    {
        for (int i = 0; i < trainData.length; i++) 
        {
            for (int j = 0; j < trainData[i].length; j++) 
            {
                System.out.printf("%-20s", trainData[i][j]);
            }
            System.out.println();
        }
    }

}