package com.example.m8app;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m8app.Model.Dioses;
import com.example.m8app.DB.DiosesDBHelper;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    private DiosesDBHelper dbHelper;
    private SQLiteDatabase db;
    public ListFragment() {
        // Required empty public constructor
    }
    public ListFragment(DiosesDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper=dbHelper;
        this.db=db;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View listdioses = inflater.inflate(R.layout.fragment_list,container,false);
        ArrayList<Dioses> array_dioses = dbHelper.getAllData(db);

        RecyclerView recyclerView = listdioses.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_dioses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(listdioses.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return listdioses;

    }
}