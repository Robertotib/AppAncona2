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

import com.example.test.appancona.Città.Negozi_tipici2Activity;
import com.example.test.appancona.Database.DBManager;
import com.example.test.appancona.Pernottamento.Pernottamento2Activity;
import com.example.test.appancona.Punti_interesse.Punti_interesse3Activity;
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
        final DBManager db=new DBManager(this);
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

                if(db.isTappaPuntInt(myid))
                {
                    Cursor result = db.getPuntIntByCodTappa(myid);
                    result.moveToFirst();
                    String codice = result.getString(result.getColumnIndex("cod_pun_int"));
                    String nome = result.getString(result.getColumnIndex("nome_tappa"));
                    i = new Intent(Percorsi2Activity.this,Punti_interesse3Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("id", codice);
                    startActivity(i);
                }else if (db.isTappaRist(myid))
                {
                    Cursor result  = db.getRistByCodTappa(myid);
                    result.moveToFirst();
                    String codice = result.getString(result.getColumnIndex("cod_ristorazione"));
                    String nome = result.getString(result.getColumnIndex("nome_tappa"));
                    i = new Intent(Percorsi2Activity.this,Ristorazione2Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("id", codice);
                    startActivity(i);
                }else if (db.isTappaNegozi(myid))
                {
                    Cursor result = db.getNegoziByCodTappa(myid);
                    result.moveToFirst();
                    String codice = result.getString(result.getColumnIndex("cod_negoz"));
                    String nome = result.getString(result.getColumnIndex("nome_tappa"));
                    i = new Intent(Percorsi2Activity.this,Negozi_tipici2Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("id", codice);
                    startActivity(i);
                }else
                    Toast.makeText(Percorsi2Activity.this, "Scelta non valida", Toast.LENGTH_LONG).show();


            }
        });
    }
}
