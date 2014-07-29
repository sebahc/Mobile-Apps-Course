package com.example.clothingstore.model;

public class Clothing {

  private long ID = 0; // Default ID for all clothing
  private String description = "-description required-"; // default
  
  private double price = 0.0; // Default price for all clothing
  private int quantityInStock = 0; // Default quantity for all clothing
  
  // The color codes are R=Red, B=Blue, G=Green, U=Unset
  private char colorcode='U';
  
  public char getColorcode() {
	return colorcode;
}

public void setColorcode(char colorcode) {
	this.colorcode = colorcode;
}

   public long getID() {
    return ID;
  }
   
   public void setID(long ID) {
	    this.ID = ID;
	  }

  public void setDescription(String d) {
    description = d;
  }

  public String getDescription() {
    return description;
  }

  public void setPrice(double p) {
    price = p;
  }

  public double getPrice() {
    return price;
  }

  public void setQuantityInStock(int q) {
    quantityInStock = q;
  }

  public int getQuantityInStock() {
    return quantityInStock;
  }

} // end of class