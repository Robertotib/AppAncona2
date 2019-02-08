package com.example.test.appancona.Percorsi;

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

public class PercorsiActivity extends AppCompatActivity {

    private ListView lv=null;
    private SimpleCursorAdapter adapter=null;
    private DBManager db=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percorsi);

        lv=new ListView(this);
        setContentView(lv);

        db=new DBManager(this);
        adapter=new SimpleCursorAdapter(
                this,
                R.layout.row_percorsi,
                db.Percorsi(),
                new String[]{"immagine","tipo_percorso","_id"},
                new int[]{R.id.imagepercorsi,R.id.nome,R.id.id},
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


                i = new Intent(PercorsiActivity.this, Percorsi2Activity.class);
                i.putExtra("nome", nome);
                i.putExtra("id", myid);
                startActivity(i);


            }
        });


    }


}
