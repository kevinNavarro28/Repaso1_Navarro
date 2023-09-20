package com.example.repaso.ui.MisActividades;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Serializable;

public class ResultadoViewModel extends ViewModel {

    private MutableLiveData<Actividades> mResultado;

    public LiveData<Actividades> getMResultado(){
        if(mResultado==null){
            mResultado=new MutableLiveData<>();
        }
        return mResultado;

    }

    public void obtenerResultado(Bundle bundle){

        Actividades actividad = (Actividades)bundle.getSerializable("actividad");
        mResultado.setValue(actividad);
    }

}