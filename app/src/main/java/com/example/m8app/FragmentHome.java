package com.example.m8app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        final Button button = view.findViewById(R.id.btnIngles);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BorrarCredenciles();
            }
        });
        return view;
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