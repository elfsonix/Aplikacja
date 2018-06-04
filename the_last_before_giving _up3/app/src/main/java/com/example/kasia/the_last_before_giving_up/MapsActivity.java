package com.example.kasia.the_last_before_giving_up;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//When Map Loads Successfully
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                //Your code where exception occurs goes here...
                List<LatLng> locations = new ArrayList<>();
                locations.add(new LatLng(50.0532,19.9559));
                locations.add(new LatLng(50.0668,19.9456));
                locations.add(new LatLng(50.0639,19.9999));
                locations.add(new LatLng(50.0279,19.9506));
                locations.add(new LatLng(50.0631,19.9399));

                for(LatLng latLng : locations) {
                    mMap.addMarker(new MarkerOptions().position(latLng).title("Title can be anything"));
                }


                //LatLngBound will cover all your marker on Google Maps
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(locations.get(0)); //Taking Point A (First LatLng)
                builder.include(locations.get(locations.size() - 1)); //Taking Point B (Second LatLng)
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);
                mMap.moveCamera(cu);
                mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
                //dotąd wyświetla tylko punkty z info: 'title can be anything' - 1. wersja

                //ten kod wyświetla punkt z info o nazwie i populacji -> przerobić locations.add(new LatLng...
                //na poniższy fragment kodu dla każdego miejsca (potem trzeba usunąć te locations.add; nie można
                //użyć tych samych współrzędnych dwa razy, bo wywala błędy
                //w snippet chyba trzeba dodać te wszystkie inforamcje, tzn katergoaria, obniżka itd
                LatLng BRISBANE = new LatLng(50.0562,19.9580);
                Marker mBrisbane = mMap.addMarker(new MarkerOptions()
                        .position(BRISBANE)
                        .title("Brisbane")
                        .snippet("Population: 2,074,200")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            }
        });

    }

}
