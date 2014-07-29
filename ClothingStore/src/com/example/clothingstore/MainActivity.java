package com.example.clothingstore;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // llamo el metodo original de la Clase Activity (Superclase)

		setContentView(R.layout.activity_main);			
	}
	
	public void verShirt_action(View view) {
		Intent myIntent = new Intent(this, ListadoShirtActivity.class );
		//Intent myIntent = new Intent(this, NuevoHatActivity.class );
        startActivity(myIntent);
	}
	
}
