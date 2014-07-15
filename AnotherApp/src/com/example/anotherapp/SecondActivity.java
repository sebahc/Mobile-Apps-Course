package com.example.anotherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//idem anterior 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		// oculta la ActionBar
		ActionBar ab = getSupportActionBar();
		ab.hide();
		
		//recupero el intent de la MainActivity
		Intent intent = getIntent();
		// recupero la cadena
		String mensaje = intent.getStringExtra(MainActivity.EXTRA);
		
		// Instancio una variable TextView y la asocio con txt_cadena del layout
		TextView tv = (TextView) findViewById(R.id.txt_cadena);
		//Cambio su tamaño
		tv.setTextSize(40);
		// le seteo el texto de la cadena q recibi x el intent
		tv.setText(mensaje);
		
		
		
	}

	
}
