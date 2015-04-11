package com.devstudio.mlabsa.accom.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CodeTribe on 2015-04-11.
 */
public class AccommodationDatabaseHelper extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String DATABASE_FILE="accommodation.db";

    public AccommodationDatabaseHelper(Context context) {
        super(context, DATABASE_FILE, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        AccommodationTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        AccommodationTable.onUpgrade(db);
    }
}
