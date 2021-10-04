package com.example.m8app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            //Lock so that the screen does not rotate
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Hide the action bar
            getSupportActionBar().hide();

            final EditText username = findViewById(R.id.TextName);
            final EditText password = findViewById(R.id.TextPassword);
            final Button button = findViewById(R.id.btnLogin);

            //listen to the click of the button and do the action that you indicate
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Get the data from the edit text and pass it to a string and then save it in a variable string
                    String txtUsername = username.getText().toString();
                    String txtPassword = password.getText().toString();
                    //If the user is admin and the password is admin, you will enter the if
                    if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                        //log check if the login is correct
                        Log.i("Test", "Login correcte");
                        //If the user is admin and the password is not admin, you will enter the on else
                    } else {
                        //log check if the login is bad
                        Log.i("Test", "Login mal");

                    }
                }


            });
        }

}
