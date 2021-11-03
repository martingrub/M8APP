package com.example.m8app.DB;
import static com.example.m8app.DB.DiosesContract.DiosesEntry.ID;
import static com.example.m8app.DB.DiosesContract.DiosesEntry.TABLE_NAME;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.m8app.DB.DiosesContract.*;
import com.example.m8app.Model.Dioses;
import java.util.ArrayList;

public class DiosesDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dioses.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DiosesEntry.COLUMN_NAME_TITLE + " TEXT, "
            + DiosesEntry.COLUMN_PANTHEON_TITLE + " TEXT, "
            + DiosesEntry.COLUMN_ROL_TITLE + " TEXT, "
            + DiosesEntry.COLUMN_RANGO_TITLE + " TEXT,"
            + DiosesEntry.COLUMN_DAÑO_TITLE + " TEXT)";

    public DiosesDBHelper (Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void delete() {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertDioses(SQLiteDatabase db, Dioses c){
        //Check the bd is open
        if (db.isOpen()){
            // Create object to insert values with content
            ContentValues values = new ContentValues();

            //Insert the gods getting all values
            values.put(DiosesEntry.COLUMN_NAME_TITLE, c.getNombre());
            db.insert(TABLE_NAME, null, values);

            values.put(DiosesEntry.COLUMN_PANTHEON_TITLE, c.getPanteon());
            db.insert(TABLE_NAME, null, values);

            values.put(DiosesEntry.COLUMN_ROL_TITLE, c.getRol());
            db.insert(TABLE_NAME, null, values);

            values.put(DiosesEntry.COLUMN_RANGO_TITLE, c.getRango());
            db.insert(TABLE_NAME, null, values);

            values.put(DiosesEntry.COLUMN_DAÑO_TITLE, c.getDaño());
            db.insert(TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public ArrayList<Dioses> getAllData(SQLiteDatabase db){
        ArrayList<Dioses> array_dioses = new ArrayList<>();
        String GET_ALL_DIOSES = "SELECT * FROM " + TABLE_NAME;
        db = getReadableDatabase();
        if(db!=null)
        {
            Cursor cursor = db.rawQuery(GET_ALL_DIOSES, null);
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(DiosesEntry.COLUMN_NAME_TITLE));
                @SuppressLint("Range") String pantheon = cursor.getString(cursor.getColumnIndex(DiosesEntry.COLUMN_PANTHEON_TITLE));
                @SuppressLint("Range") String rol = cursor.getString(cursor.getColumnIndex(DiosesEntry.COLUMN_ROL_TITLE));
                @SuppressLint("Range") String rango = cursor.getString(cursor.getColumnIndex(DiosesEntry.COLUMN_RANGO_TITLE));
                @SuppressLint("Range") String daño = cursor.getString(cursor.getColumnIndex(DiosesEntry.COLUMN_DAÑO_TITLE));

                array_dioses.add(new Dioses(nombre, pantheon, rol, rango, daño));
                cursor.moveToNext();
            }
            cursor.close();
        }

        return array_dioses;
    }

}