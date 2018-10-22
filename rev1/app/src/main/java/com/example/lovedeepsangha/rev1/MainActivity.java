package com.example.lovedeepsangha.rev1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=(EditText)findViewById(R.id.editText);
    button=(Button)findViewById(R.id.button); ImageView imageView= (ImageView) findViewById(R.id.imageView);
        imageView.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("text", editText.getText().toString());
            startActivity(intent);
                if(editText.getText().toString().equals(""))
                {

            }}
        });
    }


}
