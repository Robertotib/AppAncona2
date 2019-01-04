package com.example.test.appancona.Servizi;

import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.test.appancona.*;

import com.example.test.appancona.Database.DBManager;
import com.google.android.gms.maps.model.LatLng;

public class Servizi2Activity extends AppCompatActivity {
    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servizi2);

        lv = new ListView(this);
        setContentView(lv);
        db = new DBManager(this);
        String t=getIntent().getStringExtra("tipo");
        Integer dist = getIntent().getIntExtra("distanza",0)*20;
        Cursor puntiInt;

        /**
         * Blocco filtaggio Categoria
         */
        if(!t.equals("Tutte")) {
            setTitle(t);
            t=  "'" + t + "'";
            puntiInt = db.getServiziByTipo(t);
        }else {
            setTitle("Servizi");
            puntiInt = db.getServizi();
        }

        /**
         * Blocco filtaggio distanza
         */
        GPSTracker gps = new GPSTracker(this);

        Cursor filtro = new MatrixCursor(new String[] {"immagine","nome","indirizzo","_id"});
        if (dist != 0)
        {
            LatLng inizio = null ;
            if(gps.canGetLocation()){
                inizio = new LatLng(gps.getLatitude(),gps.getLongitude());
            }
            while (puntiInt.moveToNext())
            {
                String posizione = puntiInt.getString(puntiInt.getColumnIndex("indirizzo"));
                MappaActivity ma = new MappaActivity();

                LatLng fine = ma.getSingleLocationFromAddress(posizione+" ancona",this);
                Integer diffdist = ma.calcoloDistanza(inizio,fine,this);
                if(diffdist <= dist)
                {
                    String [] colonne = {
                            puntiInt.getString(puntiInt.getColumnIndex("immagine")),
                            puntiInt.getString(puntiInt.getColumnIndex("nome")),
                            puntiInt.getString(puntiInt.getColumnIndex("indirizzo")),
                            puntiInt.getString(puntiInt.getColumnIndex("_id"))
                    };
                    ((MatrixCursor) filtro).addRow(colonne);

                }
            }
        }
        else {
            filtro = puntiInt;
        }

        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_servizi2,
                filtro,
                new String[]{"immagine","nome","indirizzo","_id"},
                new int[]{R.id.imageserv2,R.id.nome,R.id.indirizzo,R.id.id},
                0
        );

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                TextView textView =  view.findViewById(R.id.nome);
                String nome = textView.getText().toString();
                TextView textView2 =  view.findViewById(R.id.id);
                String myid= textView2.getText().toString();


                i = new Intent(Servizi2Activity.this, Servizi3Activity.class);
                i.putExtra("nome", nome);
                i.putExtra("id", myid);
                startActivity(i);


            }
        });
    }
}
