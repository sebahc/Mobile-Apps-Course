package com.example.mywebview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView myWebView = (WebView) findViewById(R.id.webview);
		// habilito javascript
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
		
		
		myWebView.loadUrl("http://latamcode.com/webview/index.html");
		
		
	}

	public class WebAppInterface {
	    Context mContext;

	    /** Instantiate the interface and set the context */
	    WebAppInterface(Context c) {
	        mContext = c;
	    }

	    /** Show a toast from the web page */
	    @JavascriptInterface
	    public void showToast(String toast) {
	        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	    }
	}	
	
}



