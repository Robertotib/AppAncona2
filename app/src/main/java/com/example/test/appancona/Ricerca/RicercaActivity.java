package com.example.test.appancona.Ricerca;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.appancona.MainActivity;
import com.example.test.appancona.Punti_interesse.Punti_interesseActivity;
import com.example.test.appancona.R;

public class RicercaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca);
        this.addListenerOnPuntiInteresse();
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
}
