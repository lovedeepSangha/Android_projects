package com.example.baldeepsingh.splash;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        populateListView();
        registerClickCallback();


    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(List.this, MainActivity.class));
        finish();

    }
    private void populateListView() {
// Create list of items
        String[] myItems = {"Genral Quiz","IIT/JEE","AIPMT","Bollywood Quiz"}; // Build Adapter
// TODO: CHANGE THE [[ to a less than, ]] to greater than.
        ArrayAdapter<String> adapter = new ArrayAdapter <String>( this,
                R.layout.da_item,
                myItems); // Context for the activity. R.layout.da_item, // Layout to use (create) myItems); // Items to be displayed // Configure the list view.
        ListView list=(ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
// TODO: CHANGE THE [[ to a less than, ]] to greater than.
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;

                //String message = "You clicked # " + position + ", which is string: " + textView.getText().toString(); Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

                if (position == 0) {
                    Intent i = new Intent(List.this, Genral.class);
                    startActivity(i);

                } else if (position == 1) {
                    Intent i = new Intent(List.this, iit.class);
                   startActivity(i);
                } else if (position == 2) {
                    Intent i = new Intent(List.this, aipmt.class);
                    startActivity(i);
                } else if (position == 3) {
                    Intent i = new Intent(List.this, bollywood.class);
                    startActivity(i);
                }
            }
        });

    }





}
