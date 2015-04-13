package com.devstudio.mlabsa.accom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.devstudio.mlabsa.accom.dto.AccommodationDTO;
import com.devstudio.mlabsa.accom.provider.AccommodationContentProviderUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe on 2015-04-10.
 */
public class ListActivity extends Activity {
    ListView listView;
    Context ctx;
    AccommodationDTOAdapter accommodationDTOAdapter;

    //ArrayList<String> arrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        // DUMMY DATA FOR THE LIST VIEW.....
       /* listView = (ListView) findViewById(R.id.list);
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(listAdapter);*/

        listView = (ListView) findViewById(R.id.list);

        List<AccommodationDTO> accommodationList = AccommodationContentProviderUtil.getAccommodations(getContentResolver());
        if (accommodationList == null) {
            accommodationList = new ArrayList<AccommodationDTO>();
        }
        ctx = getApplicationContext();
        accommodationDTOAdapter = new AccommodationDTOAdapter(ctx, accommodationList);
        listView.setAdapter(accommodationDTOAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //************Note**ND**Note**ND
                AccommodationDTO item = (AccommodationDTO) accommodationDTOAdapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), Activity.class);
                Bundle b = new Bundle();
                b.putString("fullname", item.getFullName());
                b.putString("email", item.getEmail());
                b.putInt("phonenumber", item.getPhoneNumber());
                intent.putExtra("accommodationBundle", b);
                startActivity(intent);


            }
        });

    }
}