package com.example.myintents;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class OtraActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_otra);
		
		// Get the intent that started this activity
	    Intent intent = getIntent();
	    Uri data = intent.getData();
	    if (data!=null){
	    	showMap(data);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.otra, menu);
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
	
	public void showMap(Uri location){
		
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
	
}
