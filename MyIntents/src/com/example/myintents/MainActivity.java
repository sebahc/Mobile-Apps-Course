package com.example.myintents;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Get the intent that started this activity
	    Intent intent = getIntent();
	    if (intent.getExtras()!=null){
	    	String message = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE);
	    	int hour=Integer.parseInt(intent.getStringExtra(AlarmClock.EXTRA_HOUR));
	    	int minutes=Integer.parseInt(intent.getStringExtra(AlarmClock.EXTRA_MINUTES));
	    	createAlarm(message, hour, minutes);
	    }
	    //createAlarm("hola", 9, 5);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Ejemplo pasando un nro telefonico para discar
	public void DiscarNumero(String telefono){
		
				//telefono Acipan 
				Uri numero = Uri.parse("tel:"+telefono);
				Intent llamarIntent = new Intent(Intent.ACTION_DIAL,numero);
				startActivity(llamarIntent);
	}
	
	// Ejemplo pasando una ubicacion en el mapa
	public void showMap(Uri location){
  	
		//Map point using Address
		//Bv.+9+de+Julio+67,+Neuquén,+Argentina
		//location = Uri.parse("geo:0,0?q="+direccion);
		
		// Otra opcion seria pasar como parametro la  latitud y longitud
		//Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param el el nivel de zoom
		
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
		
		// Si no esta instalada alguna App que abra un mapa, los dirigimos al PlayStore para instalar GoogleMaps
		if (mapIntent.resolveActivity(getPackageManager()) != null) {
			startActivity(mapIntent);
		} else{
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("market://details?id=com.google.android.apps.maps"));
			startActivity(intent);
		}
	}
	
	public void createAlarm(String message, int hour, int minutes) {
	    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
	            .putExtra(AlarmClock.EXTRA_MESSAGE, message)
	            .putExtra(AlarmClock.EXTRA_HOUR, hour)
	            .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
	    if (intent.resolveActivity(getPackageManager()) != null) {
	        startActivity(intent);
	    }
	}
	
}
