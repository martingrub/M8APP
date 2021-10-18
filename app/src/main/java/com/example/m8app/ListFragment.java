package com.example.m8app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<String> array_dioses = new ArrayList<String>();
        View listdioses = inflater.inflate(R.layout.fragment_list,container,false);
        array_dioses.add("Luke Skywalker");
        array_dioses.add("Luke Skywalker");
        array_dioses.add("Luke Skywalker");
        array_dioses.add("Luke Skywalker");
        array_dioses.add("Luke Skywalker");
        array_dioses.add("Luke Skywalker");
        array_dioses.add("Luke Skywalker");
        RecyclerView recyclerView = listdioses.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_dioses);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(listdioses.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return listdioses;

    }
}