package com.example.lovedeepsangha.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Context cxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void onclick(View view) {
        Button button = (Button) findViewById(R.id.Submit);
        TextView textView=(TextView)findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editText);
        String s = editText.getText().toString();
        int slength = s.length();
        if (s.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter Valid Name ", Toast.LENGTH_LONG).show();
        }
        if (slength <= 3) {
            Toast.makeText(MainActivity.this, "Please Enter Valid Name ", Toast.LENGTH_LONG).show();
        }
else{
DatabaseOperations db=new DatabaseOperations(cxt);
            db.putInformation(db,s);
            Toast.makeText(getBaseContext(), "Please Enter Valid Name ", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    }


