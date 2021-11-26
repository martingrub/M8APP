package com.example.m8app;

import android.content.Context;
import android.content.SharedPreferences;

public class spref_manager {
    Context context;

    public spref_manager(Context context) {
        this.context = context;
    }
    public String getSave(){
        SharedPreferences preferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return preferences.getString("Idioma","" );
    }

    public boolean noLang() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        boolean langnull = sharedPreferences.getString("Idioma", "").isEmpty();
        return langnull;
    }
}
