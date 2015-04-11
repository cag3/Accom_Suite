package com.devstudio.mlabsa.accom.provider;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CodeTribe on 2015-04-11.
 */
public class AccommodationTable {

    public static final String ACCOMMODATION_TABLE_NAME = "accommodation";
    public static final String COLUMN_FULLNAME = "fullName";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DWELLINGTYPE = "dwellingType";
    public static final String COLUMN_BEDROOMS = "bedroom";
    public static final String COLUMN_PRICE = "price";
    //GLOBAL ID
    public static final String COLUMN_ACCOMMODATION_ID = "accommodationID";
    //LOCAL ID
    public static final String COLUMN_CP_ACCOMMODATION_ID= "_ID";

    public static final String DEFAULT_SORT_ORDER="_ID Desc" ;

    public static final String[] DEFAULT_ACCOMMODATION_PROJECTIONS={COLUMN_FULLNAME,
            COLUMN_PHONENUMBER,COLUMN_EMAIL,COLUMN_ADDRESS,COLUMN_DESCRIPTION,COLUMN_DWELLINGTYPE,
            COLUMN_BEDROOMS,COLUMN_PRICE,COLUMN_ACCOMMODATION_ID};

    private static final String CREATE_TABLE_QUERY = " CREATE TABLE "+ACCOMMODATION_TABLE_NAME+" "
            +" ( "+COLUMN_CP_ACCOMMODATION_ID+" integer primary key autoincrement,"
            +COLUMN_ACCOMMODATION_ID+ " text, "
            +COLUMN_FULLNAME+ " text not null, "
            +COLUMN_PHONENUMBER+ " number not null, "
            +COLUMN_EMAIL+ " text not null, "
            +COLUMN_ADDRESS+ " text not null, "
            +COLUMN_DESCRIPTION+ " text not null"
            +COLUMN_DWELLINGTYPE+ " text not null, "
            +COLUMN_BEDROOMS+ " number not null, "
            +COLUMN_PRICE+ " number not null)";

    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ACCOMMODATION_TABLE_NAME;


    public static void onCreate(SQLiteDatabase database){
        //create a database/table
        database.execSQL(CREATE_TABLE_QUERY);
    }

    public static void onUpgrade(SQLiteDatabase database){
        //update the database/table
        database.execSQL(DROP_TABLE_QUERY);
        onCreate(database);
    }
}



