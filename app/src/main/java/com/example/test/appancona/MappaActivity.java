package com.example.test.appancona;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.GoogleRoadManager;
import org.osmdroid.bonuspack.routing.GraphHopperRoadManager;
import org.osmdroid.bonuspack.routing.MapQuestRoadManager;
import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.bonuspack.routing.RoadNode;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.io.IOException;
import java.math.RoundingMode;
import java.security.Provider;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MappaActivity extends AppCompatActivity {
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Location myLocation;
    private Road road = null;
    private String indirizzo;
    private MapView map;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mappa);
        String t = getIntent().getStringExtra("nome");
        indirizzo = getIntent().getStringExtra("indirizzo");
        map =  findViewById(R.id.map);
        setTitle(t);

        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("My Location: ", location.toString());
                myLocation = location;
                percorso(myLocation);
                Indicazioni(road);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        if(Build.VERSION.SDK_INT < 23)
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }else {


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        myLocation=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        inizializzaMappa();
        percorso(myLocation);
        Indicazioni(road);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
            {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }

    public void inizializzaMappa(){


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);





    }
    public void percorso (Location location)
    {
        GeoPoint startPoint = new GeoPoint(location);
        LatLng luogo = getSingleLocationFromAddress(indirizzo+" ancona",this);
        IMapController mapController = map.getController();
        mapController.setZoom(9.0);
        mapController.setCenter(startPoint);
        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("Start point");
        map.getOverlays().add(startMarker);
        map.invalidate();
    RoadManager roadManager = new GraphHopperRoadManager("0b4fbc1c-22f4-4a8e-af38-3a4d422a395c&locale=it",true);
    ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();
        waypoints.add(startPoint);
    GeoPoint endPoint = new GeoPoint(luogo.latitude, luogo.longitude);
        waypoints.add(endPoint);
    Marker endMarker = new Marker(map);
        endMarker.setPosition(endPoint);
        endMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        endMarker.setTitle("End point");
        map.getOverlays().add(endMarker);
    Road road = roadManager.getRoad(waypoints);
    Polyline roadOverlay = RoadManager.buildRoadOverlay(road);
        map.getOverlays().add(roadOverlay);
        map.invalidate();
        this.road=road;
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

    public Integer CalcoloDistanza(LatLng start,LatLng end,Context c)
    {

        Location locstart= new Location("undici");
        Location locend= new Location("dodici");
        locstart.setLatitude(start.latitude);
        locstart.setLongitude(start.longitude);
        locend.setLatitude(end.latitude);
        locend.setLongitude(end.longitude);
        Float distanza = locend.distanceTo(locstart);
        return distanza.intValue();
    }
    public void Indicazioni (Road strada)
    {
        ListView lv = findViewById(R.id.indicazioni);
        String [] indicazioni = new String[this.road.mNodes.size()];
        ArrayList<RoadNode> nodi = strada.mNodes;

        Integer k;
        int i;

        for (i = 0; i < this.road.mNodes.size()-1;i++)
        {
            String istruzione;
            Double distanza =strada.mNodes.get(i).mLength;
            if(distanza < 1)
            {
                distanza= (distanza*1000);
                Integer metri = distanza.intValue();
                istruzione = strada.mNodes.get(i).mInstructions+"\n\t"+metri+" m";
            }else
            {
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.HALF_EVEN);

                istruzione = strada.mNodes.get(i).mInstructions + "\n\t\t" + df.format(distanza) + " km";
            }
            k = i+1;
            indicazioni[i]=k.toString()+"\t\t"+istruzione+"\t\t";

            if(strada.mNodes.get(i).mDuration < 60){
                Double secondi =strada.mNodes.get(i).mDuration;
                indicazioni[i]=indicazioni[i]+secondi.intValue()+" sec";
            }else{
                Double minuti = strada.mNodes.get(i).mDuration/60;
                indicazioni[i]=indicazioni[i]+minuti.intValue()+" min";
            }


        }
        k = i+1;
        indicazioni[strada.mNodes.size()-1]=k.toString()+"\t\t"+strada.mNodes.get(i).mInstructions ;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.indicazioni,R.id.ind,indicazioni);
        lv.setAdapter(arrayAdapter);

    }
}

