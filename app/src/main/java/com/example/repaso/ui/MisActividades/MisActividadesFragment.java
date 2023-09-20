package com.example.repaso.ui.MisActividades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.repaso.databinding.FragmentMisactividadesBinding;

import java.util.ArrayList;

public class MisActividadesFragment extends Fragment {
    private MisActividadesViewModel mv;
    private FragmentMisactividadesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

                 mv = new ViewModelProvider(this).get(MisActividadesViewModel.class);

        binding = FragmentMisactividadesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getLista().observe(getViewLifecycleOwner(), new Observer<ArrayList<Actividades>>() {
            @Override
            public void onChanged(ArrayList<Actividades> actividades) {
                RecyclerView rv = binding.Rvlista;

                GridLayoutManager grilla = new GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(grilla);

                ActividadesAdapter adapter = new ActividadesAdapter(requireContext(), actividades, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });


        mv.cargarLista();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}