package com.devstudio.mlabsa.accom;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.devstudio.mlabsa.accom.dto.AccommodationDTO;
import com.devstudio.mlabsa.accom.provider.AccommodationContentProviderUtil;

import org.w3c.dom.Text;


/**
 * Created by CodeTribe on 2015-04-10.
 */
public class RegisterAdActivity extends ActionBarActivity {
    Button ad_data;
    TextView add_fullname;
    TextView add_phonenumber, add_email,add_address,add_description,add_dwellingType,add_bedroom,add_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_advert_activity);

        ad_data = (Button) findViewById(R.id.add_to_database);
        add_fullname = (TextView) findViewById(R.id.fullname);
        add_phonenumber = (TextView) findViewById(R.id.phonenumber);
        add_email = (TextView) findViewById(R.id.email);

        ad_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname = add_fullname.getText().toString();
                Integer phonenumber = add_phonenumber.getText().length();
                String email = add_email.getText().toString();
                String address = add_address.getText().toString();
                String description = add_description.getText().toString();
                String dwellingType = add_dwellingType.getText().toString();
                Integer bedroom = add_bedroom.getText().length();
                Float price = add_price.getTextSize();


                //Instantaite the DTO
                AccommodationDTO accommodationDTO = new AccommodationDTO(null,fullname, phonenumber, email,address,description,dwellingType,bedroom,price);
                //adding to CP
                AccommodationContentProviderUtil.addAccommodation(getContentResolver(), accommodationDTO);


            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
