package com.example.test.appancona.Ricerca;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.appancona.MappaActivity;
import com.example.test.appancona.MappaActivity.*;
import com.example.test.appancona.R;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Ricerca_punti_interesseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca_punti_interesse);
        TextView tv = findViewById(R.id.distanza);
        tv.setText(CalcoloDistanza("via piave 5 ancona ","via piave 4 ancona").toString());

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
}
