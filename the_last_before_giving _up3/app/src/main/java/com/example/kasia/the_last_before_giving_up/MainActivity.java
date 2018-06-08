package com.example.kasia.the_last_before_giving_up;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.firstbtn:
                Intent intent= new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
                break;
        }
    }




    public static class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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

            mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    //Your code where exception occurs goes here...
                    /*List<LatLng> locations = new ArrayList<>();
                    locations.add(new LatLng(50.0532,19.9559));
                    locations.add(new LatLng(50.0668,19.9456));
                    locations.add(new LatLng(50.0639,19.9999));
                    locations.add(new LatLng(50.0279,19.9506));
                    locations.add(new LatLng(50.0631,19.9399));

                    for(LatLng latLng : locations) {
                        mMap.addMarker(new MarkerOptions().position(latLng).title("Title can be anything"));
                    }
*/

                    //LatLngBound will cover all your marker on Google Maps

                    //dotąd wyświetla tylko punkty z info: 'title can be anything' - 1. wersja

                    //ten kod wyświetla punkt z info o nazwie i populacji -> przerobić locations.add(new LatLng...
                    //na poniższy fragment kodu dla każdego miejsca (potem trzeba usunąć te locations.add; nie można
                    //użyć tych samych współrzędnych dwa razy, bo wywala błędy
                    //w snippet chyba trzeba dodać te wszystkie inforamcje, tzn katergoaria, obniżka itd
                    LatLng Badura = new LatLng(50.0532,19.9559);
                    Marker mBadura = mMap.addMarker(new MarkerOptions()
                            .position(Badura)
                            .title("Badura")
                            .snippet("Kategoria: Obuwie  " +
                                    "Obniżka: -30%  " +
                                    "Uwagi: Na obuwie i torebki")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

                    LatLng Księgarnia_Akademicka = new LatLng( 50.044673,19.918313);
                    Marker mKsięgarnia_Akademicka = mMap.addMarker(new MarkerOptions()
                            .position( Księgarnia_Akademicka)
                            .title(" Księgarnia Akademicka")
                            .snippet("Kategoria: Książki  " +
                                    "Obniżka: -20%  " +
                                    "Uwagi: Na podręczniki akademickie")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

                    LatLng Adidas = new LatLng( 50.087994,19.984829);
                    Marker mAdidas = mMap.addMarker(new MarkerOptions()
                            .position(Adidas)
                            .title("Adidas")
                            .snippet("Kategoria: Odzież, obuwie  " +
                                    "Obniżka: -50%  " +
                                    "Uwagi: Na kolekcję damską")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

                    LatLng Martes_Sport = new LatLng(50.0279,19.9506);
                    Marker mMartes_Sport = mMap.addMarker(new MarkerOptions()
                            .position(Martes_Sport)
                            .title("Martes Sport")
                            .snippet("Kategoria: Obuwie  " +
                                    "Obniżka: -50%  " +
                                    "Uwagi: Na obuwie marki Salomon")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

                    LatLng Empik = new LatLng(50.0631,19.9399);
                    Marker mEmpik = mMap.addMarker(new MarkerOptions()
                            .position(Empik)
                            .title("Empik")
                            .snippet("Kategoria: Papiernicze  " +
                                    "Obniżka: -50%  " +
                                    "Uwagi: Na wybrane produkty")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

                    LatLng Limoknova = new LatLng(50.06697,19.92033);
                    Marker mLimoknova = mMap.addMarker(new MarkerOptions()
                            .position(Limoknova)
                            .title("Limoknova")
                            .snippet("Kategoria: Restauracja  " +
                                    "Obniżka: -10%  " +
                                    "Uwagi: Na kawę do godziny 12:00  ")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                    LatLng Nawojka = new LatLng(50.064784,19.918279);
                    Marker mNawojka = mMap.addMarker(new MarkerOptions()
                            .position(Nawojka)
                            .title("Nawojka")
                            .snippet("Kategoria: Stołówka  " +
                                    "Obniżka: -15%  " +
                                    "Uwagi: Na zestaw dnia")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                    LatLng KFC = new LatLng(50.063494,19.940465);
                    Marker mKFC = mMap.addMarker(new MarkerOptions()
                            .position(KFC)
                            .title("KFC")
                            .snippet("Kategoria: Fast Food  " +
                                    "Obniżka: -30%  " +
                                    "Uwagi: Na hamburgery")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                    LatLng Miodova = new LatLng(50.053088,19.947983);
                    Marker mMiodova = mMap.addMarker(new MarkerOptions()
                            .position(Miodova)
                            .title("Miodova")
                            .snippet("Kategoria: Restauracja  " +
                                    "Obniżka: -10%  " +
                                    "Uwagi: Na desery")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                    LatLng Starbucks = new LatLng(50.066754,19.945567);
                    Marker mStarbucks = mMap.addMarker(new MarkerOptions()
                            .position(Starbucks)
                            .title("Starbucks")
                            .snippet("Kategoria: Kawiarnia  " +
                                    "Obniżka: -20%  " +
                                    "Uwagi: Na kawy mrożone")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


                    LatLngBounds.Builder builder = new LatLngBounds.Builder();
                    builder.include(Badura); //Taking Point A (First LatLng)
                    builder.include(Empik); //Taking Point B (Second LatLng)
                    LatLngBounds bounds = builder.build();

                    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);
                    mMap.moveCamera(cu);
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
                }
            });
        }
    }
}

