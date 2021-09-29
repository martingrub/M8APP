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
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getSupportActionBar().hide();
            final Button button = findViewById(R.id.btnLogin);
            final EditText username = findViewById(R.id.TextName);
            final EditText password = findViewById(R.id.TextPassword);


            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String txtUsername = username.getText().toString();
                    String txtPassword = password.getText().toString();
                    if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                        //Login bien!
                        Log.i("Test", "Login correcte");

                    } else {
                        Log.i("Test", "Login mal");
                        //Login mala!!
                    }
                }


            });
        }

}
