package com.example.test.appancona;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private void inizializza(SQLiteDatabase db)
    {
        String insert1="INSERT INTO biblio (titolo, autore, numero_pagine) " +
                "VALUES ('Promessi sposi','Alessandro Manzoni',500)";
        String insert2="INSERT INTO biblio (titolo, autore, numero_pagine) " +
                "VALUES ('Il deserto dei Tartari','Dino Buzzati', 270)";
        String insert3="INSERT INTO biblio (titolo, autore, numero_pagine) " +
                "VALUES ('Il Gattopardo','Giuseppe Tomasi di Lampedusa', 300)";

        db.execSQL(insert1);
        db.execSQL(insert2);
        db.execSQL(insert3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String comando="CREATE TABLE biblio (" +
                "    _id          INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "    titolo      TEXT," +
                "    autore TEXT," +
                "numero_pagine INTEGER)";

        db.execSQL(comando);

        inizializza(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

