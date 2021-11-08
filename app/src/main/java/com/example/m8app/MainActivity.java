package com.example.m8app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        int comprobante = 0;
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
            final CheckBox checkBox=findViewById(R.id.checkBox);
            SharedPreferences preferences = getSharedPreferences
                    ("credenciales", Context.MODE_PRIVATE);
            comprobante = (preferences.getInt("comprobante", 0));


            if (comprobante != 0) {
                username.setText(preferences.getString("Username",""));
                password.setText(preferences.getString("Password",""));
                String txtUsername = username.getText().toString();
                String txtPassword = password.getText().toString();


                if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                    goToMenu();
                }
            }
            //listen to the click of the button and do the action that you indicate
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Get the data from the edit text and pass it to a string and then save it in a variable string
                    String txtUsername = username.getText().toString();
                    String txtPassword = password.getText().toString();
                    //If the user is admin and the password is admin, you will enter the if
                    if (checkBox.isChecked()==true){
                        guardarPreferancias();
                    }
                    if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                        //log check if the login is correct
                        goToMenu();
                        Log.i("Test", "Login correcte");
                        //If the user is admin and the password is not admin, you will enter the on else
                    } else {
                        //log check if the login is bad
                        Log.i("Test", "Login mal");

                    }
                }


            });
        }
    public void goToMenu() {
        Intent intentmenu = new Intent(this,menu.class);
        startActivity(intentmenu);
    }
    private void guardarPreferancias() {
        SharedPreferences preferences = getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Username", ((EditText) findViewById(R.id.TextName)).getText().toString());
        editor.putString("Password", ((EditText) findViewById(R.id.TextPassword)).getText().toString());
        editor.putInt("comprobante", 1);
        editor.commit();
    }
    public void refresh(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
