package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Punti_interesse2Activity extends AppCompatActivity {

    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse2);

        lv = new ListView(this);
        setContentView(lv);
        String t=getIntent().getStringExtra("tipo");

        setTitle(t);
       t=  "'" + t + "'";
        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_punti_interesse2,
                db.getPuntiinteresseByTipo(t),
                new String[]{"immagine","nome","indirizzo"},
                new int[]{R.id.imagepi2,R.id.nome,R.id.indirizzo},
                0
        );

        lv.setAdapter(adapter);
    }
}
