package com.example.proycdraw;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper{
    private static SQLiteDatabase sqLiteDatabase;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * @param context to use for locating paths to the the database
     * {@link #onUpgrade} will be used to upgrade the database; if the database is
     * newer, {@link #onDowngrade} will be used to downgrade the database
     */
       public DataBase(Context context) {
            super(context, "reto3.db", null, 1);
            sqLiteDatabase = this.getWritableDatabase();
        }
        /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param BaseData The database.
     */
    @Override
    public void onCreate(SQLiteDatabase BaseData) {
        BaseData.execSQL("CREATE TABLE articulos(codigo INTEGER primary key," +
                "Nombre  VARCHAR," +
                "Descripcion VARCHAR,"+
                "Precio INTEGER," +
                "Image BLOB)");


    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * @param BaseData        The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase BaseData, int oldVersion, int newVersion) {
        BaseData.execSQL("DROP TABLE IF EXISTS articulos");

    }

    //funciones personalizadas
public static void insertElementos(String codigo, String descripcion, String nombre, String precio, byte[] image){
        String sql="INSERT INTO articulos VALUES(?,?,?,?,?)";
    SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
    statement.clearBindings();
    statement.bindString(0,codigo);
    statement.bindString(1,nombre);
    statement.bindString(2,descripcion);
    statement.bindString(3,precio);
    statement.bindBlob(4,image);

    statement.executeInsert();

}
    public Cursor getElementos(){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM articulos", null);
        return cursor;
    }

    public Cursor getElementosById(String codigo){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM articulos WHERE codigo="+codigo, null);
        return cursor;
    }

    public void deleteElementos(String codigo){
        String[]args= new String[]{codigo};
                sqLiteDatabase.delete("articulos", "codigo=?", args);
        }

    public void updateElementos(String codigo, String nombre, String descripcion,String precio,byte[] image){
        String sql = "UPDATE PERSONAJES"+
                " SET Nombre=?,"+
                "Descripcion=?,"+
                "Price =?,"+
                "Image=? WHERE Codigo ="+codigo;

            SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
            statement.clearBindings();
            statement.bindString(1,nombre);
            statement.bindString(2,descripcion);
            statement.bindString(3,precio);
            statement.bindBlob(4,image);

            statement.executeUpdateDelete();
    }

}
