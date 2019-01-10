package com.example.test.appancona.Percorsi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.appancona.*;

import com.example.test.appancona.Database.DBManager;
import com.example.test.appancona.Ristorazione.Ristorazione2Activity;
import com.example.test.appancona.Ristorazione.RistorazioneActivity;

import java.util.ArrayList;

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



        /*
        while (c.moveToNext()){

            String nome = (c.getPosition()+1)+")"+"\t"+c.getString(c.getColumnIndex("nome_tappa"));
            String idtappa = c.getString(c.getColumnIndex("_cod_tappa"));
            CustomObject a=new CustomObject(idtappa,nome);
        }
        */

        SimpleCursorAdapter adapter=new SimpleCursorAdapter(
                this,
                R.layout.tappa,
                c,
                new String[]{"_cod_tappa","nome_tappa","posizione"},
                new int[]{R.id.custom1,R.id.custom2,R.id.custom3},
                0
        );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                TextView textView2 =  view.findViewById(R.id.custom1 );
                String myid= textView2.getText().toString();


                Toast.makeText(Percorsi2Activity.this, myid, Toast.LENGTH_LONG).show();


            }
        });
    }
}
