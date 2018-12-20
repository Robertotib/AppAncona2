package com.example.test.appancona;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Pernottamento2Activity extends AppCompatActivity {

    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pernottamento2);


        final String t=getIntent().getStringExtra("nome");
        String myid=getIntent().getStringExtra("id");


        setTitle(t);
        db = new DBManager(this);
        Cursor punto = db.getHotelById(myid);
        if (punto.moveToFirst()) {
            String ind = punto.getString(punto.getColumnIndex("indirizzo"));
            String descr = punto.getString(punto.getColumnIndex("descrizione"));
            String imm = punto.getString(punto.getColumnIndex("immagine"));
            String pre = punto.getString(punto.getColumnIndex("prezzo_medio"));
            String tel = punto.getString(punto.getColumnIndex("telefono"));
            String si = punto.getString(punto.getColumnIndex("sito_internet"));
            String par = punto.getString(punto.getColumnIndex("parcheggio"));


            TextView indir = findViewById(R.id.indirizzo);
            indir.setText(ind);
            TextView de = findViewById(R.id.descr);
            de.setText(descr);
            Uri myuri = Uri.parse(imm);
            ImageView image = findViewById(R.id.sfondo);
            image.setImageURI(myuri);
            TextView prezzo = findViewById(R.id.prezzo);
            prezzo.setText(pre);
            TextView telefono = findViewById(R.id.tel);
            telefono.setText(tel);
            TextView sito = findViewById(R.id.sito);
            sito.setText(si);
            TextView parcheggio = findViewById(R.id.parcheggio);
            parcheggio.setText(par);
        }

        Button a = findViewById(R.id.mappa);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Pernottamento2Activity.this,Pernottamento3Activity.class);
                i.putExtra("nome",t);
                startActivity(i);

            }
        });

    }
}
