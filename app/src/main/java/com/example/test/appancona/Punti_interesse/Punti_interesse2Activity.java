package com.example.test.appancona.Punti_interesse;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.test.appancona.*;

import com.example.test.appancona.Database.DBManager;

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
        db = new DBManager(this);
        String t=getIntent().getStringExtra("tipo");
        Cursor puntiInt;
        setTitle(t);
        if(!t.equals("Tutte")) {
            t=  "'" + t + "'";
            puntiInt = db.getPuntiinteresseByTipo(t);
        }else {
            puntiInt = db.getPuntiInteresse();
        }




        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_punti_interesse2,
                puntiInt,
                new String[]{"immagine","nome","indirizzo","_id"},
                new int[]{R.id.imagepi2,R.id.nome,R.id.indirizzo,R.id.id},
                0
        );

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                TextView textView =  view.findViewById(R.id.nome);
                String nome = textView.getText().toString();
                TextView textView2 =  view.findViewById(R.id.id);
                String myid= textView2.getText().toString();


                i = new Intent(Punti_interesse2Activity.this, Punti_interesse3Activity.class);
                i.putExtra("nome", nome);
                i.putExtra("id", myid);
                startActivity(i);


            }
        });
    }
}
