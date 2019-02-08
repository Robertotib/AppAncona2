package com.example.test.appancona.Città;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.appancona.*;


public class Citta extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citta);
        addListenerOnNegozi();
        addListenerOnVisitarla();
        addListenerOnTradizioni();
        addListenerOnArrivarci();
    }
    public void addListenerOnArrivarci(){
        ImageView a;
        TextView b;
        a  =  findViewById(R.id.image1);
        b = findViewById(R.id.label1);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,MappaActivity.class);
                i.putExtra("nome", "Come visitarla");
                i.putExtra("indirizzo", "Piazza Cavour");
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,MappaActivity.class);
                i.putExtra("nome", "Come visitarla");
                i.putExtra("indirizzo", "Piazza Cavour");
                startActivity(i);

            }
        });
    }
    public void addListenerOnNegozi(){
        ImageView a;
        TextView b;
        a  =  findViewById(R.id.image3);
        b = findViewById(R.id.label3);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,ElencoNegozi_tipici.class);
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,ElencoNegozi_tipici.class);
                startActivity(i);

            }
        });
    }
    public void addListenerOnVisitarla(){
        ImageView a;
        TextView b;
        a  =  findViewById(R.id.image2);
        b = findViewById(R.id.label2);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,Visitarla.class);
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,Visitarla.class);
                startActivity(i);

            }
        });
    }
    public void addListenerOnTradizioni(){
        ImageView a;
        TextView b;
        a  =  findViewById(R.id.image4);
        b = findViewById(R.id.label4);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,Tradizioni.class);
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(Citta.this,Tradizioni.class);
                startActivity(i);

            }
        });
    }

}
