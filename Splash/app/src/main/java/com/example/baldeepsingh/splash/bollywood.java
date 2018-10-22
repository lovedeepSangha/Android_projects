package com.example.baldeepsingh.splash;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class bollywood extends AppCompatActivity {

    String ques;
    String a,b,c,d;
    TextView textView;
    Button ab,bb,cb,db;
    Integer incr=0;
    int chk=0;
    static int out = 0;
    String ans;
    int total = 0;
    BufferedReader bf[] = new BufferedReader[100];
    int bfin=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        Random random = new Random();
        Integer i = random.nextInt(9);
        incr = i;
        try {
            bf[bfin] = new BufferedReader(new FileReader(Environment.getExternalStorageDirectory()+"//quiz//bollywood//"+i.toString()+".log"));
            ques = bf[bfin].readLine();
            a =  bf[bfin].readLine();
            b =  bf[bfin].readLine();
            c =  bf[bfin].readLine();
            d =  bf[bfin].readLine();
            ans =  bf[bfin].readLine();
            textView = (TextView)findViewById(R.id.textView);
            textView.setText(ques);
            ab = (Button)findViewById(R.id.a);
            bb = (Button)findViewById(R.id.b);
            cb = (Button)findViewById(R.id.c);
            db = (Button)findViewById(R.id.d);
            ab.setText(a);
            bb.setText(b);
            cb.setText(c);
            db.setText(d);
            bf[bfin].close();

        }catch (Exception e){}
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent =new Intent(this,List.class);
        startActivity(intent);
        bollywood.out=0;
    }


    public  void  action(View v)
    {

        if (v.getId()==R.id.a)
        {


            if (ans.equals(ab.getText().toString()))

            {

                out = out + 10;
            }



        }
        if (v.getId()==R.id.b)
        {

            if (ans.equals(bb.getText().toString()))

            {

                out = out + 10;
            }

        }

        if (v.getId()==R.id.c)
        {
            if (ans.equals(cb.getText().toString()))

            {

                out = out + 10;
            }

        }
        if (v.getId()==R.id.d)
        {
            if (ans.equals(db.getText().toString()))

            {

                out = out + 10;
            }

        }


        if (incr==10)
        {
            incr=-1;

        }
        bfin++;
        chk++;
        incr++;
        if (chk<10) {
            try {
                bf[bfin] = new BufferedReader(new FileReader(Environment.getExternalStorageDirectory()+"//quiz//bollywood//"+incr.toString()+".log"));
                ques = bf[bfin].readLine();
                a = bf[bfin].readLine();
                b = bf[bfin].readLine();
                c = bf[bfin].readLine();
                d = bf[bfin].readLine();
                ans =  bf[bfin].readLine();
                textView = (TextView) findViewById(R.id.textView);
                textView.setText(ques);
                ab = (Button) findViewById(R.id.a);
                bb = (Button) findViewById(R.id.b);
                cb = (Button) findViewById(R.id.c);
                db = (Button) findViewById(R.id.d);
                ab.setText(a);
                bb.setText(b);
                cb.setText(c);
                db.setText(d);
                bf[bfin].close();

            } catch (Exception e) {
            }

        }else
        {
            //textView.setText("Result :-" + out + "Out Of :-" + "100");
            Intent intent = new Intent(this,result3.class);
            startActivity(intent);


        }


    }
}
