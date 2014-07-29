package com.example.clothingstore.model;

public class Shirt extends Clothing {

 
	
  // This method displays the values for an item
  public void displayItemInformation() {
  
    System.out.println("Shirt ID: " + getID());
    System.out.println("Shirt description:" + getDescription());
    System.out.println("Color Code: " + this.getColorcode());
    System.out.println("Shirt price: " + getPrice());
    System.out.println("Quantity in stock: " + getQuantityInStock());

  }


public void createItem(String descripcion, char colorCode, double price,
		int qtyStock) {
	setDescription(descripcion);
	setColorcode(colorCode);
	setPrice(price);
	setQuantityInStock(qtyStock);
	
} // end of display method
} // end of class
