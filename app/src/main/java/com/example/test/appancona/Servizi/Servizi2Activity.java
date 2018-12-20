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
                new String[]{"immagine","nome","indirizzo","_id"},
                new int[]{R.id.imageserv2,R.id.nome,R.id.indirizzo,R.id.id},
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


                i = new Intent(Servizi2Activity.this, Servizi3Activity.class);
                i.putExtra("nome", nome);
                i.putExtra("id", myid);
                startActivity(i);


            }
        });
    }
}
