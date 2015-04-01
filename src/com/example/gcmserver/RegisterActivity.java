package com.example.gcmserver;

import static com.example.gcmserver.CommonUtilities.SENDER_ID;
import static com.example.gcmserver.CommonUtilities.SERVER_URL;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 
public class RegisterActivity extends Activity {
    // alert dialog manager
    AlertDialogManager alert = new AlertDialogManager();
     
    // Internet detector
    ConnectionDetector cd;
     
    // UI elements
    EditText efname;
    EditText elname;
    EditText eadd;
    EditText ephone;
    EditText eemail;
     
    // Register button
    Button btnRegister;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         
        cd = new ConnectionDetector(getApplicationContext());
 
        // Check if Internet present
        if (!cd.isConnectingToInternet()) {
            // Internet Connection is not present
            alert.showAlertDialog(RegisterActivity.this,
                    "Internet Connection Error",
                    "Please connect to working Internet connection", false);
            // stop executing code by return
            return;
        }
 
        // Check if GCM configuration is set
        if (SERVER_URL == null || SENDER_ID == null || SERVER_URL.length() == 0
                || SENDER_ID.length() == 0) {
            // GCM sernder id / server url is missing
            alert.showAlertDialog(RegisterActivity.this, "Configuration Error!",
                    "Please set your Server URL and GCM Sender ID", false);
            // stop executing code by return
             return;
        }
         
        efname = (EditText) findViewById(R.id.fname);
        elname = (EditText) findViewById(R.id.lname);
        eemail = (EditText) findViewById(R.id.email);
        ephone = (EditText) findViewById(R.id.phone);
        btnRegister = (Button) findViewById(R.id.submit);
         
        /*
         * Click event on Register button
         * */
        btnRegister.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View arg0) {
                // Read EditText dat
                String fname = efname.getText().toString();
                String lname = elname.getText().toString();
                String phone = ephone.getText().toString();
                
                String email = eemail.getText().toString();
                 
                // Check if user filled the form
                if(fname.trim().length() > 0 && email.trim().length() > 0){
                    // Launch Main Activity
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                     
                    // Registering user on our server                  
                    // Sending registraiton details to MainActivity
                    i.putExtra("fname", fname);
                    i.putExtra("lname", lname);
                    i.putExtra("phone", phone);
                    i.putExtra("add", "IIITH");
                    i.putExtra("qrcode", "1 1");
                    i.putExtra("email", email);
                   
                    startActivity(i);
                    finish();
                }else{
                    // user doen't filled that data
                    // ask him to fill the form
                    alert.showAlertDialog(RegisterActivity.this, "Registration Error!", "Please enter your details", false);
                }
            }
        });
    }
 
}
