package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Punti_interesse3Activity extends AppCompatActivity
{
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse3);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");

        setTitle(t);
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.punti_interesse3,
                db.getPuntoInteresseById(myid),
                new String[]{"immagine","descrizione","indirizzo"},
                new int[]{R.id.sfondo,R.id.descr,R.id.indirizzo},
                0
        );

        lv.setAdapter(adapter);
    }
}

