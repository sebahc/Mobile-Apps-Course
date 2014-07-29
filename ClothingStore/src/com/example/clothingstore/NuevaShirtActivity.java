package com.example.clothingstore;

import com.example.clothingstore.model.Shirt;
import com.example.clothingstore.model.ShirtDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class NuevaShirtActivity extends Activity {
	private EditText descripcion;
	private EditText precio;
	private EditText stock;
	private RadioButton color;
	
	private char colorCode;
	private ShirtDataSource datasource;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // llamo el metodo original de la Clase Activity (Superclase)
			
		setContentView(R.layout.nueva_shirt);			
		
		
	}
	
	public void guardar_Action(View view) {
	    // Do something in response to button
						
		descripcion = (EditText) findViewById(R.id.txtDescripcion);
		precio = (EditText) findViewById(R.id.txtPrecio);
		stock = (EditText) findViewById(R.id.txtStock);
		// el colorCode lo se seteo con el otro metodo
		
		String descripcion2= descripcion.getText().toString();
		double price = Double.parseDouble(precio.getText().toString());
		int qtyStock = Integer.parseInt(stock.getText().toString());
		
		
		
		// Llamar a metodo del modelo para validar parametros
		// tal vez crear un clase Validar
		
		Shirt myShirt = new Shirt();
		myShirt.createItem(descripcion2, colorCode, price, qtyStock);	
		
		
		// creo una conex nueva con la BD y la abro
		datasource = new ShirtDataSource(this);
		datasource.open();
				
		// paso los datos de la camisa recien creada		
		datasource.createShirt(myShirt.getDescription(), myShirt.getPrice(), 
									myShirt.getQuantityInStock(),myShirt.getColorcode());
		
		datasource.close();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Nueva camisa guardada");
		builder.setCancelable(false);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                //hacer algo
		        	   descripcion.setText("");
		        	   precio.setText("");
		        	   stock.setText("");
		           }
		       });
	    builder.show();	
	}
	
	public void volver_Action(View view){
		
		Intent i = new Intent(this, ListadoShirtActivity.class);
        startActivity(i);
	}	
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
		color = (RadioButton) view;
	    boolean checked = color.isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radioUnset:
	            if (checked)
	                colorCode='U';
	            break;
	        case R.id.radioRed:
	            if (checked)
	            	 colorCode='R';
	            break;
	        case R.id.radioBlue:
	            if (checked)
	            	 colorCode='B';
	            break;
	        case R.id.radioGreen:
	            if (checked)
	            	 colorCode='G';
	            break;
	            
	    }
	}

}
