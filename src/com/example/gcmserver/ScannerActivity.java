package com.example.gcmserver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;

public class ScannerActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button b1 =(Button)findViewById(R.id.b1);
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.google.zxing.client.android.SCAN"); 
				intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE");
				
				
						startActivityForResult(intent, 0);
						
				
			//	IntentIntegrator integrator = new IntentIntegrator(getParent());
				//integrator.initiateScan();
			}
		});
	}

	
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	/*	if (requestCode == 0) {
		if (resultCode == 1) {
		// Handle successful scan
		String capturedQrValue = intent.getStringExtra("SCAN_RESULT");
		//String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
		Toast.makeText(getApplicationContext(),
		"Scan Result:" + capturedQrValue, Toast.LENGTH_SHORT).show();

		} else if (resultCode == RESULT_CANCELED) {
		// Handle cancel
		}
		} else {

		}
		}*/
		/* IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
	      if (scanResult != null) {
	        // handle scan result
	        /*  String s = "http://www.google.com/search?q=";
	            s += scanResult.getContents();

	            Intent myIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
	            startActivity(myIntent1);*/
	    	//  Toast.makeText(getApplicationContext(), scanResult.getContents(), Toast.LENGTH_LONG).show();
	     // }*/
	      
		super.onActivityResult(requestCode, resultCode, intent);
		   
        if (requestCode == 0) {
       if (resultCode == RESULT_OK) {
           String contents = intent.getStringExtra("SCAN_RESULT");
           String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

           Toast.makeText(getApplicationContext(), contents, Toast.LENGTH_LONG).show();
           // Handle successful scan
           
              //  String s = "http://www.google.com/search?q=";
              //  s += contents;
              //  Intent myIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
              //  startActivity(myIntent1);
           }
       else
                if (resultCode == RESULT_CANCELED) {
               // Handle cancel
               }
        }
	
}
}