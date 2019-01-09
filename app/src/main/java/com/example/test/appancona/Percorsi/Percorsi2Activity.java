package com.example.test.appancona.Percorsi;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.test.appancona.*;

import com.example.test.appancona.Database.DBManager;

public class Percorsi2Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percorsi2);
        DBManager db=new DBManager(this);
        String t = getIntent().getStringExtra("nome");
        setTitle(t);
        String id = getIntent().getStringExtra("id");
        inizializzaTappe(db.getTappeByPercorso(id));
        TextView desc = findViewById(R.id.descrizione);
        Cursor percorso = db.getPercorsoById(id);
        percorso.moveToFirst();
        String descr = percorso.getString(percorso.getColumnIndex("descrizione"));
        desc.setText(descr);
        desc.setMovementMethod(new ScrollingMovementMethod());



    }
    public void inizializzaTappe(Cursor c){
        ListView lv = findViewById(R.id.tappe);

        String tappe[] =  new String[c.getCount()];
        while (c.moveToNext()){
            String nome = (c.getPosition()+1)+")"+"\t"+c.getString(c.getColumnIndex("nome_tappa"));
            tappe[c.getPosition()]=nome;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.tappa,R.id.tappa,tappe);
        lv.setAdapter(arrayAdapter);
    }
}
