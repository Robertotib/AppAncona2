package com.example.test.appancona;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class PernottamentoActivity extends AppCompatActivity {

    private ListView lv=null;
    private SimpleCursorAdapter adapter=null;
    private DBManager db=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pernottamento);
        lv=new ListView(this);
        setContentView(lv);

        db=new DBManager(this);
        adapter=new SimpleCursorAdapter(
                this,
                R.layout.row_pernottamento,
                db.elencoHotel(),
                new String[]{"immagine","nome","indirizzo"},
                new int[]{R.id.imagehotel,R.id.nome, R.id.indirizzo},
                0
        );

        lv.setAdapter(adapter);
    }
}
