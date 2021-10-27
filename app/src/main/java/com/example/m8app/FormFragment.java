package com.example.m8app;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.m8app.Model.Dioses;
import com.example.m8app.DB.DiosesDBHelper;


public class FormFragment extends Fragment {
    private DiosesDBHelper dbHelper;
    private SQLiteDatabase db;
    public FormFragment() {
        // Required empty public constructor
    }
    public FormFragment(DiosesDBHelper dbHelper,SQLiteDatabase db) {
        this.dbHelper=dbHelper;
        this.db=db;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View formdioses = inflater.inflate(R.layout.fragment_form,container,false);
        final Button buttonAñadir = formdioses.findViewById(R.id.btnAñadir);
        //

        Spinner spinnerPanteon = (Spinner) formdioses.findViewById(R.id.spinnerPanteon);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.SpinnerPantheon, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPanteon.setAdapter(adapter);
        //
        Spinner spinnerRol = (Spinner) formdioses.findViewById(R.id.spinnerRol);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.SpinnerRol, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(adapter1);
        //
        Spinner spinnerRango = (Spinner) formdioses.findViewById(R.id.spinnerRango);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.SpinnerRango, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRango.setAdapter(adapter2);
        //
        Spinner spinnerDaño = (Spinner) formdioses.findViewById(R.id.spinnerDaño);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(),
                R.array.SpinnerDaño, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDaño.setAdapter(adapter3);

        final EditText Nombre = formdioses.findViewById(R.id.NameDios);

        buttonAñadir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Dioses dios = new Dioses(Nombre.getText().toString(),
                                        spinnerPanteon.getSelectedItem().toString(),
                                        spinnerRol.getSelectedItem().toString(),
                                        spinnerDaño.getSelectedItem().toString(),
                                        spinnerRango.getSelectedItem().toString());
                dbHelper.insertDioses(db,dios);

            }
        });
        return formdioses;
    }


}