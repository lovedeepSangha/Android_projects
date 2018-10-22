package com.example.lovedeepsangha.rev;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button,button1;
DatabaseHelper databaseHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
button1=(Button)findViewById(R.id.button_View);
    editText=(EditText)findViewById(R.id.editText_Name);
        button=(Button)findViewById(R.id.add_Data);
        addData();
        viewData();
        databaseHelper = new DatabaseHelper(this);

    }
    public void viewData(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=databaseHelper.GetData();
                if (res.getCount()==0){
showMessage("error","Not Available");
                    return;


                }
                else{
                    StringBuffer buffer=new StringBuffer();
                    while(res.moveToNext()){
                    buffer.append("Name is :- " + res.getString(0) + "\n");
showMessage("ok done",buffer.toString());
                }
            }}
        });
        }
   public void showMessage(String title,String message){
       AlertDialog.Builder builder=new AlertDialog.Builder(this);
       builder.setCancelable(true);
       builder.setTitle(title);
       builder.setMessage(message);
       builder.show();
   }
    public void addData(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
boolean isInserted= databaseHelper.insertData(editText.getText().toString());
                if (isInserted==true)
                    Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"by",Toast.LENGTH_LONG).show();
            }
        });
    }
}