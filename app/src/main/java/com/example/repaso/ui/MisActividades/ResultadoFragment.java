package com.example.repaso.ui.MisActividades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repaso.R;
import com.example.repaso.databinding.FragmentResultadoBinding;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ResultadoFragment extends Fragment {

    private ResultadoViewModel mViewModel;

    private FragmentResultadoBinding binding;

    public static ResultadoFragment newInstance() {
        return new ResultadoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(ResultadoViewModel.class);
        binding = FragmentResultadoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel.getMResultado().observe(getViewLifecycleOwner(), new Observer<Actividades>() {
            @Override
            public void onChanged(Actividades actividades) {
                binding.TvNombre.setText(actividades.getNombre());
                binding.TvDescripcion.setText(actividades.getDetalle());
                binding.TvFecha.setText(actividades.getFecha().format(DateTimeFormatter.ofPattern("YYYY/MM/DD")));
                Objects.requireNonNull(binding.TvHora).setText(actividades.getHora().format(DateTimeFormatter.ofPattern("HH:mm")));
                binding.TvLugar.setText(actividades.getLugar());
            }
        });
        mViewModel.obtenerResultado(getArguments());


        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ResultadoViewModel.class);
        // TODO: Use the ViewModel
    }

}