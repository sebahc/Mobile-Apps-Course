package com.example.myvolley;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends ActionBarActivity {
	
	//final TextView mTextView = (TextView) findViewById(R.id.myTextView);
	public static final String TAG = "MyTag";
	RequestQueue mRequestQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 final TextView mTextView = (TextView) findViewById(R.id.myTextView);
		
		
		// Instantiate the RequestQueue.
		mRequestQueue = Volley.newRequestQueue(this);
		String url ="http://www.google.com";
		
		

		// Request a string response from the provided URL.
		@SuppressWarnings("unchecked")
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
		            new Response.Listener() {
		    @Override
		    public void onResponse(Object response) {
		    	String cadena= (String) response;
		        // Display the first 500 characters of the response string.
		        mTextView.setText("Response is: "+ cadena.substring(0,500));
		    }

			
		}, new Response.ErrorListener() {
		    @Override
		    public void onErrorResponse(VolleyError error) {
		        mTextView.setText("That didn't work!");
		    }
		});
		// add TAG to StringRequest
		
		stringRequest.setTag(TAG);
		
		// Add the request to the RequestQueue.
		mRequestQueue.add(stringRequest);
		
		
	}
	
	@Override
	protected void onStop () {
	    super.onStop();
	    if (mRequestQueue != null) {
	        mRequestQueue.cancelAll(TAG);
	    }
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
}
