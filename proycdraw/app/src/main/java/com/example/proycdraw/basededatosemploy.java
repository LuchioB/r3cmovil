package com.example.proycdraw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;

public class basededatosemploy extends AppCompatActivity {
    private EditText txtpriceP,txtdescriptionP, txtnombreP,txtcodigoP;
    private ImageView bdimag;
    private Button btnselec, btnregistro,btnactualizar,btnbuscar,btneliminar;
    private DataBase database;


    private byte[] imageviewToByte(ImageView image){
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray =stream.toByteArray();
        return byteArray;

    }
    public void limpiarCampos(){
        txtcodigoP.setText("");
        txtnombreP.setText("");
        txtdescriptionP.setText("");
        txtpriceP.setText("");
        bdimag.setImageResource(R.mipmap.ic_launcher);
    }
    public void showById(Cursor cursor){
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"Producto no encontrado",Toast.LENGTH_SHORT).show();
        }else{
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                txtcodigoP.setText(cursor.getString(0));
                txtnombreP.setText(cursor.getString(1));
                txtdescriptionP.setText(cursor.getString(2));
                txtpriceP.setText(cursor.getString(3));
                byte[] image = cursor.getBlob(4);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);
                bdimag.setImageBitmap(bitmap);
            }
        }
    }

    private final static int REQUEST_CODE_GALLERY = 999;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basededatosemploy);

        txtcodigoP=(EditText) findViewById(R.id.txtcodigoP);
        txtnombreP=(EditText) findViewById(R.id.txtnombreP);
        txtdescriptionP=(EditText) findViewById(R.id.txtdescriptionP);
        txtpriceP=(EditText) findViewById(R.id.txtpriceP);
        btnselec=(Button)findViewById(R.id.btnselec);
        btnregistro=(Button)findViewById(R.id.btnregistro);
        btnactualizar=(Button)findViewById(R.id.btnactualizar);
        btneliminar=(Button)findViewById(R.id.btneliminar);
        btnbuscar=(Button)findViewById(R.id.btnbuscar);
        bdimag=(ImageView) findViewById(R.id.bdimag);

        database= new DataBase(getApplicationContext());



        btnselec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        basededatosemploy.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Toast.makeText(getApplicationContext(), txtnombreP.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    DataBase.insertElementos(
                            txtcodigoP.getText().toString().trim(),
                            txtnombreP.getText().toString().trim(),
                            txtdescriptionP.getText().toString().trim(),
                            txtpriceP.getText().toString().trim(),
                            imageviewToByte(bdimag)
                    );
                    limpiarCampos();
                    Toast.makeText(getApplicationContext(), "Producto Creado", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtcodigoP.getText().toString().trim();
                if(id.equals("")){
                    Cursor cursor = database.getElementos();
                    String result = CasoUsoElementos.cursorToString(cursor);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }else{
                    Cursor cursor = database.getElementosById(id);
                    showById(cursor);
                }

            }
        });
        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtcodigoP.getText().toString().trim();
                if(id.equals("")){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }else{
                    database.deleteElementos(id);
                    limpiarCampos();
                }
            }
        });




    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }else{
                Toast.makeText(getApplicationContext(), "Sin Permisos", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                bdimag.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}

