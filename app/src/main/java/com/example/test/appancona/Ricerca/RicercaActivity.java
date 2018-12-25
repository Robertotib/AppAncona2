package com.example.test.appancona.Ricerca;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.test.appancona.R;

public class RicercaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca);
        this.addListenerOnPuntiInteresse();
        this.addListenerOnServizi();
        this.addListenerOnRistorazione();
        this.addListenerOnPernottamento();
    }
    public void addListenerOnPuntiInteresse(){
        TextView a;
        ImageView b;
        a  =  findViewById(R.id.label1);
        b  = findViewById(R.id.image1);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this,Ricerca_punti_interesseActivity.class);
                startActivity(i);

            }
        });
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this,Ricerca_punti_interesseActivity.class);
                startActivity(i);

            }
        });
    }
    public void addListenerOnRistorazione(){
        TextView a;
        ImageView b;
        a  =  findViewById(R.id.label2);
        b  = findViewById(R.id.image2);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this,Ricerca_ristorazioneActivity.class);
                startActivity(i);

            }
        });
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this,Ricerca_ristorazioneActivity.class);
                startActivity(i);

            }
        });
    }
    public void addListenerOnPernottamento(){
        TextView a;
        ImageView b;
        a  =  findViewById(R.id.label3);
        b  = findViewById(R.id.image3);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this,Ricerca_pernottamentoActivity.class);
                startActivity(i);

            }
        });
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this,Ricerca_pernottamentoActivity.class);
                startActivity(i);

            }
        });
    }
    public void addListenerOnServizi() {
        TextView a;
        ImageView b;
        a = findViewById(R.id.label4);
        b = findViewById(R.id.image4);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this, Ricerca_serviziActivity.class);
                startActivity(i);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(RicercaActivity.this, Ricerca_serviziActivity.class);
                startActivity(i);

            }
        });
    }
}
