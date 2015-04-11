package com.devstudio.mlabsa.accom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by mLabsa on 4/4/2015.
 */
public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_activity);

        Button listScreen = (Button) findViewById(R.id.link_to_list);

        listScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Closing registration screen
                // Switching to Login Screen/closing REGISTER screen
                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(i);
            }
        });
        Button registerAdvertScreen = (Button) findViewById(R.id.link_to_Advert);

        registerAdvertScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Closing registration screen
                // Switching to Login Screen/closing REGISTER screen
                Intent intent = new Intent(getApplicationContext(), RegisterAdActivity.class);
                        startActivity(intent);
            }
        });
}
}
