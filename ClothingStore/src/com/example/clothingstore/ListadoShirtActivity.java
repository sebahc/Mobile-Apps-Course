package com.example.clothingstore;


import com.example.clothingstore.model.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListadoShirtActivity extends Activity {

	private ShirtDataSource datasource;
	private TableLayout tablaPrincipal;
	private Button btnNuevo;
	private long idShirt;
	private ScrollView scroll;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_shirt);
        
		datasource = new ShirtDataSource(this);
		datasource.open();
   	    
		scroll = (ScrollView) findViewById(R.id.myScroll);
    	tablaPrincipal = (TableLayout) findViewById(R.id.tblDatos);
    	   
    	
    	// Creo una instancia del Tipo TableRow, para agregar una fila
    	TableRow tr_cabecera = new TableRow(this);
    	
    	// a esta fila le agrego 2 text view
    	TextView cabecera_nombre = new TextView(this);
    	cabecera_nombre.setText("DESCRIPCION");
    	cabecera_nombre.setTextColor(Color.parseColor("#819FF7"));
    	// cada vez q inserto un view lo realizo con el metodo addview
    	tr_cabecera.addView(cabecera_nombre);
    	
    	TextView cabecera_precio = new TextView(this);
    	cabecera_precio.setText("PRECIO");
    	cabecera_precio.setTextColor(Color.parseColor("#819FF7"));
    	cabecera_precio.setPadding(5, 0, 5, 0);
    	tr_cabecera.addView(cabecera_precio);
    	
    	tablaPrincipal.addView(tr_cabecera);
    	   	    	
    	for(int i = 0; i < datasource.getAllShirt().size(); i++){
    		
    		TableRow tr1 = new TableRow(this);
    		TextView txtNombre = new TextView(this);
    		txtNombre.setText(String.valueOf(datasource.getAllShirt().get(i).getDescription()));
    		//txtNombre.setTextColor(Color.parseColor("#FFFFFF"));
    		tr1.addView(txtNombre);
    		
    		TextView txtPrecio = new TextView(this);
    		txtPrecio.setText(String.valueOf(datasource.getAllShirt().get(i).getPrice()));
    		//txtPrecio.setTextColor(Color.parseColor("#FFFFFF"));
    		txtPrecio.setPadding(5, 0, 5, 0);
    		tr1.addView(txtPrecio);
    		
    		Button btnEditar = new Button(this);
    		btnEditar.setText("Editar");
    		idShirt = (long) datasource.getAllShirt().get(i).getID();

    		btnEditar.setOnClickListener(new View.OnClickListener() {
        		long id = idShirt;
        	    public void onClick(View v) {
        	        //My action
        	    	formularioEditar(v, id);
        	    }
        	});
    		
        	tr1.addView(btnEditar);
        	
    		tablaPrincipal.addView(tr1);
    	}
    	
    	TableRow tr = new TableRow(this);
    	tr.setPadding(20, 20, 20, 20);
    	tr.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
    	
    	btnNuevo=new Button(this);
        btnNuevo.setText("Ingresar Nueva Camisa");
        tr.addView(btnNuevo);
        tablaPrincipal.addView(tr);

    	btnNuevo.setOnClickListener(new View.OnClickListener() {
    		
    	    public void onClick(View v) {
    	        //My action
    	    	formularioNuevo(v);
    	    }
    	});

    	setContentView(scroll);
    }
    
	public void formularioNuevo(View view){
    	
		Intent myIntent = new Intent(this, NuevaShirtActivity.class);
        startActivity(myIntent);
	}
	
	public void formularioEditar(View view, long id){
    	/*Intent myIntent = new Intent(this, EditarShirtActivity.class);
		myIntent.putExtra("idShirt", id);
        startActivity(myIntent);*/
	} 

	 public void onRestart(Bundle savedInstanceState) {
		 super.onRestart();
		 
	 }

}
