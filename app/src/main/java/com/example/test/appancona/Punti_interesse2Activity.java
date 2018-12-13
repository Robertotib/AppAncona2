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
        setTitle(R.string.label_punti1);

        lv = new ListView(this);
        setContentView(lv);

        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_punti_interesse2,
                db.getPuntiinteresseByTipo("'Monumenti Storici'"),
                new String[]{"nome"},
                new int[]{R.id.nome},
                0
        );

        lv.setAdapter(adapter);
    }
}
