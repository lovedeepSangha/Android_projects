package com.example.lovedeepsangha.begninng;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); TextView Reigster_TextView=(TextView)findViewById(R.id.register_TextView);
        EditText Email_EditText=(EditText)findViewById(R.id.email_EditText);
        EditText Password_EditText=(EditText)findViewById(R.id.password_EditText);
        ImageButton LogIn_ImageButton=(ImageButton)findViewById(R.id.login_ImageButton);
        final ImageView logo=(ImageView)findViewById(R.id.logo_ImageView);
        ImageButton btn = (ImageButton) findViewById(R.id.login_ImageButton);
       

        Reigster_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });


    }



}
