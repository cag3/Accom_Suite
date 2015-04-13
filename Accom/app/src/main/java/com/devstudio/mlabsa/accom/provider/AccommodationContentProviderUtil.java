package com.devstudio.mlabsa.accom.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.devstudio.mlabsa.accom.dto.AccommodationDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe on 2015-04-11.
 */
public class AccommodationContentProviderUtil {

    private static final String TAG = AccommodationContentProviderUtil.class.getSimpleName();


    public static final String ACCOMMODATION_AUTHORITY = "com.devstudio.mlabsa.accom.provider;";
    public static final String ACCOMMODATION_BASE_PATH = "accommodation";
    public static final Uri ACCOMMODATION_CONTENT_URI = Uri.parse("content://"+ACCOMMODATION_AUTHORITY+"/"+ACCOMMODATION_BASE_PATH);

    //These are literal values for Content-Resolver Query Types
    //Query Types
    public static final int QUERY_TYPE_BY_COLUMN_ID = 1;
    public static final int QUERY_TYPE_BY_ACCOMMODATION_ID = 2;
    public static final int QUERY_TYPE_LIST = 3;

    //----------get list of accommodations---------------------------
    public static List<AccommodationDTO> getAccommodations(ContentResolver contentResolver){
        List<AccommodationDTO> accommodationList = new ArrayList<AccommodationDTO>();
        Cursor accommodationListCursor = contentResolver.query(ACCOMMODATION_CONTENT_URI,AccommodationTable.DEFAULT_ACCOMMODATION_PROJECTIONS,null,null,AccommodationTable.DEFAULT_SORT_ORDER);
        if(accommodationListCursor != null){
            //we have the data, now we're iterating
            while(accommodationListCursor.moveToNext()){
                //get values from the cursor
                AccommodationDTO accommodation = fromCursor(accommodationListCursor);
                accommodationList.add(accommodation);
            }
        }

        return accommodationList;
    }

    //----------add language-------------------------------------
    public static Uri addAccommodation(ContentResolver contentResolver, AccommodationDTO accommodationDataObject){
        Log.i(TAG, "Adding Accommodation:: \n " + accommodationDataObject);
        Uri newAccommodationUri = null;
        ContentValues newAccommodationValues = fromAccommodationDTO(accommodationDataObject);
        if(newAccommodationValues != null){
            //use content-resolver to save into CP
            newAccommodationUri = contentResolver.insert(ACCOMMODATION_CONTENT_URI,newAccommodationValues);
        }
        return newAccommodationUri;

    }

    //---------get student from cursor--------------------------------
    private static AccommodationDTO fromCursor(Cursor cursor){
        String fullName=cursor.getString(cursor.getColumnIndex(AccommodationTable.COLUMN_FULLNAME));
        Integer phoneNumber=cursor.getInt(cursor.getColumnIndex(AccommodationTable.COLUMN_PHONENUMBER));
        String email=cursor.getString(cursor.getColumnIndex(AccommodationTable.COLUMN_EMAIL));
        String address=cursor.getString(cursor.getColumnIndex(AccommodationTable.COLUMN_ADDRESS));
        String description=cursor.getString(cursor.getColumnIndex(AccommodationTable.COLUMN_DESCRIPTION));
        String dwellingType=cursor.getString(cursor.getColumnIndex(AccommodationTable.COLUMN_DWELLINGTYPE));
        Integer bedrooms=cursor.getInt(cursor.getColumnIndex(AccommodationTable.COLUMN_BEDROOMS));
        float price=cursor.getFloat(cursor.getColumnIndex(AccommodationTable.COLUMN_PRICE));
        String accommodationID= cursor.getString(cursor.getColumnIndex(AccommodationTable.COLUMN_ACCOMMODATION_ID));
        // int id=cursor.getInt(cursor.getColumnIndex(StudentsTable.COLUMN_CP_STUDENT_ID));

        AccommodationDTO accommodation = new AccommodationDTO(0,fullName,phoneNumber,email,address,description,dwellingType,bedrooms,price);

        return accommodation;
    }
    //-----------get values to insert------------------------------------
    public static ContentValues fromAccommodationDTO(AccommodationDTO AccommodationDataObject){
        if(AccommodationDataObject==null){ return null;}

        ContentValues valuesToInsert = new ContentValues();
        valuesToInsert.put(AccommodationTable.COLUMN_FULLNAME,AccommodationDataObject.getFullName());
        valuesToInsert.put(AccommodationTable.COLUMN_PHONENUMBER,AccommodationDataObject.getPhoneNumber());
        valuesToInsert.put(AccommodationTable.COLUMN_EMAIL,AccommodationDataObject.getEmail());

        valuesToInsert.put(AccommodationTable.COLUMN_ADDRESS,AccommodationDataObject.getAddress());
        valuesToInsert.put(AccommodationTable.COLUMN_DESCRIPTION,AccommodationDataObject.getDescription());
        valuesToInsert.put(AccommodationTable.COLUMN_DWELLINGTYPE,AccommodationDataObject.getDwellingType());

        valuesToInsert.put(AccommodationTable.COLUMN_BEDROOMS,AccommodationDataObject.getBedroom());
        valuesToInsert.put(AccommodationTable.COLUMN_PRICE,AccommodationDataObject.getPrice());

        return valuesToInsert;
    }
}
