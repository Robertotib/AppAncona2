package com.example.test.appancona.Ricerca;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.test.appancona.Database.DBManager;
import com.example.test.appancona.Punti_interesse.Punti_interesse2Activity;
import com.example.test.appancona.R;
import com.example.test.appancona.Servizi.Servizi2Activity;

import java.util.ArrayList;
import java.util.List;

public class Ricerca_serviziActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca_servizi);
        valoreSeekBar(R.id.distanza,R.id.valoredist);
        addSeekerListener(R.id.distanza,R.id.valoredist);
        inizializzaSpinner();
        addListenerRicerca();

    }


    public void addSeekerListener(final int idseeker, final int idtext)
    {
        SeekBar dis = findViewById(idseeker);
        dis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valoreSeekBar(idseeker,idtext);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void valoreSeekBar(int idseeker, int idtext )
    {
        SeekBar dist = findViewById(idseeker);
        Integer numero =dist.getProgress()+100;
        TextView valore = findViewById(idtext);
        valore.setText(numero.toString()+ " m");
    }
    public void inizializzaSpinner()
    {
        List<String> spinnerArray =  new ArrayList<String>();
        DBManager db = new DBManager(this);
        Cursor tipi = db.tipiServizi();
        spinnerArray.add("Tutte");
        while (tipi.moveToNext())
        {
            spinnerArray.add(tipi.getString(tipi.getColumnIndex("_id")));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.categoria);
        sItems.setAdapter(adapter);
    }
    public void addListenerRicerca()
    {
        Button cerca = findViewById(R.id.ricerca);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner ris =findViewById(R.id.categoria);
                SeekBar di =findViewById(R.id.distanza);
                Integer dis= di.getProgress()+100;

                String tipo = ris.getSelectedItem().toString();
                Intent i;
                i = new Intent(Ricerca_serviziActivity.this, Servizi2Activity.class);
                i.putExtra("tipo", tipo);
                i.putExtra("distanza",dis);
                startActivity(i);
            }
        });
    }
}
