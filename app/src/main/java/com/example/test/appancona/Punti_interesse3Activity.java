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

public class Punti_interesse3Activity extends AppCompatActivity
{

    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse3);




        final String  t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");

        setTitle(t);
        db = new DBManager(this);
        Cursor punto = db.getPuntoInteresseById(myid);
        if (punto.moveToFirst()) {
            String ind = punto.getString(punto.getColumnIndex("indirizzo"));
            String descr = punto.getString(punto.getColumnIndex("descrizione"));
            String imm = punto.getString(punto.getColumnIndex("immagine"));
            TextView indir = findViewById(R.id.indirizzo);
            indir.setText(ind);
            TextView de = findViewById(R.id.descr);
            de.setText(descr);
            Uri myuri = Uri.parse(imm);
            ImageView image = findViewById(R.id.sfondo);
            image.setImageURI(myuri);
        }

       Button a = findViewById(R.id.mappa_punti_interesse);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Punti_interesse3Activity.this,Punti_interesse4Activity.class);
                i.putExtra("nome",t);
                startActivity(i);

            }
        });
    }

}

