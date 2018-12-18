package com.example.test.appancona;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

public class DBManager {

    MyDBHelper helper=null;
    
    DBManager(Context context)
    {
        this.helper =new MyDBHelper(context);

        try {

            helper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            helper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }

    }

    public Cursor elencoRistoranti()
    {
        String query="SELECT * FROM ristorazione";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor elencoHotel()
    {
        String query="SELECT * FROM pernottamento";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor tipiServizi()
    {
        String query="SELECT * FROM tipi_servizi";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor tipiPuntiinteresse()
    {
        String query="SELECT * FROM tipi_punti_interesse";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor Percorsi()
    {
        String query="SELECT * FROM percorsi";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor getPuntiinteresseByTipo(String tipo)
    {
        String query="SELECT * FROM punti_interesse WHERE cod_tipo ="+tipo;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor getServiziByTipo(String tipo)
    {
        String query="SELECT * FROM servizi WHERE cod_tipo_servizi ="+tipo;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor NegoziTipici()
    {
        String query="SELECT * FROM negozi_tipici";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }
    public Cursor getPuntoInteresseById(String id)
    {
        String query="SELECT * FROM punti_interesse WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getRistoranteById(String id)
    {
        String query="SELECT * FROM ristorazione WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }

    public Cursor getHotelById(String id)
    {
        String query="SELECT * FROM pernottamento WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }



}