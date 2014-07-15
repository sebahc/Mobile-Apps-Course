package com.example.anotherapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity {
	// tag de prueba para ver en el logcat
	public static final String TAG="error";
	// cadena Extra para usar de Key para pasar el mensaje x el intent
	public static final String EXTRA="mensaje";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// llamo el onCreate de mi clase Padre
		super.onCreate(savedInstanceState);
		// enlazo el Layout con el Controlador
		setContentView(R.layout.activity_main);
		
		
	}

/**
 * Metodo q recibe el onclick del Layout 
 * @param view
 */
	public void enviar_action(View view){
		// imprimo en el log un mensage cuando ingreso a este metodo
		Log.e(TAG, "enviar datos");
		// para activar otra activity y pasarle datos uso el intent
		Intent intent = new Intent(this,SecondActivity.class);
		
		// uso una variable EditText q linkeo con edit_mensaje del layout
		EditText unMensaje = (EditText) findViewById(R.id.edit_mensaje);
		// recupero el texto del EditText
		String cadena = unMensaje.getText().toString();
		
		// pongo el texto q recupere en el intent
		intent.putExtra(EXTRA, cadena);
		// inicio la otra actividad
		startActivity(intent);
		
		
	}
	
}
