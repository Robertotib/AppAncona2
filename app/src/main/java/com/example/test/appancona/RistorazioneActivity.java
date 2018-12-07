package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class RistorazioneActivity extends AppCompatActivity {


    private ListView lv=null;
    private SimpleCursorAdapter adapter=null;
    private DBManager db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ristorazione);

        lv=new ListView(this);
        setContentView(lv);

        db=new DBManager(this);

        adapter=new SimpleCursorAdapter(
                this,
                R.layout.row_layout,
                db.elencoLibri(),
                new String[]{"titolo","autore","numero_pagine"},
                new int[]{R.id.titolo, R.id.autore, R.id.nrpagine},
                0
        );

        lv.setAdapter(adapter);
    }
}