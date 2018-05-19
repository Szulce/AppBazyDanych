package com.example.szulce241d.appbazydanych;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //database
    public static final String DATABASE_NAME = "DB.db";
    //tables
    public static final String TABLE_USER = "USER";
    public static final String TABLE_BASKET = "BASKET";
    public static final String TABLE_TICKET = "TICKET";
    public static final String TABLE_LUGGAGE = "LUGGAGE";
    public static final String TABLE_ORDER = "ORDER";
    public static final String TABLE_CHECK_IN = "CHECK_IN";
    public static final String TABLE_AIR_CONNECTION= "AIR_CONNECTION";
    public static final String TABLE_PLANE = "PLANE";
    public static final String TABLE_DESTONATION = "DESTINATION";
    public static final String TABLE_SOURCE = "SOURCE";
    public static final String TABLE_PORT_DESCRIPTION = "PORT_DESCRIPTION";



    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table

        //table User
//        db.execSQL("CREATE TABLE "+TABLE_USER+" (" +
//                "ID INTEGER PRIMARY KEY," +
//                "NAME ," +
//                "SURNAME ," +
//                "NATIONALITY ," +
//                "LOGIN," +
//                "PASSWORD ," +
//                "SOL ," +
//                "E-MAIL ," +
//                "PERMISSIONS ," +
//                "BIRTHDATE ," +
//                "PHONE_NUMBER," +
//                "FK_BASKET INTEGER FOREGIN KEY);");

        //table Basket
        //db.execSQL("CREATE TABLE");
        //to wklej ze schematu

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
