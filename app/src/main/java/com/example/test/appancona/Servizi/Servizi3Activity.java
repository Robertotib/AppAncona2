package com.example.test.appancona.Servizi;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.appancona.*;

import com.example.test.appancona.Database.DBManager;

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
        String ind = null;
        if (punto.moveToFirst()) {
            ind = punto.getString(punto.getColumnIndex("indirizzo"));
            String imm = punto.getString(punto.getColumnIndex("immagine"));
            String ema = punto.getString(punto.getColumnIndex("email"));
            String tel = punto.getString(punto.getColumnIndex("telefono"));
            String si = punto.getString(punto.getColumnIndex("sito_internet"));

            TextView indir = findViewById(R.id.indirizzo);
            indir.setText(ind);
            Uri myuri = Uri.parse(imm);
            ImageView image = findViewById(R.id.sfondo);
            image.setImageURI(myuri);
            TextView email = findViewById(R.id.email);
            email.setText(ema);
            TextView telefono = findViewById(R.id.tel);
            telefono.setText(tel);
            TextView sito = findViewById(R.id.sito);
            sito.setClickable(true);
            sito.setMovementMethod(LinkMovementMethod.getInstance());
            String text = "<a href='http://"+si+"'> Vai al sito </a>";
            sito.setText(Html.fromHtml(text));
        }

        Button a = findViewById(R.id.mappa);
        final String finalInd = ind;
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Servizi3Activity.this,MappaActivity.class);
                i.putExtra("nome",t);
                i.putExtra("indirizzo", finalInd);
                startActivity(i);

            }
        });

    }
}
