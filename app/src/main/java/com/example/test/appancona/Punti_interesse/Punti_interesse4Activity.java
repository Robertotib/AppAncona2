package com.example.test.appancona.Punti_interesse;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.test.appancona.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Punti_interesse4Activity extends FragmentActivity implements OnMapReadyCallback  {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse4);
        String t =getIntent().getStringExtra("nome");

        setTitle(t);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String ind =getIntent().getStringExtra("indirizzo");

        LatLng luogo = getSingleLocationFromAddress(ind+" ancona");
        mMap.addMarker(new MarkerOptions().position(luogo).title(getIntent().getStringExtra("nome")));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(luogo).zoom(15).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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

}

