package com.example.test.appancona.Servizi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.test.appancona.*;

import com.example.test.appancona.Database.DBManager;

public class ServiziActivity extends AppCompatActivity {

    private ListView lv=null;
    private SimpleCursorAdapter adapter=null;
    private DBManager db=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servizi);

        lv=new ListView(this);
        setContentView(lv);

        db=new DBManager(this);
        adapter=new SimpleCursorAdapter(
                this,
                R.layout.row_tipi_servizi,
                db.tipiServizi(),
                new String[]{"immagine","_id"},
                new int[]{R.id.imagetipiserv,R.id.nome},
                0
        );

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                TextView textView =  view.findViewById(R.id.nome);
                String tipo = textView.getText().toString();

                i = new Intent(ServiziActivity.this, Servizi2Activity.class);
                i.putExtra("tipo", tipo);
                startActivity(i);


            }
        });
    }
    }

