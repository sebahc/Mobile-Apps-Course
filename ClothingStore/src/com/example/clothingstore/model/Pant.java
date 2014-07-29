package com.example.clothingstore.model;

public class Pant extends Clothing {

  private int size = 0; // default size for all pants

  // The gener can be M=Male or F=Femmale
  private char gender = 'U';

   
  // This method displays the values for an item
  public void displayPantInformation() {
  
    System.out.println("Pant ID: " + getID());
    System.out.println("Pant description:" + getDescription());
    System.out.println("Color Code: " + this.getColorcode());
    System.out.println("Pant price: " + getPrice());
    System.out.println("Quantity in stock: " + getQuantityInStock());

  } // end of display method

  public void setSize(int s) {
    size = s;
  }

 /* public String getSize() {
    if (gender == 'M') {
      convertGender
    }
    else {

    }
  }*/

} // end of class

