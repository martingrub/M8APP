package com.example.m8app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.m8app.DB.DiosesDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {
    private DiosesDBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Lock so that the screen does not rotate
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menu);
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        //Hide the action bar
        getSupportActionBar().hide();
        dbHelper = new DiosesDBHelper(this);
        db = dbHelper.getWritableDatabase();

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;

                case R.id.nav_list:
                    selectedFragment = new ListFragment(dbHelper,db);
                    break;

                case R.id.nav_add:
                    selectedFragment = new FormFragment(dbHelper,db);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });

    }
    @Override
    // Close the database when onDestroy
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}