package com.example.test.appancona;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

public class DBManager {

    MyDBHelper helper=null;
    private final static String DATABASE="biblio";
    private final static int VERSIONE_DATABASE=1;

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

    public Cursor elencoLibri()
    {
        String query="SELECT * FROM biblio";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }

}