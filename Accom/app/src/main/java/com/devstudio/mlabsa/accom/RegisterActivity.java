package com.devstudio.mlabsa.accom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mLabsa on 4/4/2015.
 */
public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_actvity);

        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Closing registration screen
                // Switching to Login Screen/closing REGISTER screen
                finish();
            }
        });
        Button menuScreen = (Button) findViewById(R.id.link_to_menu);

        menuScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Switching to MENU screen

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);

            }

        });
    }
}
