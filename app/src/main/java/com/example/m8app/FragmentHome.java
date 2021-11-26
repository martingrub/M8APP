package com.example.m8app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Locale;


public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        final Button buttonBorrar = view.findViewById(R.id.buttonBorrar);
        final Button buttonIngles = view.findViewById(R.id.buttonIngles);
        final Button buttonEspañol = view.findViewById(R.id.buttonEspañol);
        final Button buttonCatala = view.findViewById(R.id.buttonCatala);
        buttonIngles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("En");
            }
        });
        buttonEspañol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("Es");
            }
        });
        buttonCatala.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Save("Ca");
            }
        });
        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BorrarCredenciles();
            }
        });
        return view;
    }
    public void Save(String localeCode){
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(new Locale(localeCode.toLowerCase()));
        resources.updateConfiguration(configuration, displayMetrics);
        configuration.locale = new Locale(localeCode.toLowerCase());
        resources.updateConfiguration(configuration, displayMetrics);
        SetSave(localeCode);
        refresh();
    }
    public void SetSave(String localeCode){
        SharedPreferences preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Idioma",localeCode );
        editor.commit();
    }

    public void BorrarCredenciles(){
        SharedPreferences preferences = getActivity().getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        refresh();
    }

    public void refresh(){
        Intent intent = new Intent(getContext(),MainActivity.class);
        startActivity(intent);
    }

}