package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Negozi_tipici2Activity extends AppCompatActivity {
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.negozi_tipici2);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");


        setTitle(t);
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.negozi_tipici2,
                db.getNegoziById(myid),
                new String[]{"immagine","indirizzo","orari","giorno_chiusura","telefono","descrizione","sito_internet"},
                new int[]{R.id.sfondo,R.id.indirizzo,R.id.orari,R.id.giochius,R.id.tel,R.id.descr,R.id.sito},
                0
        );

        lv.setAdapter(adapter);
    }
}
