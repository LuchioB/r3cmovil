package com.example.proycdraw.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proycdraw.Activity_ListaElementos;
import com.example.proycdraw.R;


public class OnEmployesFragment extends Fragment {

public Button btnListaElementos;
private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnListaElementos =(Button) v.findViewById(R.id.btnListaElementos);
        btnListaElementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try {
                  Intent intent = new Intent(getActivity(), Activity_ListaElementos.class);
                  getActivity().startActivity(intent);
              }catch (Exception e){
                  Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
              }

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_on_employes, container, false);
    return v;
}
/*btnListaElementos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), Activity_ListaElementos.class);
            getActivity().startActivity(intent);
        }
    });*/

}