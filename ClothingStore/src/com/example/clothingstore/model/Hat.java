package com.example.clothingstore.model;
public class Hat extends Clothing {

    
  // This method displays the values for an item
 /* public void displayItemInformation() {
  
    System.out.println("Hat ID: " + getID());
    System.out.println("Hat description:" + getDescription());
    System.out.println("Color Code: " + this.getColorcode());
    System.out.println("Hat price: " + getPrice());
    System.out.println("Quantity in stock: " + getQuantityInStock());

  } */ 
	// end of display method
  
  public void createItem(String descripcion, char colorCode, double price,
			int qtyStock) {
		this.setDescription(descripcion);
		this.setColorcode(colorCode);
		this.setPrice(price);
		this.setQuantityInStock(qtyStock);
		
	} 

} // end of class
