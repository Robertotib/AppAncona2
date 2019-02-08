package com.example.test.appancona.Percorsi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.appancona.*;

import com.example.test.appancona.Città.Negozi_tipici2Activity;
import com.example.test.appancona.Database.DBManager;
import com.example.test.appancona.Punti_interesse.Punti_interesse3Activity;
import com.example.test.appancona.Ristorazione.SingoloRistorante;
import com.google.android.gms.maps.model.LatLng;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.GraphHopperRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.BoundingBox;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Percorsi2Activity extends AppCompatActivity {

    MapView map;
    private IMapController mapController;
    private Road road;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percorsi2);
        DBManager db=new DBManager(this);
        String t = getIntent().getStringExtra("nome");
        setTitle(t);

        map =  findViewById(R.id.map);
        mapController = map.getController();

        String id = getIntent().getStringExtra("id");
        inizializzaTappe(db.getTappeByPercorso(id));
        TextView desc = findViewById(R.id.descrizione);
        Cursor percorso = db.getPercorsoById(id);
        percorso.moveToFirst();
        String descr = percorso.getString(percorso.getColumnIndex("descrizione"));
        desc.setText(descr);
        desc.setMovementMethod(new ScrollingMovementMethod());

        inizializzaMappa();
        ArrayList<String>indirizzi = new ArrayList<>();
        Cursor tappe =db.getTappeByPercorso(id);
        while(tappe.moveToNext()){
          String indirizzo = tappe.getString(tappe.getColumnIndex("indirizzo"));
          indirizzi.add(indirizzo);
        }
        percorso(indirizzi);



    }

    public void inizializzaTappe(Cursor c){
        ListView lv = findViewById(R.id.tappe);
        final DBManager db=new DBManager(this);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(
                this,
                R.layout.tappa,
                c,
                new String[]{"_cod_tappa","nome_tappa","posizione"},
                new int[]{R.id.custom1,R.id.custom2,R.id.custom3},
                0
        );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                TextView textView2 =  view.findViewById(R.id.custom1 );
                String myid= textView2.getText().toString();

                if(db.isTappaPuntInt(myid))
                {
                    Cursor result = db.getPuntIntByCodTappa(myid);
                    result.moveToFirst();
                    String codice = result.getString(result.getColumnIndex("cod_pun_int"));
                    String nome = result.getString(result.getColumnIndex("nome_tappa"));
                    i = new Intent(Percorsi2Activity.this,Punti_interesse3Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("id", codice);
                    startActivity(i);
                }else if (db.isTappaRist(myid))
                {
                    Cursor result  = db.getRistByCodTappa(myid);
                    result.moveToFirst();
                    String codice = result.getString(result.getColumnIndex("cod_ristorazione"));
                    String nome = result.getString(result.getColumnIndex("nome_tappa"));
                    i = new Intent(Percorsi2Activity.this,SingoloRistorante.class);
                    i.putExtra("nome",nome);
                    i.putExtra("id", codice);
                    startActivity(i);
                }else if (db.isTappaNegozi(myid))
                {
                    Cursor result = db.getNegoziByCodTappa(myid);
                    result.moveToFirst();
                    String codice = result.getString(result.getColumnIndex("cod_negoz"));
                    String nome = result.getString(result.getColumnIndex("nome_tappa"));
                    i = new Intent(Percorsi2Activity.this,Negozi_tipici2Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("id", codice);
                    startActivity(i);
                }else
                    Toast.makeText(Percorsi2Activity.this, "Scelta non valida", Toast.LENGTH_LONG).show();


            }
        });
    }

    public void inizializzaMappa(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

    }

    public void percorso (ArrayList<String> tappe)
    {
        map.getOverlays().clear();
        ArrayList<GeoPoint> geoPoints = new ArrayList<>();
        for(int i=0 ;i<tappe.size();i++){
            LatLng luogo = getSingleLocationFromAddress(tappe.get(i)+" ancona",this);
            GeoPoint tappa = new GeoPoint(luogo.latitude,luogo.longitude);
            geoPoints.add(tappa);
            Log.d("punti",tappa.getLatitude()+"\t"+tappa.getLongitude());

            Marker startMarker = new Marker(map);
            startMarker.setPosition(tappa);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            startMarker.closeInfoWindow();
            map.getOverlays().add(startMarker);

            map.invalidate();


        }

        RoadManager roadManager = new GraphHopperRoadManager("0b4fbc1c-22f4-4a8e-af38-3a4d422a395c&locale=it", true);
        roadManager.addRequestOption("vehicle=foot");

        Road road = roadManager.getRoad(geoPoints);
        Polyline roadOverlay = RoadManager.buildRoadOverlay(road);
        map.getOverlays().add(roadOverlay);
        map.invalidate();
        this.road=road;


        mapController.setCenter(geoPoints.get(0));

        mapController.setZoom(15.0);


    }

    public LatLng getSingleLocationFromAddress(String strAddress, Context c)
    {
        Geocoder coder = new Geocoder(c, Locale.getDefault());
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



    public BoundingBox findBoundingBoxForGivenLocations(ArrayList<GeoPoint> coordinates)
    {
        double west = 0.0;
        double east = 0.0;
        double north = 0.0;
        double south = 0.0;

        for (int lc = 0; lc < coordinates.size(); lc++)
        {
            LatLng loc = new LatLng(coordinates.get(lc).getLatitude(),coordinates.get(lc).getLongitude());
            if (lc == 0)
            {
                north = loc.latitude;
                south = loc.latitude;
                west = loc.longitude;
                east = loc.longitude;
            }
            else
            {
                if (loc.latitude > north)
                {
                    north = loc.latitude;
                }
                else if (loc.latitude < south)
                {
                    south = loc.latitude;
                }
                if (loc.longitude < west)
                {
                    west = loc.longitude;
                }
                else if (loc.longitude > east)
                {
                    east = loc.longitude;
                }
            }
        }

        // OPTIONAL - Add some extra "padding" for better map display
        double padding = 0.01;
        north = north + padding;
        south = south - padding;
        west = west - padding;
        east = east + padding;

        return new BoundingBox(north, east, south, west);
    }
}
