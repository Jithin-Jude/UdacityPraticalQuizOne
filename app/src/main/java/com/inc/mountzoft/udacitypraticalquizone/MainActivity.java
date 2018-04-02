package com.inc.mountzoft.udacitypraticalquizone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    EditText usernameInput, emailInput, aboutuserInput;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attaching the layout to the toolbar object
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Setting toolbar as the ActionBar with setSupportActionBar() call
        setSupportActionBar(toolbar);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_user) {
            Intent intent = new Intent(this,DetailsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void nextButtonFunction(View view){
        usernameInput = (EditText)findViewById(R.id.user_name);
        emailInput = (EditText)findViewById(R.id.email);
        aboutuserInput = (EditText)findViewById(R.id.about);

        editor.putString("USER_NAME",usernameInput.getText().toString());
        editor.putString("USER_EMAIL",emailInput.getText().toString());
        editor.putString("ABOUT_USER",aboutuserInput.getText().toString());
        editor.commit();

        Intent intent = new Intent(this,DetailsActivity.class);
        startActivity(intent);
    }
}
