package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Ristorazione2Activity extends AppCompatActivity {
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ristorazione2);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");
        System.out.println(myid);

        setTitle(t);
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_ristorazione2,
                db.getRistoranteById(myid),
                new String[]{"immagine","descrizione","indirizzo","orario_apertura","giorno_chiusura","numero_coperti","prezzo_medio","telefono","orario_chiusura","sito_internet","parcheggio"},
                new int[]{R.id.sfondo,R.id.descr,R.id.indirizzo,R.id.orari,R.id.giochius,R.id.coperti,R.id.prezzo,R.id.tel,R.id.orachiu,R.id.sito,R.id.parcheggio},
                0
        );

        lv.setAdapter(adapter);
    }
}
