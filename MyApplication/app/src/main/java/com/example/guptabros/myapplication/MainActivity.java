package com.example.guptabros.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float a, b, sum;
    int i=0;
boolean mAddition,msubtraction,mmultiply,mdivison,mpercent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final EditText text = (EditText) findViewById(R.id.edittext);

Button clear =(Button) findViewById(R.id.Clear);
        Button plus = (Button) findViewById(R.id.plus);
        Button percent = (Button) findViewById(R.id.percent);
        Button decimal = (Button) findViewById(R.id.decimal);
        Button minus = (Button) findViewById(R.id.minus);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);
        Button equalto = (Button) findViewById(R.id.equalto);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        decimal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                text.setText(text.getText() + ".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(null);
                mAddition=false;msubtraction=false;mmultiply=false;mdivison=false;mpercent=false;
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText() + "0");
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text == null) {
                    text.setText("");
                }
                switch (i){
                    case 0:
                        a = Float.parseFloat(text.getText() + "");

                        mAddition = true;
                        text.setText(null);
                        i=1;
                        break;
                    case 1:
                        a= a + Float.parseFloat(text.getText() + "");
                        text.setText(null);
                        i=0;
                        break;
                }
                /*if(i==0) {
                    a = Float.parseFloat(text.getText() + "");

                    mAddition = true;
                    text.setText(null);
                     i=1;


                }
                else {
                    a= a + Float.parseFloat(text.getText() + "");text.setText(null);

                }*/
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text == null) {
                    text.setText("");
                } else {
                    a = Float.parseFloat(text.getText() + "");

                    mpercent = true;
                    text.setText(null);
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text == null) {
                    text.setText("");
                } else {
                    a = Float.parseFloat(text.getText() + "");
                    msubtraction = true;

                    text.setText(null);
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text == null) {
                    text.setText("");
                } else {
                    a = Float.parseFloat(text.getText() + "");
                    mmultiply = true;

                    text.setText(null);
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (text == null) {
                    text.setText("");
                } else {
                    a = Float.parseFloat(text.getText() + "");
                    mdivison = true;

                    text.setText(null);
                }
            }
        });


        equalto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = Float.parseFloat(text.getText() + "");

                if (mAddition == true) {

                    text.setText(a + b + "");
                    mAddition = false;
                }
                if (msubtraction == true) {

                    text.setText(a - b + "");
                    msubtraction = false;
                }
                if (mdivison == true) {

                    text.setText(a / b + "");
                    mdivison = false;
                }
               if (mpercent == true){
                   text.setText((a / b)*100 + "");
                   mpercent=false;
               }
                if (mmultiply == true) {

                    text.setText(a * b + "");
                    mmultiply = false;
                }
            }
        });
    }}