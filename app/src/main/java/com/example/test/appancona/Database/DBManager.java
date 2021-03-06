package com.example.test.appancona.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

public class DBManager {

    public MyDBHelper helper=null;
    
    public DBManager(Context context)
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
    public Boolean isTappaPuntInt(String id)
    {
        String query = "SELECT * from pun_int_tappa join tappe where tappe._cod_tappa = pun_int_tappa.cod_tappa and tappe._cod_tappa =" +id;
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor result = db.rawQuery(query, null);
        if(result.getCount() == 0)
            return false;
        else
            return true;
    }
    public Boolean isTappaRist(String id)
    {
        String query = "SELECT * from rist_tappa join tappe where tappe._cod_tappa = rist_tappa.cod_tappa and tappe._cod_tappa =" +id;
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor result = db.rawQuery(query, null);
        if(result.getCount() == 0)
            return false;
        else
            return true;
    }
    public Boolean isTappaNegozi(String id)
    {
        String query = "SELECT * from negoz_tappa join tappe where tappe._cod_tappa = negoz_tappa.cod_tappa and tappe._cod_tappa =" +id;
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor result = db.rawQuery(query, null);
        if(result.getCount() == 0)
            return false;
        else
            return true;
    }
    public Cursor getPuntIntByCodTappa(String id)
    {
        String query = "SELECT * from pun_int_tappa join tappe where tappe._cod_tappa = pun_int_tappa.cod_tappa and tappe._cod_tappa =" +id;
        SQLiteDatabase db= helper.getReadableDatabase();
       return  db.rawQuery(query, null);

    }
    public Cursor getRistByCodTappa(String id)
    {
        String query = "SELECT * from rist_tappa join tappe where tappe._cod_tappa = rist_tappa.cod_tappa and tappe._cod_tappa =" +id;
        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);

    }
    public Cursor getNegoziByCodTappa(String id)
    {
        String query = "SELECT * from negoz_tappa join tappe where tappe._cod_tappa = negoz_tappa.cod_tappa and tappe._cod_tappa =" +id;
        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);

    }
    public Cursor getPercorsoById(String id)
    {
        String query="SELECT * FROM percorsi WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }

    public Cursor getTappeByPercorso(String id){
        String query = "select * from tappe_percorsi join tappe  where tappe_percorsi.cod_percorso ="+id+"  and tappe._cod_tappa=tappe_percorsi.cod_tappa order by tappe_percorsi.posizione ASC";

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
    public Cursor getPuntiInteresse()
    {
        String query="SELECT * FROM punti_interesse";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getServizi()
    {
        String query="SELECT * FROM servizi";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getRistoranteById(String id)
    {
        String query="SELECT * FROM ristorazione WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getRistorantiByPrezzo(int prez)
    {
        String query="SELECT * FROM ristorazione WHERE prezzo_medio <="+prez;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getServiziById(String id)
    {
        String query="SELECT * FROM servizi WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }

    public Cursor getHotelById(String id)
    {
        String query="SELECT * FROM pernottamento WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getHotelByPrezzo(int prez)
    {
        String query="SELECT * FROM pernottamento WHERE prezzo_medio <="+prez;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }
    public Cursor getNegoziById(String id)
    {
        String query="SELECT * FROM negozi_tipici WHERE _id ="+id;

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query,null);
    }



}