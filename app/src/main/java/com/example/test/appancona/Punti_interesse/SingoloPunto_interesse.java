package com.example.test.appancona.Punti_interesse;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.appancona.*;
import com.example.test.appancona.Database.DBManager;

public class SingoloPunto_interesse extends AppCompatActivity
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
        final Cursor punto = db.getPuntoInteresseById(myid);
        String ind=null;
        if (punto.moveToFirst()) {
            ind = punto.getString(punto.getColumnIndex("indirizzo"));
            String descr = punto.getString(punto.getColumnIndex("descrizione"));
            String imm = punto.getString(punto.getColumnIndex("immagine"));
            TextView indir = findViewById(R.id.indirizzo);
            indir.setText(ind);
            TextView de = findViewById(R.id.descr);
            de.setText(descr);
            de.setMovementMethod(new ScrollingMovementMethod());
            Uri myuri = Uri.parse(imm);
            ImageView image = findViewById(R.id.sfondo);
            image.setImageURI(myuri);
        }

       Button a = findViewById(R.id.mappa_punti_interesse);
        final String finalInd = ind;
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(SingoloPunto_interesse.this,MappaActivity.class);
                i.putExtra("nome",t);
                i.putExtra("indirizzo", finalInd);
                startActivity(i);

            }
        });
    }

}

