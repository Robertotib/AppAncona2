package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Pernottamento2Activity extends AppCompatActivity {
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pernottamento2);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");


        setTitle(t);
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.pernottamento2,
                db.getHotelById(myid),
                new String[]{"immagine","descrizione","indirizzo","prezzo_medio","telefono","sito_internet","parcheggio"},
                new int[]{R.id.sfondo,R.id.descr,R.id.indirizzo,R.id.prezzo,R.id.tel,R.id.sito,R.id.parcheggio},
                0
        );

        lv.setAdapter(adapter);
    }
}
