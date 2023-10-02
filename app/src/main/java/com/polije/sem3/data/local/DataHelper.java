package com.polije.sem3.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "biodatadiri.db";
    private static final int DB_VERSION = 1;

    public DataHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE biodata (" +
                        "no integer primary key, " +
                        "nama text null, " +
                        "tgl text null, " +
                        "jk text null, " +
                        "alamat text null" +
                    ");";
        Log.d("Data", "OnCreate" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata VALUES (1, 'Darsiwan', '1996-07-12', 'Laki-laki', 'Indramayu')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
