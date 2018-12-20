package com.example.test.appancona;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Servizi3Activity extends AppCompatActivity {

    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servizi3);


        final String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");


        setTitle(t);
        db = new DBManager(this);
        Cursor punto = db.getServiziById(myid);
        if (punto.moveToFirst()) {
            String ind = punto.getString(punto.getColumnIndex("indirizzo"));
            String descr = punto.getString(punto.getColumnIndex("descrizione"));
            String imm = punto.getString(punto.getColumnIndex("immagine"));
            String ema = punto.getString(punto.getColumnIndex("email"));
            String tel = punto.getString(punto.getColumnIndex("telefono"));
            String si = punto.getString(punto.getColumnIndex("sito_internet"));

            TextView indir = findViewById(R.id.indirizzo);
            indir.setText(ind);
            TextView de = findViewById(R.id.descr);
            de.setText(descr);
            Uri myuri = Uri.parse(imm);
            ImageView image = findViewById(R.id.sfondo);
            image.setImageURI(myuri);
            TextView email = findViewById(R.id.email);
            email.setText(ema);
            TextView telefono = findViewById(R.id.tel);
            telefono.setText(tel);
            TextView sito = findViewById(R.id.sito);
            sito.setText(si);
        }

        Button a = findViewById(R.id.mappa);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Servizi3Activity.this,Servizi4Activity.class);
                i.putExtra("nome",t);
                startActivity(i);

            }
        });

    }
}
