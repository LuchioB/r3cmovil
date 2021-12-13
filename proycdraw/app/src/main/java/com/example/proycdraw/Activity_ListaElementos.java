package com.example.proycdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.proycdraw.ui.OnEmployesFragment;

import java.util.ArrayList;

public class Activity_ListaElementos extends AppCompatActivity {
    private DataBase dataBase;
    private ArrayList<Elementos> listaElementos;
    private GridView gridView;
    private Button btnListaElementos;


    public ArrayList<Elementos> llenarLista(Cursor cursor){
        ArrayList<Elementos> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                Elementos elementos = new Elementos(
                        cursor.getString(1),
                        cursor.getBlob(2)
                );
                list.add(elementos);
            }
            return list;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_elementos);

        dataBase = new DataBase(getApplicationContext());
        gridView = (GridView) findViewById(R.id.gridView);

        Cursor cursor = dataBase.getElementos();
        listaElementos = llenarLista(cursor);
        ElementosAdapter elementosAdapter = new ElementosAdapter(getApplicationContext(),listaElementos);
        gridView.setAdapter(elementosAdapter);


       /* btnListaElementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent intent = new Intent(Activity_ListaElementos.this.getBaseContext(),
                        OnEmployesFragment.class);
        startActivity(intent);
    }
});
        }
*/
    }
    }
