package com.example.kasia.the_last_before_giving_up;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
       // TextView tv = (TextView)findViewById(R.id.textView1);

        DatabaseHelper db = new DatabaseHelper(this);

       /* tv.setText("");
        Promocja k = db.pokazPromocje(3);
        tv.setText(k.getIdmiejca()" "+k.getIdmiejca()" "+k.getObnizka()" "+k.getUwagi());
        while(k.moveToNext()){
            int idporomocji = k.getInt(0);
            int idmiejsca = k.getInt(1);
            String obnizka = k.getString(2);
            String uwagi = k.getString(3);
            tv.setText(tv.getText()+"\n"+idpromocji+" "idmiejsca" "+obnizka" "+uwagi);
        }*/


    }
}


 /*db.dodajPromocje("1", "1", "-30%", "Na obuwie i torebki");
        db.dodajPromocje("2", "2", "-20%", "na kolekcję wiosna-lato 2018");
        db.dodajPromocje("3", "3", "-50%", "Na kolekcję damską");
        db.dodajPromocje("4", "4", "-50%", "na obuwie marki Salomon");
        db.dodajPromocje("5", "5", "-70%", "na wybrane produkty");*/
