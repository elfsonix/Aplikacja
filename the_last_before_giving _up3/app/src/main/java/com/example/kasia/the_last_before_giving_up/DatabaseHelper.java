package com.example.kasia.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Android_database.db";
    public static final String TABLE_NAME1 = "MIEJSCA";
    public static final String COL_1A = "ID MIEJSCA";
    public static final String COL_2A = "NAZWA";
    public static final String COL_3A = "SZEROKOŚĆ";
    public static final String COL_4A = "DŁUGOŚĆ";
    public static final String COL_5A = "KATEGORIA";

    public static final String TABLE_NAME2 = "PROMOCJE";
    public static final String COL_1B = "ID PROMOCJI";
    public static final String COL_2B = "ID MIEJSCA";
    public static final String COL_3B = "OBNIŻKA";
    public static final String COL_4B = "UWAGI";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME1 + " (ID MIEJSCA INTEGER PRIMARY KEY AUTOINCREMENT, NAZWA TEXT, SZEROKOŚĆ FLOAT, DŁUGOŚĆ FLOAT, KATEGORIA TEXT)");
        db.execSQL("create table " + TABLE_NAME2 + " (ID PROMOCJI INTEGER PRIMARY KEY AUTOINCREMENT, ID MIEJSCA TEXT, OBNIŻKA INTEGER, UWAGI TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);

        onCreate(db);

    }
}