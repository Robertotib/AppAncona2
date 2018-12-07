package com.example.test.appancona;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    MyDBHelper helper=null;
    private final static String DATABASE="biblio";
    private final static int VERSIONE_DATABASE=1;

    DBManager(Context context)
    {

        helper=new MyDBHelper(context, DATABASE,
                null, VERSIONE_DATABASE);
    }

    public Cursor elencoLibri()
    {
        String query="SELECT * FROM biblio";

        SQLiteDatabase db= helper.getReadableDatabase();
        return db.rawQuery(query, null);
    }

}