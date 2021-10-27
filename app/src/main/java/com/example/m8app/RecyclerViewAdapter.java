package com.example.m8app;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.m8app.Model.Dioses;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Dioses> array_dioses;

    public RecyclerViewAdapter(ArrayList<Dioses> arrD){
        array_dioses = arrD;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Nom.setText(array_dioses.get(position).getNombre());
        holder.Pantheon.setText(array_dioses.get(position).getPanteon());
        holder.Rol.setText(array_dioses.get(position).getRol());
        holder.Rango.setText(array_dioses.get(position).getRango());
        holder.Daño.setText(array_dioses.get(position).getDaño());

    }

    @Override
    public int getItemCount() {
        return array_dioses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Nom, Pantheon, Rol, Rango, Daño;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nom = itemView.findViewById(R.id.TextNom);
            Pantheon = itemView.findViewById(R.id.textPantheon);
            Rol = itemView.findViewById(R.id.textRol);
            Rango = itemView.findViewById(R.id.textRango);
            Daño = itemView.findViewById(R.id.textDaño);
        }
    }
}
