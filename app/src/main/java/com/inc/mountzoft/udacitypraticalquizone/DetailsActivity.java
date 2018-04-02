package com.inc.mountzoft.udacitypraticalquizone;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView userNameDisplay, userEmailDisplay, aboutUserDisplay;

    String name, userEmail, aboutUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        userNameDisplay = (TextView)findViewById(R.id.user_name_Display);
        userEmailDisplay = (TextView)findViewById(R.id.email_display);
        aboutUserDisplay = (TextView)findViewById(R.id.about_user_display);

        name = sharedPreferences.getString("USER_NAME",null);
        userEmail = sharedPreferences.getString("USER_EMAIL",null);
        aboutUser = sharedPreferences.getString("ABOUT_USER",null);

        userNameDisplay.setText(name);
        userEmailDisplay.setText(userEmail);
        aboutUserDisplay.setText(aboutUser);
    }
}
