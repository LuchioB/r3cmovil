package com.example.proycdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ElementosAdapter extends BaseAdapter {
    Context context;
    ArrayList<Elementos> listaElementos;


    LayoutInflater inflater;

    public ElementosAdapter(Context context, ArrayList<Elementos> listaElementos) {
        this.context = context;
        this.listaElementos = listaElementos;
    }

    @Override
    public int getCount() {
        return listaElementos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_name);
        TextView textView1 = convertView.findViewById(R.id.grid_descripcion);
        TextView textView2 = convertView.findViewById(R.id.grid_precio);

        Elementos elementos = listaElementos.get(position);
        byte[] image = elementos.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        imageView.setImageBitmap(bitmap);
        textView.setText(elementos.getNombre());
        textView1.setText(elementos.getDescripcion());
        textView2.setText(elementos.getPrecio());



        return convertView;
    }
}


