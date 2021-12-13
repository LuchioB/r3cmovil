package com.example.proycdraw;

import android.database.Cursor;

public class CasoUsoElementos {
    public static String cursorToString(Cursor cursor){
        if(cursor.getCount() == 0){
            return "No Hay Datos";
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                buffer.append("Codigo: "+cursor.getString(0)+"\n");
                buffer.append("Nombre: "+cursor.getString(1)+"\n");
                buffer.append("Descripcion: "+cursor.getString(2)+"\n");
                buffer.append("Precio: "+cursor.getString(3)+"\n\n");
            }
            return buffer.toString();
        }
    }


}
