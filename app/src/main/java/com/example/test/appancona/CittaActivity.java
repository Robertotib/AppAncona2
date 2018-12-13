package com.example.test.appancona;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class CittaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citta);
        addListenerOnNegozi();
    }
    public void addListenerOnNegozi(){
        ImageView a;
        a  =  findViewById(R.id.image3);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(CittaActivity.this,Negozi_tipiciActivity.class);
                startActivity(i);

            }
        });

    }

}
