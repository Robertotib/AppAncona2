package com.example.test.appancona.Ricerca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.test.appancona.R;
import com.example.test.appancona.Ristorazione.RistorazioneActivity;

public class Ricerca_ristorazioneActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca_ristorazione);
        valoreSeekBarDist(R.id.distanza,R.id.valoredist);
        valoreSeekBarPrez(R.id.prezzo,R.id.valoreprezzo);
        addSeekerListenerDist(R.id.distanza,R.id.valoredist);
        addSeekerListenerPrez(R.id.prezzo,R.id.valoreprezzo);
        addListenerRicerca();

    }


    public void addSeekerListenerDist(final int idseeker, final int idtext)
    {
        SeekBar dis = findViewById(idseeker);
        dis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valoreSeekBarDist(idseeker,idtext);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void valoreSeekBarDist(int idseeker, int idtext )
    {
        SeekBar dist = findViewById(idseeker);
        Integer numero =dist.getProgress()+100;
        TextView valore = findViewById(idtext);
        valore.setText(numero.toString()+ " m");
    }
    public void addSeekerListenerPrez(final int idseeker, final int idtext)
    {
        SeekBar dis = findViewById(idseeker);
        dis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valoreSeekBarPrez(idseeker,idtext);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void valoreSeekBarPrez(int idseeker, int idtext )
    {
        SeekBar dist = findViewById(idseeker);
        Integer numero =dist.getProgress()+10;
        TextView valore = findViewById(idtext);
        valore.setText(numero.toString()+ " €");
    }

    public void addListenerRicerca()
    {
        Button cerca = findViewById(R.id.ricerca);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeekBar pre =findViewById(R.id.prezzo);
                SeekBar di =findViewById(R.id.distanza);
                Integer dis= di.getProgress()+100;
                Integer prez = pre.getProgress();

                Intent i;
                i = new Intent(Ricerca_ristorazioneActivity.this, RistorazioneActivity.class);
                i.putExtra("distanza",dis);
                i.putExtra("prezzo",prez);
                startActivity(i);
            }
        });
    }
}
