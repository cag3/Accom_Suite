package com.devstudio.mlabsa.accom.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.devstudio.mlabsa.accom.dto.AccommodationDTO;

/**
 * Created by CodeTribe on 2015-04-11.
 */
public class AccommodationContentProvider extends ContentProvider {

    private static final String TAG = AccommodationContentProvider.class.getSimpleName();
    private AccommodationDatabaseHelper database;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AccommodationContentProviderUtil.ACCOMMODATION_AUTHORITY,AccommodationContentProviderUtil.ACCOMMODATION_BASE_PATH,AccommodationContentProviderUtil.QUERY_TYPE_LIST);
        uriMatcher.addURI(AccommodationContentProviderUtil.ACCOMMODATION_AUTHORITY,AccommodationContentProviderUtil.ACCOMMODATION_BASE_PATH +"/#",AccommodationContentProviderUtil.QUERY_TYPE_BY_COLUMN_ID);
        uriMatcher.addURI(AccommodationContentProviderUtil.ACCOMMODATION_AUTHORITY,AccommodationContentProviderUtil.ACCOMMODATION_BASE_PATH +"/studentID/*",AccommodationContentProviderUtil.QUERY_TYPE_BY_ACCOMMODATION_ID);
    }

    @Override
    public boolean onCreate() {
        database = new AccommodationDatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(AccommodationTable.ACCOMMODATION_TABLE_NAME);
        //Is this a query by ID or by Global student ID
        int requestType= uriMatcher.match(uri);
        switch (requestType){
            case AccommodationContentProviderUtil.QUERY_TYPE_LIST:
                //retrieving all --> select * from students
                break;
            case AccommodationContentProviderUtil.QUERY_TYPE_BY_COLUMN_ID:
                //retrieving specific student --> select * form students where ID=x
                queryBuilder.appendWhere(AccommodationTable.COLUMN_CP_ACCOMMODATION_ID+"="+uri.getLastPathSegment());
                break;
            case AccommodationContentProviderUtil.QUERY_TYPE_BY_ACCOMMODATION_ID:
                //retriving a student with specific global ID
                queryBuilder.appendWhere(AccommodationTable.COLUMN_ACCOMMODATION_ID+"="+uri.getLastPathSegment());
                break;
            default:
                break;
        }
        Cursor cursor=null;
        SQLiteDatabase db = database.getWritableDatabase();
        try{
            cursor = queryBuilder.query(db,projection, selection,selectionArgs,null,null,AccommodationTable.DEFAULT_SORT_ORDER);
            if(cursor != null){ cursor.setNotificationUri(getContext().getContentResolver(), uri);}
        }catch (Exception e){
            Log.e(TAG, "Error while retrieving Accommodation(s) ", e);
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int requestType = uriMatcher.match(uri);
        if(requestType != AccommodationContentProviderUtil.QUERY_TYPE_LIST){
            throw new IllegalArgumentException("Invalid URI pattern for insert Operation.");
        }
        SQLiteDatabase db = database.getWritableDatabase();
        long newAccommodationLocalID = db.insert(AccommodationTable.ACCOMMODATION_TABLE_NAME,null,values);

        getContext().getContentResolver().notifyChange(uri,null);
        Uri newAccommodationURI = Uri.parse(AccommodationContentProviderUtil.ACCOMMODATION_CONTENT_URI.toString()+"/"+newAccommodationLocalID);
        Toast.makeText(getContext(), "Added Accommodation URI:: " + newAccommodationURI.toString(), Toast.LENGTH_LONG).show();
        return newAccommodationURI;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
