package com.mycompany.egovsystem;
public class tourism
{   
  String [][] places=
  { {"Tourist place","Location"},
    {"pyramids of giza","giza"},
    {"Egyptian Meuseum","cairo"},
    {"Great temple of Abu Simbel","aswan"}
  };
  public void displayTouristPlaces()
  {
      for (int i = 0; i < places.length; i++)
      {
          for (int j = 0; j < places[i].length; j++)
          {
              System.out.printf("%-50s", places[i][j]);
          }
          System.out.println();
      }
  }

}