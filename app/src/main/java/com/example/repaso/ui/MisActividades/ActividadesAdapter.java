package com.example.repaso.ui.MisActividades;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repaso.R;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.ViewHolder> {
    private NavController navController;
    private Context contexto;
    private List<Actividades> actividades;
    private LayoutInflater inflater;

    public ActividadesAdapter(Context contexto, List<Actividades> actividades, LayoutInflater inflater) {
        this.contexto = contexto;
        this.actividades = actividades;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_viewa, parent, false);
        return new ViewHolder(root);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Tvnombre.setText(actividades.get(position).getNombre());

        LocalDate fecha = actividades.get(position).getFecha();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.getDefault());
        String fechaFormateada = fecha.format(dateFormat);
        holder.Tvfecha.setText(fechaFormateada);


        LocalTime hora = actividades.get(position).getHora();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault());
        String horaFormateada = hora.format(timeFormat);
        holder.Tvhora.setText(horaFormateada);


        holder.btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("actividad", actividades.get(position));
                Navigation.findNavController(v).navigate(R.id.action_nav_misactividades_to_resultadoFragment,bundle);

            }
        });

    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Tvnombre;
        TextView Tvfecha;
        TextView Tvhora;
        Button btnDetalle;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        Tvnombre = itemView.findViewById(R.id.Tvnombre);
        Tvfecha = itemView.findViewById(R.id.Tvfecha);
        Tvhora=itemView.findViewById(R.id.Tvhora);
        btnDetalle=itemView.findViewById(R.id.Btdetalle);


        }
    }
}