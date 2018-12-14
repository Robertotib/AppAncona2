package com.example.test.appancona;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class CittaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citta);
        addListenerOnNegozi();
        addListenerOnVisitarla();
        addListenerOnTradizioni();
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
                i = new Intent(CittaActivity.this,Negozi_tipiciActivity.class);
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(CittaActivity.this,Negozi_tipiciActivity.class);
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
                i = new Intent(CittaActivity.this,VisitarlaActivity.class);
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(CittaActivity.this,VisitarlaActivity.class);
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
                i = new Intent(CittaActivity.this,TradizioniActivity.class);
                startActivity(i);

            }
        });

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(CittaActivity.this,TradizioniActivity.class);
                startActivity(i);

            }
        });
    }

}
