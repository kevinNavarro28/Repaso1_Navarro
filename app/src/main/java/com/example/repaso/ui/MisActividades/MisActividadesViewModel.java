package com.example.repaso.ui.MisActividades;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MisActividadesViewModel extends AndroidViewModel {
    private ArrayList<Actividades> actividades ;
    private MutableLiveData<ArrayList<Actividades>> lista;

    public MisActividadesViewModel(@NonNull Application application) {
        super(application);



    }

    public LiveData<ArrayList<Actividades>> getLista() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public void cargarLista(){
        actividades = new ArrayList<>();
        actividades.add(new Actividades("Compras en el supermercado","comprar papas", LocalDate.of(2023,8,23), LocalTime.of(20,30,00),"San luis"));
        actividades.add(new Actividades("Pasear a Eva","Pasear Por el Parque", LocalDate.of(2023,9,23),LocalTime.of(20,30,00),"La Punta"));
        lista.setValue(actividades);
    }

    }






