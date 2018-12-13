package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Servizi2Activity extends AppCompatActivity {
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servizi2);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("tipo");

        setTitle(t);
        t=  "'" + t + "'";
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_servizi2,
                db.getServiziByTipo(t),
                new String[]{"immagine","nome","indirizzo"},
                new int[]{R.id.imageserv2,R.id.nome,R.id.indirizzo},
                0
        );

        lv.setAdapter(adapter);
    }
}
