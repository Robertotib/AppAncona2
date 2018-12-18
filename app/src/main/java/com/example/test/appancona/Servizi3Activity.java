package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Servizi3Activity extends AppCompatActivity {
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servizi3);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");


        setTitle(t);
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.servizi3,
                db.getServiziById(myid),
                new String[]{"immagine","descrizione","indirizzo","email","telefono","sito_internet"},
                new int[]{R.id.sfondo,R.id.descr,R.id.indirizzo,R.id.email,R.id.tel,R.id.sito},
                0
        );

        lv.setAdapter(adapter);
    }
}
