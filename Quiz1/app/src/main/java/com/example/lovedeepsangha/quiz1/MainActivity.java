package com.example.lovedeepsangha.quiz1;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DatabaseHelper databaseHelper;

    EditText editName,editSurname,editMarks,editID;
    Button btnAddData,btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    databaseHelper=new DatabaseHelper(this);
        editName=(EditText)findViewById(R.id.editText_Name);
        editSurname=(EditText)findViewById(R.id.editText_Surename);
        editMarks=(EditText)findViewById(R.id.editText_Marks);
        btnAddData=(Button)findViewById(R.id.button_data);
btnViewData=(Button)findViewById(R.id.button_View);
        AddData();
        ViewData();
    }
    public void ViewData(){
        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = databaseHelper.getData();
                if (res.getCount() == 0){
showMessage("Error","no data available");
                    }
             else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()){
                        buffer.append("ID :- " + res.getString(0) + "\n");
                    buffer.append("Name :- " + res.getString(1) + "\n");
                    buffer.append("Surename :- " + res.getString(2) + "\n");
                    buffer.append("Marks :- " + res.getString(3) + "\n");
               showMessage("Data",buffer.toString());
                }}


            }
        });
    }
    public  void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             boolean isInserted =   databaseHelper.insertData(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
if (isInserted==true)
    Toast.makeText(MainActivity.this,"values inserted",Toast.LENGTH_SHORT).show();
                else
    Toast.makeText(MainActivity.this, "not inserted error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}