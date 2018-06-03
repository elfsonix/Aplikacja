package com.example.kasia.the_last_before_giving_up;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Android_database.db";
    public static final String TABLE_NAME1 = "MIEJSCA";
    public static final String COL_1A = "ID_MIEJSCA";
    public static final String COL_2A = "NAZWA";
    public static final String COL_3A = "SZEROKOSC";
    public static final String COL_4A = "DLUGOSC";
    public static final String COL_5A = "KATEGORIA";

    public static final String TABLE_NAME2 = "PROMOCJE";
    public static final String COL_1B = "ID_PROMOCJI";
    public static final String COL_2B = "ID_MIEJSCA";
    public static final String COL_3B = "OBNIZKA";
    public static final String COL_4B = "UWAGI";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME1 + " (ID_MIEJSCA TEXT PRIMARY KEY AUTOINCREMENT, NAZWA TEXT, SZEROKOSC TEXT, DLUGOSC TEXT, KATEGORIA TEXT)");
        db.execSQL("create table " + TABLE_NAME2 + " (ID_PROMOCJI TEXT PRIMARY KEY AUTOINCREMENT, ID_MIEJSCA TEXT, OBNIZKA TEXT, UWAGI TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }


    public boolean insertData(String ID_MIEJSCA, String NAZWA, String SZEROKOSC,String DLUGOSC, String KATEGORIA, String OBNIZKA, String UWAGI){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        ContentValues contentValues2 = new ContentValues();

        contentValues1.put(COL_2A, NAZWA);
        contentValues1.put(COL_3A, SZEROKOSC);
        contentValues1.put(COL_4A, DLUGOSC);
        contentValues1.put(COL_5A, KATEGORIA);
        contentValues2.put(COL_2B, ID_MIEJSCA);
        contentValues2.put(COL_3B, OBNIZKA);
        contentValues2.put(COL_4B, UWAGI);

        long result1 = db.insert(TABLE_NAME1,null ,contentValues1);
        long result2 = db.insert(TABLE_NAME2,null ,contentValues2);

        if(result1 == -1)
            return false;
        else
            if(result2 == -1)
                return false;
            return true;
    }

    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from "+TABLE_NAME1,null);
    }

    public Cursor getAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from "+TABLE_NAME2,null);
    }


    public boolean updateData(String ID_MIEJSCA,String ID_PROMOCJI, String NAZWA, String SZEROKOSC,String DLUGOSC, String KATEGORIA, String OBNIZKA, String UWAGI) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        ContentValues contentValues2 = new ContentValues();

        contentValues1.put(COL_2A, NAZWA);
        contentValues1.put(COL_3A, SZEROKOSC);
        contentValues1.put(COL_4A, DLUGOSC);
        contentValues1.put(COL_5A, KATEGORIA);
        contentValues2.put(COL_2B, ID_MIEJSCA);
        contentValues2.put(COL_3B, OBNIZKA);
        contentValues2.put(COL_4B, UWAGI);
        db.update(TABLE_NAME1, contentValues1, "ID = ?",new String[] { ID_MIEJSCA });
        db.update(TABLE_NAME2, contentValues2, "ID = ?",new String[] { ID_PROMOCJI });

        return true;
    }


    public Integer deleteData1(String ID_MIEJSCA) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME1, "ID = ?",new String[] {ID_MIEJSCA});
    }

    public Integer deleteData2(String ID_PROMOCJI) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME2, "ID = ?",new String[] {ID_PROMOCJI});
    }

}