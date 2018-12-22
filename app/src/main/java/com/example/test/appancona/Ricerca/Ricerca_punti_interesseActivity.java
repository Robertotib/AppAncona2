package com.example.test.appancona.Ricerca;

import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.appancona.Database.DBManager;
import com.example.test.appancona.MappaActivity;
import com.example.test.appancona.MappaActivity.*;
import com.example.test.appancona.R;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Ricerca_punti_interesseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca_punti_interesse);
        valoreSeekBar(R.id.distanza,R.id.valoredist);
        SeekBar dis = findViewById(R.id.distanza);
        dis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valoreSeekBar(R.id.distanza,R.id.valoredist);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        inizializzaSpinner();
        addListenerRicerca();

      /*  TextView tv = findViewById(R.id.distanza);
        tv.setText(CalcoloDistanza("via piave 5 ancona ","via piave 4 ancona").toString());*/

    }
    public LatLng getSingleLocationFromAddress(String strAddress)
    {
        Geocoder coder = new Geocoder(this, Locale.getDefault());
        List<Address> address = null;
        Address location = null;
        LatLng temp = null;
        String strAddresNew = strAddress.replace(",", " ");
        try
        {
            address = coder.getFromLocationName(strAddresNew, 1);
            if (!address.isEmpty())
            {
                location = address.get(0);
                location.getLatitude();
                location.getLongitude();
                temp = new LatLng(location.getLatitude(), location.getLongitude());
                Log.d("Latlng : ", temp + "");
            }
        } catch (IOException e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return temp;
    }
    public Float CalcoloDistanza(String inizio,String fine)
    {

    LatLng start = getSingleLocationFromAddress(inizio);
    LatLng end = getSingleLocationFromAddress(fine);
    Location locstart= new Location("undici");
    Location locend= new Location("dodici");
        locstart.setLatitude(start.latitude);
        locstart.setLongitude(start.longitude);
        locend.setLatitude(end.latitude);
        locend.setLongitude(end.longitude);
    Float distanza = locend.distanceTo(locstart);
    return distanza;
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
        Cursor tipi = db.tipiPuntiinteresse();
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
                TextView di =findViewById(R.id.valoredist);
                Toast.makeText(Ricerca_punti_interesseActivity.this, di.getText()+" "+ ris.getSelectedItem().toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
